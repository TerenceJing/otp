package controller.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import controller.dto.base.BaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc: 会员信息
 */
@Data
public class UserDTO extends BaseDTO {
    private Long id;
    /**
     * 会员账户名
     */
    private String userName;
    /**
     * 会员密码
     */
    private String password;
    /**
     * 是否修改过会员账户名，0：修改过，1：未修改过
     */
    private int changeUserName;
    /**
     * 性别，1:男,0:女,-1:未知
     */
    private String nickname;
    /**
     * 性别，1:男,0:女,-1:未知
     */
    private int sex = -1;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date birthday;
    private String imageData;

    private String operate;

}
