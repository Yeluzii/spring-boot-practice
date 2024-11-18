package top.ychen.springboot.task.jobs;

import com.alibaba.excel.EasyExcel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import top.ychen.springboot.task.entity.Student;
import top.ychen.springboot.task.mapper.StudentMapper;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class ExportJob extends QuartzJobBean {
    protected final StudentMapper studentMapper;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("开始导出学生信息");
        List<Student> students = studentMapper.selectList(null);
        String fileName = "D:/后端学习/10.28后端/" + UUID.randomUUID() + ".xlsx";
        EasyExcel.write(fileName, Student.class).sheet("学生数据").doWrite(students);
        log.info("导出学生信息结束");
    }

}
