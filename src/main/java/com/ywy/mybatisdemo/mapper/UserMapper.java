package com.ywy.mybatisdemo.mapper;

import com.ywy.mybatisdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ve
 * @date 2019/7/26 23:22
 */
@Repository
public interface UserMapper {
    User getById(String id);
}
