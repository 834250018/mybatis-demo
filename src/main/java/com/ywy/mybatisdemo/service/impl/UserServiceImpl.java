package com.ywy.mybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywy.mybatisdemo.entity.User;
import com.ywy.mybatisdemo.mapper.UserMapper;
import com.ywy.mybatisdemo.mapper.UserMapper1;
import com.ywy.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ve
 * @date 2019/7/27 0:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserMapper1 userMapper1;

    @Override
    public User one(String id) {
        return userMapper.one(id);
    }

    @Override
    public List<User> list() {
        PageHelper.startPage(1, 10);
        return userMapper.list();
    }

    @Override
    public void insert(User user) {
        //        userMapper.insert(user);
        userMapper.insert1(user);
        //        userMapper1.insert2(user);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
