package top.ychen.springboot.task.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("stock_price")
public class StockPrice {
    private Long id;
    private String name;
    private Double price;
    private LocalDateTime updateTime;
}
