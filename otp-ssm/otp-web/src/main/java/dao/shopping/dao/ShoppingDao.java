package dao.shopping.dao;

import dao.shopping.entity.GoodOrder;
import dao.shopping.entity.ShoppingCartGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingDao {
    /**
     * 添加商品到购物车
     */
    int addShoppingCartGood(ShoppingCartGood shoppingCartGood);
    /**
     * 批量删除购物车中的商品
     */
    int bathDeleteShoppingCartGoods(List<Long> shoppingCartIds);
    /**
     * 查询购物车中的商品列表
     */
    List<ShoppingCartGood> queryShoppingCartGoods(@Param("userId") Long userId);
    /**
     * 提交订单后生成订单
     */
    int addGoodOrder(GoodOrder goodOrder);
    /**
     * 批量删除订单
     */
    int bathDeleteGoodOrders(List<Long> orderIds);
    /**
     * 根据用户批量查询订单
     */
    List<GoodOrder> queryGoodOrder(Long userId);

}
