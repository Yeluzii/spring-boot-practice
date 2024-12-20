package top.ychen.springboot.mp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.ychen.springboot.mp.entity.Course;
import top.ychen.springboot.mp.entity.Student;
import top.ychen.springboot.mp.mapper.StudentCourseMapper;
import top.ychen.springboot.mp.mapper.StudentMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentCourseMapper studentCourseMapper;

    public Student getStudentWithCourses(Long studentId) {
        Student student = studentMapper.selectById(studentId);
        if (student != null) {
            List<Course> courses = studentCourseMapper.selectCoursesByStudentId(studentId);
            student.setCourses(courses);
        }
        return student;
    }
}
