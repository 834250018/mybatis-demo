package com.ywy.mybatisdemo.mapper;

import com.ywy.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author ve
 * @date 2019/7/26 23:22
 */
@Repository
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User one(String id);

    @Select("<script>select * from user where id in <foreach collection='ids' item='id' open='(' separator=',' close=')'>#{id}</foreach></script>")
    List<User> list(@Param("ids") Set<String> ids);

    @Insert("insert into user (id, username, password, realname) values (#{id},#{username},#{password},#{realname})")
    void insert(User user);

    @Delete("delete from user where id = #{id}")
    void delete(String id);

    @Update("update user set username = #{username}, password = #{password}, realname = #{realname} where id = #{id}")
    void update(User user);
}
