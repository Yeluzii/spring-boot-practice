package top.ychen.zhihu.api.service.Impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.ychen.zhihu.api.entity.Special;
import top.ychen.zhihu.api.mapper.SpecialMapper;
import top.ychen.zhihu.api.service.SpecialService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SpecialServiceImpl implements SpecialService {
    @Resource
    public SpecialMapper specialMapper;


    @Override
    public List<Special> getAll() {
        List<Special> specials = specialMapper.selectAll();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        specials.forEach(special -> {
            // 时间戳单位是秒，加上000，变成毫秒，生成Date对象，再格式化
            String format = df.format(new Date(Long.parseLong(special.getUpdated() + "000")));
            special.setUpdated(format);
        });
        return specials;
    }

    @Override
    public List<Special> getByPage(int limit, int offset) {
        return specialMapper.selectByPage(limit, offset);
    }
}
