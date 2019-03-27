package service.user;

import controller.dto.user.AddressDTO;
import controller.dto.user.UserDTO;
import dao.user.dao.UserDao;
import dao.user.entity.Address;
import dao.user.entity.User;
import controller.dto.base.ResponseDTO;
import errorcode.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.BeanUtils;
import utils.StringUtils;

import java.util.List;

/**
 * @author: jingtiancai
 * @date: 2018/9/17 15:12
 * @desc:
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * @author: jingtiancai  2018/9/18 14:24
     * @desc: 检查注册账户名是否重复
     * @return:
     */
    public ResponseDTO checkUserNameRepetitive(String name) {
        try {
            if (StringUtils.isBlank(name)) {
                return ResponseDTO.fail(ErrorCode.FAILED.ec(), "Please input name");
            }
            Long id = userDao.checkUserByName(name);
            if (null != id) {
                return ResponseDTO.fail(ErrorCode.USER_REGISTER_NAME_REPEAT_FAILED.ec());
            }
            return ResponseDTO.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.DB_ERROR.ec());
        }
    }

    /**
     * @author: jingtiancai  2018/9/18 14:35
     * @desc: 注册,修改会员
     * @return:
     */
    public ResponseDTO addUser(UserDTO user) {
        User userDO = new User();
        try {
            BeanUtils.copyAttr(user, userDO);
            //修改会员
            if(StringUtils.isNotBlank(user.getOperate())&&user.getOperate().equals("update")){
                int i= userDao.updateUser(userDO);
                if (1 == i) {
                    return ResponseDTO.success(null);
                }else{
                    return ResponseDTO.fail(ErrorCode.USER_UPDATE_FAILED.ec());
                }
            }

            //添加会员
//      检查姓名是否重复
            ResponseDTO responseDTO = checkUserNameRepetitive(userDO.getUserName());
            if (!responseDTO.isSuccess()) {
                return responseDTO;
            }
            int i = userDao.addUser(userDO);
            if (1 != i) {
                return ResponseDTO.fail(ErrorCode.USER_REGISTER_FAILED.ec());
            }
            return ResponseDTO.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.DB_ERROR.ec());
        }
    }

    /**
     * @author: jingtiancai  2018/9/18 17:20
     * @desc: 查询用户详情
     * @return:
     */
    public ResponseDTO queryUserDetailByName(final String userName) {
        try {
            User user = userDao.queryUserDetailByName(userName);
            if(user==null){
                return ResponseDTO.fail(ErrorCode.USER_QUERY_FAILED.ec());
            }
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyAttr(user, userDTO);
            return ResponseDTO.success(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.DB_ERROR.ec());
        }
    }

    /**
     * 添加收获地址
     * @param addressDTO
     * @return
     */
    public ResponseDTO addAddress(final AddressDTO addressDTO ) {
        Address address = new Address();
        try {
            BeanUtils.copyAttr(addressDTO, address);
            if(1!=userDao.addAddress(address)){
                return ResponseDTO.fail(ErrorCode.USER_ADDRESS_ADD_FAILE.ec());
            }
            return ResponseDTO.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.DB_ERROR.ec());
        }
    }
    /**
     * 根据用户Id获取当前用户的收获地址
     */
    public ResponseDTO getAddressListByUserId(Long userId){
        try {
            List<Address> addressList = userDao.getAddressListByUserId(userId);

            return ResponseDTO.success(addressList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.DB_ERROR.ec());
        }
    }


}
