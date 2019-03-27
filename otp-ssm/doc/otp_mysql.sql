-- 消费者表/消费者收获地址

DROP TABLE IF EXISTS member_address;
DROP TABLE IF EXISTS member;

CREATE TABLE member(
id BIGINT auto_increment  NOT NULL  PRIMARY KEY,
member_name VARCHAR(256) UNIQUE,
member_pwd VARCHAR(20),
change_member_name INT, -- 0:未修改过，1：修改过
nickname VARCHAR(256),
sex INT,            -- 1:male,0:female
birthday TIMESTAMP,
image_data CHAR
);
ALTER TABLE member COMMENT '消费者表';
ALTER TABLE member MODIFY COLUMN id BIGINT COMMENT '账户ID';
ALTER TABLE member MODIFY COLUMN member_name VARCHAR(256) COMMENT '账户名称';
ALTER TABLE member MODIFY COLUMN member_pwd VARCHAR(20) COMMENT '账户密码';
ALTER TABLE member MODIFY COLUMN change_member_name INT COMMENT '是否修改过账户名称';
ALTER TABLE member MODIFY COLUMN nickname VARCHAR(256) COMMENT '会员昵称';
ALTER TABLE member MODIFY COLUMN sex INT COMMENT '性别';
ALTER TABLE member MODIFY COLUMN birthday TIMESTAMP COMMENT '出生日期';
ALTER TABLE member MODIFY COLUMN image_data CHAR COMMENT '会员头像';

-- 收货地址表
CREATE TABLE member_address(
id BIGINT auto_increment  NOT NULL  PRIMARY KEY COMMENT '收获地址ID',
member_id BIGINT COMMENT '会员ID',
name VARCHAR(256) COMMENT '收获人姓名',
phone_no VARCHAR(11) COMMENT '收货人手机号',
province VARCHAR(256) COMMENT '省',
city VARCHAR(256) COMMENT '市',
address_post_detail VARCHAR(256) COMMENT '详细后缀地址',
FOREIGN KEY(member_id) REFERENCES member(id)
)COMMENT='收货地址表' ;

commit;
