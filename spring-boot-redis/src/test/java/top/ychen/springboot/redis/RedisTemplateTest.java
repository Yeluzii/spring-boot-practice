package top.ychen.springboot.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import top.ychen.springboot.redis.entity.Address;
import top.ychen.springboot.redis.entity.Student;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTemplateTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Student> redisTemplate;

    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().set("hello", "world",60, TimeUnit.SECONDS);
        System.out.println(stringRedisTemplate.opsForValue().get("hello"));
    }

    @Test
    public void test02() {
        Address address = Address.builder().province("江苏").city("南京").build();
        Student student = Student.builder().id("123").name("张三").address(address).build();
        redisTemplate.opsForValue().set("student", student);
    }
}
