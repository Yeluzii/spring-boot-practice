package top.ychen.zhihu.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.ychen.zhihu.api.entity.Special;

import java.util.List;

@Mapper
public interface SpecialMapper {
    List<Special> selectAll();
    List<Special> selectByPage(int limit,int offset);
}
