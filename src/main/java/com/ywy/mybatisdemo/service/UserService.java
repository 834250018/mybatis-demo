package com.ywy.mybatisdemo.service;

import com.ywy.mybatisdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author ve
 * @date 2019/7/27 0:13
 */
public interface UserService {

    public User one(String id);

    public List<User> list(Set<String> ids);

    public void insert(User user);

    public void delete(String id);

    public void update(User user);
}
