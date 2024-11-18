package top.ychen.springboot.mp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ychen.springboot.mp.entity.Clazz;
import top.ychen.springboot.mp.service.ClazzService;

@RestController
@RequestMapping("/clazz")
@AllArgsConstructor
public class ClazzController {
    private final ClazzService clazzService;

    @GetMapping("/{id}")
    public Clazz getClassNameById(@PathVariable Long id) {
        return clazzService.getClazzWithTeacher(id);
    }
}
