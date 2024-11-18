package top.ychen.springboot.database.mapper;

import top.ychen.springboot.database.entity.Special;

import java.util.List;

public interface SpecialMapper {
    List<Special> findAll();
}
