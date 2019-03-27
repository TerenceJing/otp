package controller;

import controller.dto.base.ResponseDTO;
import dao.product.entity.GoodCategoryDTO;
import dao.shopping.entity.GoodOrder;
import dao.shopping.entity.ShoppingCartGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.shopping.ShoppingService;

import java.util.List;

@Controller
@RequestMapping(ApiPathDef.SHOPPING)
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;
    /**
     * 添加商品到购物车
     */
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO addShoppingCartGood(@RequestBody ShoppingCartGood shoppingCartGood) {

        return shoppingService.addShoppingCartGood(shoppingCartGood);
    }
    /**
     * 批量删除购物车中的商品
     */
    @RequestMapping(value = "/shoppingCart/{shoppingCartIds}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseDTO bathDeleteShoppingCartGood(@PathVariable("shoppingCartIds") String shoppingCartIds){
        return shoppingService.bathDeleteShoppingCartGoods( shoppingCartIds);
    }
    /**
     * 查询购物车中的商品
     */
    @RequestMapping(value = "/shoppingCart/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO<List<ShoppingCartGood>> queryShoppingCartGoods(@PathVariable("userId") Long userId) {

        return shoppingService.queryShoppingCartGoods(userId);
    }

    /**
     * 提交订单后生成订单
     */
    @RequestMapping(value = "/goodOrder", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO addGoodOrder(@RequestBody GoodOrder goodOrder) {

        return shoppingService.addGoodOrder(goodOrder);
    }
    /**
     * 批量删除订单
     */
    @RequestMapping(value = "/goodOrder/{orderIds}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseDTO bathDeleteGoodOrders(@PathVariable("orderIds")String orderIds) {

        return shoppingService.bathDeleteGoodOrders(orderIds);
    }

    /**
     * 根据用户批量查询订单
     */
    @RequestMapping(value = "/queryGoodOrders/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO<List<GoodOrder>> queryGoodOrder(@PathVariable("userId") String userId) {
        return shoppingService.queryGoodOrder(userId);
    }

}
