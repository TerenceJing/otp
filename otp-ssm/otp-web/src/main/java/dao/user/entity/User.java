package dao.user.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @desc: 会员
 */
@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private int changeUserName;
    private String nickname;
    private int sex;
    private Date birthday;
    private String imageData;
    private List<Address> addressList;
    //电话
    private String phone;

    //积分
    private int cord;
    //礼品卡数量
    private int presentNumber;


}
