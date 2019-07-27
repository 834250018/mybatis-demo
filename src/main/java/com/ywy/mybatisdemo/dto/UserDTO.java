package com.ywy.mybatisdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author ve
 * @date 2019/7/27 14:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO implements Serializable {
    private String id;
    private String username;
    private String password;
    private String realname;

}
