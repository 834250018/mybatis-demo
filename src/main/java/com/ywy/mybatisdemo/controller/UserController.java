package com.ywy.mybatisdemo.controller;

import com.ywy.mybatisdemo.entity.User;
import com.ywy.mybatisdemo.service.UserService;
import com.ywy.mybatisdemo.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author ve
 * @date 2019/7/27 0:14
 */
@Api(value = "UserController", tags = "用户")
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @ApiOperation(value = "根据id查询用户")
    @GetMapping("/one")
    public UserVO getUserById(@NotBlank @RequestParam("id") String id) {
        User user = userService.getUserById(id);
        UserVO userVO = new UserVO();
        if(user == null) {
            return null;
        }
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
