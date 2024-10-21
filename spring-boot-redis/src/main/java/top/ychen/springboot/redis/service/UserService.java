package top.ychen.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ychen.springboot.redis.entity.User;
import top.ychen.springboot.redis.vo.UserInfoVO;
import top.ychen.springboot.redis.vo.UserLoginVO;

public interface UserService extends IService<User> {
    UserLoginVO loginByPhone(String phone, String code);
    boolean checkUserEnabled(Long userId);
    UserInfoVO userInfo(Long userId);
}
