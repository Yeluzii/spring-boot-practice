package top.ychen.springboot.mp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.ychen.springboot.mp.entity.User;
import top.ychen.springboot.mp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    @Resource
    private final UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        boolean result = userService.createUser(user);
        return result ? "用户创建成功" : "用户创建失败";
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        boolean result = userService.updateUser(user);
        return result ? "用户更新成功" : "用户更新失败";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean result = userService.deleteUserById(id);
        return result ? "用户删除成功" : "用户删除失败";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/name")
    public List<User> getUsersByName(@RequestParam String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/page")
    public Page<User> getUserByPage(@RequestParam int currentPage, @RequestParam int pageSize) {
        return userService.getUserByPage(currentPage, pageSize);
    }
}
