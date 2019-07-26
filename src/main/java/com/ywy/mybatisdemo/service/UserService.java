package com.ywy.mybatisdemo.service;

import com.ywy.mybatisdemo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author ve
 * @date 2019/7/27 0:13
 */
public interface UserService {
    public User getUserById(String id);
}
