package top.ychen.springboot.task.jobs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.ychen.springboot.task.service.MailService;

import java.time.LocalDateTime;

//@Component
@AllArgsConstructor
@Slf4j
public class DailyReportTask {
    private final MailService mailService;

    @Scheduled(cron = "0 52 15 * * ?")
    public void sendReport() {
        String report = "这是每日数据报表的内容";
        mailService.sendMail("2317413623@qq.com", "每日数据报表", report);
        log.info("报表已生成，并发送邮件完成！{}",LocalDateTime.now());
    }
}
