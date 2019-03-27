package errorcode;

/**
 * @author: jingtiancai
 * @date: 2018/9/17 18:15
 * @desc:
 */
public enum ErrorCode {
    SUCCESS("0", "成功", "Success"),
    FAILED("0x00000001", "失败", "Failed"),
    UNKNOW_ERROR("0x01a00102", "未知错误", "Unknow error"),
    DB_ERROR("0x01a00103", "数据库操作失败", "DataBase Error"),
    /*==================================用户================================*/
    USER_REGISTER_FAILED("0x01a00201", "注册会员失败", "Add user failed"),
    USER_REGISTER_NAME_REPEAT_FAILED("0x01a00202", "添加会员失败,注册账号名重复", "Register user failed with the repetitive name"),
    USER_ADDRESS_ADD_FAILE("0x01a00203", "添加会员地址失败", "Add user address failed"),
    USER_QUERY_FAILED("0x01a00204", "查询会员失败", "Query user failed"),
    USER_UPDATE_FAILED("0x01a00205", "查询更新失败", "Update user failed"),
    /*==================================商品===============================*/
    GOOD_CATEGORY_QUERY_FAILED("0x01a00301", "获取商品分类失败", "Get good categories failed"),
    GOOD_CATEGORY_ADD_FAILED("0x01a00302", "添加商品分类失败", "Add good category failed"),
    GOOD_DETAIL_ADD_FAILED("0x01a00303", "添加商品失败", "Add good failed"),
    GOOD_QUERY_FAILED("0x01a00304", "添加商品失败", "Add good failed"),
    /*==================================购物================================*/
    ORDER_ADD_FAILED("0x01a00401", "生成订单失败", "Add order failed"),
    ORDER_DELTE_FAILED("0x01a00402", "批量删除订单失败", "Bath delete order failed"),
    ORDER_QUERY_FAILED("0x01a00403", "查询订单失败", "Query order failed"),
    CART_ADD_FAILED("0x01a00404", "添加商品到购物车失败", "Add good to cart failed"),
    CART_DELETE_FAILED("0x01a00405", "批量删除购物车商品失败", "Bath goods in cart failed"),
    CART_QUERY_FAILED("0x01a00406", "查询购物车商品失败", "Query good in cart failed"),

    ;


    private String code;
    private String label;
    private String msg;

    ErrorCode(String code, String label, String msg) {
        this.code = code;
        this.label = label;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorCodeC ec(Object... args) {
        return new ErrorCodeC(this.getCode(), this.getLabel(), this.getMsg());
    }
}
