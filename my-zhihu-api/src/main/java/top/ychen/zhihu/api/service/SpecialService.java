package top.ychen.zhihu.api.service;

import top.ychen.zhihu.api.entity.Special;

import java.util.List;

public interface SpecialService {
    List<Special> getAll();
    List<Special> getByPage(int limit,int offset);
}

