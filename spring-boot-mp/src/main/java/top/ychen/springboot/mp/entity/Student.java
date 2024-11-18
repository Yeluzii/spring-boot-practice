package top.ychen.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private Long clazzId;

    @TableField(exist = false)
    private List<Course> courses;
}
