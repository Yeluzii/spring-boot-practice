package top.ychen.springboot.database.mapper;

import top.ychen.springboot.database.entity.Teacher;

public interface TeacherMapper {
    Teacher findTeacherById(Integer teacherId);
}
