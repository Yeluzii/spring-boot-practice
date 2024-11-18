package top.ychen.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.ychen.springboot.quickstart.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final List<User> users = List.of(
            new User(1L, "张三",22),
            new User(1L, "张三2",16),
            new User(1L, "李四",22),
            new User(1L, "张三4",19),
            new User(1L, "王五",22)
    );

    public List<String> getAdultsUserName(String initial) {
        return users.stream()
                .filter(user -> user.getAge() > 18)
                .map(User::getName)
                .map(String::trim) // 去除空格
                .filter(name -> initial == null || name.startsWith(initial))
                .collect(Collectors.toList());
    }
}
