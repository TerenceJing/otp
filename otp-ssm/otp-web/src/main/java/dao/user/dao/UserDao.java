package dao.user.dao;

import dao.user.entity.Address;
import dao.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @desc:
 */
public interface UserDao {
    Long checkUserByName(@Param("userName") String userName);

    int updateUser(User member);
    int addUser(User member);

    User queryUserDetailByName(@Param("userName") String userName);
    int addAddress(Address address);
    List<Address>  getAddressListByUserId(@Param("userId")Long userId);
}

