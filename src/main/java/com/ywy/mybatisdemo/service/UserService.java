package com.ywy.mybatisdemo.service;

import com.ywy.mybatisdemo.entity.User;

import java.util.List;

/**
 * @author ve
 * @date 2019/7/27 0:13
 */
public interface UserService {

    User one(String id);

    List<User> list();

    void insert(User user);
    void insert1(User user);
    void insert2(User user);

    void delete(String id);

    void update(User user);
}
