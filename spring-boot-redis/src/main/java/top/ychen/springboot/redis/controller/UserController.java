package top.ychen.springboot.redis.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.ychen.springboot.redis.cache.TokenStoreCache;
import top.ychen.springboot.redis.enums.ErrorCode;
import top.ychen.springboot.redis.exception.ServerException;
import top.ychen.springboot.redis.result.Result;
import top.ychen.springboot.redis.service.UserService;
import top.ychen.springboot.redis.utils.JwtUtil;
import top.ychen.springboot.redis.vo.UserInfoVO;
import top.ychen.springboot.redis.vo.UserLoginVO;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenStoreCache tokenStoreCache;

    @PostMapping("/login")
    @Operation(summary = "手机短信登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        return Result.ok(userService.loginByPhone(phone, code));
    }

    @GetMapping("info")
    @Operation(summary = "查询用户信息")
    public Result<UserInfoVO> getUserInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String accessToken = JwtUtil.getAccessToken(request);
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        if(!JwtUtil.validate(accessToken)){
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        UserLoginVO user = tokenStoreCache.getUser(accessToken);
        if (ObjectUtils.isEmpty(user)) {
            throw new ServerException(ErrorCode.LOGIN_STATUS_EXPIRED);
        }
        return Result.ok(userService.userInfo(user.getPkId()));
    }
}
