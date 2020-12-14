package com.ywy.mybatisdemo.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ve
 * @date 2019/7/27 0:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("用户名")
    private String username;
}
