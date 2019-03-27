package dao.shopping.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class GoodOrder {
    /**订单Id*/
    private Long id;
    /**用户Id*/
    private Long userId;
    /**订单编号*/
    private String orderIndexCode;
    /**商品Id*/
    private Long goodId;
    /**商品名称*/
    private String goodName;
    /**购买数量*/
    private int num;
    /**订单总价*/
    private Double orderPrice;
    /**订单生成时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date createTime;
    /**支付时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date payTime;
    /**发货时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date deliverTime;

}
