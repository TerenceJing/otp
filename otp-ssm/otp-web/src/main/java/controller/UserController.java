package controller;

import controller.dto.base.ResponseDTO;
import controller.dto.user.AddressDTO;
import controller.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.user.UserService;

/**
 * @desc: 消费用户业务控制类
 */
@Controller
@RequestMapping(ApiPathDef.USER)
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 检查用户是否重复
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO checkNameRepetitive(@PathVariable("name") String name) {

        return userService.checkUserNameRepetitive(name);
    }

    /**
     * 添加、修改会员
     */
    @RequestMapping(value = "/addOrUpdateUser", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO addOrUpdateUser(@RequestBody UserDTO user) {
        return userService.addUser(user);
    }

    /**
     * 根据会员id查询会员详情
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO getUserDetailByName(@PathVariable("name") String name) {
        return userService.queryUserDetailByName(name);
    }


    /**
     * 查询会员列表
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getUserList() {
        System.out.println("ddddddddddddddddddddddddd");
    }

    /**
     * 增加收获地址
     * @param addressDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseDTO addUserAddress(@RequestBody AddressDTO addressDTO) {
        return userService.addAddress(addressDTO);
    }

    /**
     * 查询收获地址列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/address/{userId}", method = RequestMethod.GET)
    public @ResponseBody ResponseDTO getUserAddressList(@PathVariable("userId")Long userId) {
        return userService.getAddressListByUserId(userId);
    }

}
