package service.shopping;

import controller.dto.base.ResponseDTO;
import dao.shopping.dao.ShoppingDao;
import dao.shopping.entity.GoodOrder;
import dao.shopping.entity.ShoppingCartGood;
import errorcode.ErrorCode;
import handler.OtpHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: jingtiancai
 * @date: 2018/11/11 15:35
 * @desc:
 */
@Service
public class ShoppingService {
    @Autowired
    private ShoppingDao shoppingDao;

    private OtpHandler otpHandler=new OtpHandler();
    /**
     * 添加商品到购物车类别
     */
    public ResponseDTO addShoppingCartGood( ShoppingCartGood shoppingCartGood) {
        shoppingCartGood.setCreateTime(new Date());
        try{
            if (1 != shoppingDao.addShoppingCartGood(shoppingCartGood)) {
                return ResponseDTO.fail(ErrorCode.CART_ADD_FAILED.ec());
            }
            return ResponseDTO.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.CART_ADD_FAILED.ec().append(e.getCause().getMessage()));
        }
    }
    /**
     * 批量删除购物车中的商品
     */
    public ResponseDTO bathDeleteShoppingCartGoods( String shoppingCartIds) {
        try{
            List<Long> ids= StringUtils.str2NumList(shoppingCartIds);
            shoppingDao.bathDeleteShoppingCartGoods(ids);
            return ResponseDTO.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.CART_DELETE_FAILED.ec().append(e.getCause().getMessage()));
        }
    }
    /**
     * 查询购物车中的商品
     */
    @Transactional
    public ResponseDTO queryShoppingCartGoods(Long userId) {
        try{
            List<ShoppingCartGood> shoppingCartGood=shoppingDao.queryShoppingCartGoods(userId);
            return ResponseDTO.success(shoppingCartGood);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.CART_QUERY_FAILED.ec().append(e.getCause().getMessage()));
        }
    }

    /*===================================订单=======================================*/
    /**
     * 提交订单后生成订单
     */
    public ResponseDTO addGoodOrder(GoodOrder goodOrder) {
        try{
            //创建时间
            goodOrder.setCreateTime(new Date());
            //生成编号
            String orderIndexCode=otpHandler.getOrderIndexCode(goodOrder.getUserId(),goodOrder.getCreateTime(),goodOrder.getGoodId());
            goodOrder.setOrderIndexCode(orderIndexCode);
            if (1 != shoppingDao.addGoodOrder(goodOrder)) {
                return ResponseDTO.fail(ErrorCode.ORDER_ADD_FAILED.ec());
            }
            return ResponseDTO.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.ORDER_ADD_FAILED.ec().append(e.getMessage()));
        }
    }
    /**
     * 批量删除订单
     */
    public ResponseDTO bathDeleteGoodOrders(String orderIds) {
        try{
            List<Long> orderList= StringUtils.str2NumList(orderIds);
             shoppingDao.bathDeleteGoodOrders(orderList);
            return ResponseDTO.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.ORDER_DELTE_FAILED.ec().append(e.getCause().getMessage()));
        }
    }

    /**
     * 根据用户批量查询订单
     */
    public ResponseDTO<List<GoodOrder>> queryGoodOrder(String userId) {
        try{
            Long id=Long.parseLong(userId);
            List<GoodOrder> orders= shoppingDao.queryGoodOrder(id);
            return ResponseDTO.success(orders);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.ORDER_QUERY_FAILED.ec().append(e.getMessage()));
        }
    }
}
