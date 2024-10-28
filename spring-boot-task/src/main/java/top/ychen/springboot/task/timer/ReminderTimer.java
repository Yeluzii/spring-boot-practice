package top.ychen.springboot.task.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class ReminderTimer {
    public static void main(String[] args) {
        // 定时器
        Timer timer = new Timer();
        // 任务 task
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                // 要做的事情
                log.info("请休息一下，喝口水吧！");
            }
        };
        // 每隔5秒
        timer.schedule(task, 0,5000);
    }
}