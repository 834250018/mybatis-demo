package com.ywy.mybatisdemo.mapper;

import com.ywy.mybatisdemo.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author 83425
 * @date 2020/11/24
 */
@Repository
public class UserMapper1Impl extends SqlSessionDaoSupport implements UserMapper1 {

    @Autowired(required = false)
    @Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void insert2(User user) {
        this.getSqlSession().insert("com.ywy.mybatisdemo.mapper.UserMapper.insert2", user);
    }
}
