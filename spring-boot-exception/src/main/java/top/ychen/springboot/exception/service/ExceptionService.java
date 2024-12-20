package top.ychen.springboot.exception.service;

import org.springframework.stereotype.Service;
import top.ychen.springboot.exception.exception.ServerException;

@Service
public class ExceptionService {
    public void unAuthorizedError(){
        throw new ServerException("没有登录");
    }
    public void systemError(){
        throw new ServerException("系统异常");
    }
}
