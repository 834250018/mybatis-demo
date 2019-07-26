package com.ywy.mybatisdemo.service.impl;

import com.ywy.mybatisdemo.entity.User;
import com.ywy.mybatisdemo.mapper.UserMapper;
import com.ywy.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ve
 * @date 2019/7/27 0:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.getById(id);
    }
}
