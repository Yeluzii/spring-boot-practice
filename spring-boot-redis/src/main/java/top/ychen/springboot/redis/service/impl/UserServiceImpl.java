package top.ychen.springboot.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.ychen.springboot.redis.cache.TokenStoreCache;
import top.ychen.springboot.redis.config.RedisCache;
import top.ychen.springboot.redis.config.RedisKeys;
import top.ychen.springboot.redis.entity.User;
import top.ychen.springboot.redis.enums.AccountStatusEnum;
import top.ychen.springboot.redis.enums.ErrorCode;
import top.ychen.springboot.redis.exception.ServerException;
import top.ychen.springboot.redis.mapper.UserMapper;
import top.ychen.springboot.redis.service.UserService;
import top.ychen.springboot.redis.utils.JwtUtil;
import top.ychen.springboot.redis.vo.UserInfoVO;
import top.ychen.springboot.redis.vo.UserLoginVO;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;
    @Override
    public UserLoginVO loginByPhone(String phone, String code) {
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.toString().equals(code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        redisCache.delete(smsCacheKey);
        User user = baseMapper.getByPhone(phone);
        if (ObjectUtils.isEmpty(user)) {
            log.info("用户不存在，创建用户, phone: {}", phone);
            user = new User();
            user.setNickname(phone);
            user.setPhone(phone);
            user.setAvatar("https://yeluzi-pic-go.oss-cn-hangzhou.aliyuncs.com/md/202410161813754.png");
            user.setGender(0);
            user.setEnabled(1);
            user.setBonus(100);
            user.setDeleteFlag(0);
            user.setRemark("这个人很懒，什么都没有写");
            baseMapper.insert(user);
        }
        if (!user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue())) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
        String accessToken = JwtUtil.createToken(user.getPkId());
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setPkId(user.getPkId());
        userLoginVO.setPhone(user.getPhone());
        userLoginVO.setAccessToken(accessToken);
        tokenStoreCache.saveUser(accessToken, userLoginVO);
        return userLoginVO;
    }

    @Override
    public boolean checkUserEnabled(Long userId) {
        User user = baseMapper.selectById(userId);
        if (ObjectUtils.isEmpty(user)) {
            return false;
        }
        return user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue());
    }

    @Override
    public UserInfoVO userInfo(Long userId) {
        User user = baseMapper.selectById(userId);
        if (user == null){
            log.error("用户不存在，userId: {}", userId);
            throw new ServerException(ErrorCode.USR_NOT_EXIST);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);
        return userInfoVO;
    }
}
