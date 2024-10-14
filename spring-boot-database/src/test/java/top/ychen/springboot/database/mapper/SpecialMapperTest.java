package top.ychen.springboot.database.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.ychen.springboot.database.entity.Special;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;

    @Test
    void findAll() {
        List<Special> specials = specialMapper.findAll();
        specials.forEach(special -> log.info("{},{}", special.getId(), special.getTitle()));
    }
}