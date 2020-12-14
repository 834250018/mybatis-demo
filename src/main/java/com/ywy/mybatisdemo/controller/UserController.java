package com.ywy.mybatisdemo.controller;

import com.ywy.mybatisdemo.dto.UserDTO;
import com.ywy.mybatisdemo.entity.User;
import com.ywy.mybatisdemo.service.UserService;
import com.ywy.mybatisdemo.pojo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    @ApiOperation(value = "用户-one")
    @GetMapping("/one")
    public UserVO one(@NotBlank @RequestParam("id") String id) {
        User user = userService.one(id);
        UserVO userVO = new UserVO();
        if (user == null) {
            return null;
        }
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @ApiOperation(value = "用户-list")
    @GetMapping("/list")
    public List<UserVO> list(@RequestParam(value = "ids", required = false) Set<String> ids) {
        List<User> users = userService.list();
        List<UserVO> userVOS = new LinkedList<>();
        users.forEach(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            userVOS.add(userVO);
        });
        return userVOS;
    }

    @ApiOperation(value = "创建用户")
    @PostMapping("/create")
    public void create(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.insert(user);
    }

    @ApiOperation(value = "创建用户1,声明式事务")
    @PostMapping("/create1")
    public void create1(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.insert1(user);
    }

    @ApiOperation(value = "创建用户2,程序化事务")
    @PostMapping("/create2")
    public void create2(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.insert2(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/remove")
    public void getUserById(UserDTO userDTO) {
        userService.delete(userDTO.getId());
    }

    @ApiOperation(value = "修改用户")
    @PutMapping("/update")
    public void update(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.update(user);
    }
}
