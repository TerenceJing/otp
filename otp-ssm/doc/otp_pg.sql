--消费者表/消费者收获地址
DROP SEQUENCE IF EXISTS S_user_detail_id;
DROP SEQUENCE IF EXISTS S_user_address_id;

CREATE SEQUENCE S_user_detail_id
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999
CYCLE;
CREATE SEQUENCE S_user_address_id
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999
CYCLE;

DROP TABLE IF EXISTS user_address;
DROP TABLE IF EXISTS user_detail;

CREATE TABLE user_detail(
id BIGINT PRIMARY KEY,
user_name VARCHAR(256) UNIQUE,
user_pwd VARCHAR (20),
change_user_name INT,--0:未修改过，1：修改过
nickname VARCHAR(256),
sex INT,            --1:male,0:female
birthday TIMESTAMP,
image_data VARCHAR
);
COMMENT ON TABLE user_detail IS '会员表';
COMMENT ON COLUMN user_detail.id IS '会员ID';
COMMENT ON COLUMN user_detail.user_name IS '账户名称';
COMMENT ON COLUMN user_detail.user_pwd IS '账户密码';
COMMENT ON COLUMN user_detail.change_user_name IS '是否修改过会员账户名，1：修改过，0：未修改过';
COMMENT ON COLUMN user_detail.nickname IS '会员昵称';
COMMENT ON COLUMN user_detail.sex IS '性别,1:男,0:女,-1:未知';
COMMENT ON COLUMN user_detail.birthday IS '出生日期';
COMMENT ON COLUMN user_detail.image_data IS '会员头像';


--收货地址表
CREATE TABLE user_address(
id BIGINT PRIMARY KEY,
user_id BIGINT ,
name VARCHAR(256),
phone_no VARCHAR(11),
province VARCHAR(256),
city VARCHAR(256),
address_post_detail VARCHAR(256),
FOREIGN KEY(user_id) REFERENCES user_detail(id)
);
COMMENT ON TABLE user_address IS '收货地址表';
COMMENT ON COLUMN user_address.id IS '收获地址ID';
COMMENT ON COLUMN user_address.user_id IS '会员ID';
COMMENT ON COLUMN user_address.name IS '收获人姓名';
COMMENT ON COLUMN user_address.phone_no IS '收货人手机号';
COMMENT ON COLUMN user_address.province IS '省';
COMMENT ON COLUMN user_address.city IS '市';
COMMENT ON COLUMN user_address.address_post_detail IS '详细后缀地址';

-- ==================商品================
DROP SEQUENCE IF EXISTS S_good_category_id;
DROP SEQUENCE IF EXISTS S_good_detail_id;

CREATE SEQUENCE S_good_category_id
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999
CYCLE;
CREATE SEQUENCE S_good_detail_id
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999
CYCLE;

DROP TABLE IF EXISTS good_detail;
DROP TABLE IF EXISTS good_category;

-- 商品分类
CREATE TABLE good_category(
id BIGINT PRIMARY KEY,
category_name varchar(50) NOT NULL UNIQUE,
create_time timestamp NOT NULL default CURRENT_TIMESTAMP
);
COMMENT ON TABLE good_category IS '商品分类表';
COMMENT ON COLUMN good_category.id IS '商品分类id';
COMMENT ON COLUMN good_category.category_name IS '商品分类名称';
COMMENT ON COLUMN good_category.create_time IS '商品分类创建时间';
-- 商品表
CREATE TABLE good_detail(
id BIGINT PRIMARY KEY,
good_name varchar(50) NOT NULL,
type BIGINT NOT NULL,
history_price decimal(18,3),
current_price decimal(18,3) NOT NULL,
good_num INT NOT NULL,
good_desc VARCHAR,
image_url VARCHAR,
create_time timestamp NOT NULL default CURRENT_TIMESTAMP,
saled_num int,
evaluate_num int,
);
COMMENT ON TABLE good_detail IS '商品表';
COMMENT ON COLUMN good_detail.id IS '商品id';
COMMENT ON COLUMN good_detail.good_name IS '商品名称';
COMMENT ON COLUMN good_detail.type IS '商品所属分类';
COMMENT ON COLUMN good_detail.history_price IS '商品历史价格';
COMMENT ON COLUMN good_detail.current_price IS '商品目前价格';
COMMENT ON COLUMN good_detail.good_num IS '商品库存';
COMMENT ON COLUMN good_detail.good_desc IS '商品描述';
COMMENT ON COLUMN good_detail.image_url IS '商品样图url';
COMMENT ON COLUMN good_detail.create_time IS '商品创建时间';
COMMENT ON COLUMN good_detail.saled_num IS '销售数量';
COMMENT ON COLUMN good_detail.evaluate_num IS '累计评价';


-- ==============购物表===================
-- 订单表
DROP SEQUENCE IF EXISTS S_good_order_id;
CREATE SEQUENCE S_good_order_id
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999
CYCLE;
DROP TABLE IF EXISTS good_order;
-- 订单表
CREATE TABLE good_order(
id BIGINT PRIMARY KEY,
user_id BIGINT NOT NULL,
order_indexcode varchar(50) NOT NULL,
num int,
order_price decimal(18,3),
create_time timestamp NOT NULL default CURRENT_TIMESTAMP,
pay_time Date,
deliver_time Date
);
COMMENT ON TABLE good_order IS '订单表';
COMMENT ON COLUMN good_order.id IS '订单id';
COMMENT ON COLUMN good_order.user_id IS '用户id(不能为空)';
COMMENT ON COLUMN good_order.order_indexcode IS '订单编号（日期+商品分类id+商品Id+随机数）';
COMMENT ON COLUMN good_order.num IS '购买商品数量';
COMMENT ON COLUMN good_order.order_price IS '订单总价';
COMMENT ON COLUMN good_order.create_time IS '订单创建时间';
COMMENT ON COLUMN good_order.pay_time IS '订单支付时间';
COMMENT ON COLUMN good_order.deliver_time IS '订单发货时间';

DROP SEQUENCE IF EXISTS S_shopping_cart_id;
CREATE SEQUENCE S_shopping_cart_id
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999
CYCLE;
-- 购物车表
DROP TABLE IF EXISTS shopping_cart;
CREATE TABLE shopping_cart(
id BIGINT PRIMARY KEY,
user_id BIGINT,
good_id BIGINT NOT NULL,
good_name varchar(50) NOT NULL,
good_price decimal(18,3),
num int,
good_image char,
create_time timestamp NOT NULL default CURRENT_TIMESTAMP
);
COMMENT ON TABLE shopping_cart IS '购物车';
COMMENT ON COLUMN shopping_cart.id IS '加购id';
COMMENT ON COLUMN shopping_cart.user_id IS '用户id';
COMMENT ON COLUMN shopping_cart.good_id IS '商品id';
COMMENT ON COLUMN shopping_cart.good_name IS '商品名称';
COMMENT ON COLUMN shopping_cart.good_price IS '商品价格';
COMMENT ON COLUMN shopping_cart.num IS '加购数量';
COMMENT ON COLUMN shopping_cart.good_image IS '商品图片';
COMMENT ON COLUMN shopping_cart.create_time IS '加购时间';

commit;

