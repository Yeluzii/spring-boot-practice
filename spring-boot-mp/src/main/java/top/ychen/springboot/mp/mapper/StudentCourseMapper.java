package top.ychen.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.ychen.springboot.mp.entity.Course;

import java.util.List;

public interface StudentCourseMapper extends BaseMapper<Course> {
    @Select("SELECT c.* FROM course c INNER JOIN student_course sc ON c.id = sc.course_id WHERE sc.student_id = #{studentId}")
    List<Course> selectCoursesByStudentId(Long studentId);
}
