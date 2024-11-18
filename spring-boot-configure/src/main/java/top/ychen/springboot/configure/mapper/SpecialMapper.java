package top.ychen.springboot.configure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.ychen.springboot.configure.entity.Special;

import java.util.List;

@Mapper
public interface SpecialMapper {
    @Select("select * from list ORDER BY updated DESC ")
    List<Special> findAll();
}
