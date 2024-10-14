package top.ychen.springboot.database.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.ychen.springboot.database.entity.Course;
import top.ychen.springboot.database.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void getCourse() {
        Course course = courseMapper.getCourse(20001);
        log.info("查询课程：{}", course);
        List<Student> students = course.getStudents();
        log.info("学生列表：");
        students.forEach(student -> log.info("{},{},{}", student.getStudentId(), student.getStudentName(), student.getHometown()));
    }
}