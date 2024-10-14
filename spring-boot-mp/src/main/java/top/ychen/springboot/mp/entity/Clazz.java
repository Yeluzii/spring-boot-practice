package top.ychen.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;

    @TableField(exist = false)
    private Teacher teacher;
}
