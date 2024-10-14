package top.ychen.springboot.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.ychen.springboot.mp.mapper")
public class SpringBootMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMpApplication.class, args);
    }

}
