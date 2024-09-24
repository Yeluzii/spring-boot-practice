package top.ychen.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerTest {
    @Resource
    private Server server;
    @Test
    void testServer() {
        System.out.println(server);
    }

}