package top.ychen.springboot.task.jobs;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.ychen.springboot.task.entity.StockPrice;
import top.ychen.springboot.task.mapper.StockPriceMapper;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

//@Component
@AllArgsConstructor
public class StockPriceTask {
    private static final Logger log = LoggerFactory.getLogger(StockPriceTask.class);
    private final StockPriceMapper stockPriceMapper;

    private final Random random = new Random();

    @Scheduled(fixedRate = 3000)
    public void updateStockPrice() {
        double price = 100 + random.nextDouble() * 50;
        DecimalFormat df = new DecimalFormat("0.00");
        String formattedPrice = df.format(price);
        StockPrice stockPrice = new StockPrice();
        stockPrice.setPrice(Double.valueOf(formattedPrice));
        stockPrice.setName("小米");
        stockPrice.setUpdateTime(LocalDateTime.now());

        // 插入数据库
        stockPriceMapper.insert(stockPrice);
        log.info("股票价格已更新：{},时间：{}",formattedPrice,LocalDateTime.now());
    }

}
