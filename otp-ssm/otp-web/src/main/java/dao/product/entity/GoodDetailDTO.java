package dao.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品详情
 */
@Data
public class GoodDetailDTO {
    /**
     *商品id
     */
    private Long id;
    /**
     *商品名称
     */
    private String goodName;
    /**
     *商品所属分类
     */
    private Long type;
    /**
     *商品历史价格
     */
    private Double historyPrice;
    /**
     *商品目前价格
     */
    private Double currentPrice;
    /**
     *商品库存
     */
    private int goodNum;
    /**
     *商品描述
     */
    private String goodDesc;
    /**
     *商品创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    /**
     * 销售数量
     */
    private int saledNum;
    /**
     * 累计评价
     */
    private int evaluateNum;
    /**
     *商品样图url
     */
    private String imageUrl;
    /**
     *商品样图url
     */
    private String imageUrl2;
    /**
     *商品样图url
     */
    private String imageUrl3;
    /**
     *商品样图url
     */
    private String imageUrl4;
    /**
     *商品样图url
     */
    private String imageUrl5;

}
