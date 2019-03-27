package dao.shopping.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ShoppingCartGood {
    private Long id;
    private Long userId;
    private Long goodId;
    private String goodName;
    private Double goodPrice;
    private int num;
    private String goodImage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date createTime;
}
