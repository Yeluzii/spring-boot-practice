package top.ychen.springboot.database.mapper;

import top.ychen.springboot.database.entity.Clazz;

public interface ClazzMapper {
    Clazz getClazzById(int clazzId);

    Clazz getClazz(int clazzId);
}
