package com.ywy.mybatisdemo.service.impl;

import com.ywy.mybatisdemo.entity.User;
import com.ywy.mybatisdemo.mapper.UserMapper;
import com.ywy.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author ve
 * @date 2019/7/27 0:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User one(String id) {
        return userMapper.one(id);
    }

    @Override
    public List<User> list(Set<String> ids) {
        return userMapper.list(ids);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
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
