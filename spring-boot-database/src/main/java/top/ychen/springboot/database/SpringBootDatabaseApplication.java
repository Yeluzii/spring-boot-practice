package top.ychen.springboot.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.ychen.springboot.database.mapper")
public class SpringBootDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseApplication.class, args);
    }

}
