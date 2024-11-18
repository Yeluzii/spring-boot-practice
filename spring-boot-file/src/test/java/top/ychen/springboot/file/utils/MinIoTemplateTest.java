package top.ychen.springboot.file.utils;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

@SpringBootTest
@Slf4j
class MinIoTemplateTest {
    @Resource
    private MinIoTemplate minIoTemplate;

    @Test
    void bucketExists() throws Exception {
        // 判断是否有 avatar 这个存储桶存在
        boolean flag = minIoTemplate.bucketExists("avatar");
        log.info(String.valueOf(flag));
    }

    @Test
    void makeBucket() throws Exception {
        // 创建一个名为 ychen 的存储桶
        minIoTemplate.makeBucket("ychen2");
    }

    @Test
    void putObject() throws Exception {
        File file  = new File("D:/uploads/1729587578844_xeno1d.png");
        String url = minIoTemplate.putObject("ychen", "test" + UUID.randomUUID() + ".png", new FileInputStream(file));
        log.info(url);
    }

    @Test
    void removeObject() throws Exception {
        // 移除指定的文件（存在）
        minIoTemplate.removeObject("ychen", "img/test.jpg");
    }
}