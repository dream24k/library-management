package com.lx.entity;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description: User类
 */

@Data
public class User extends BaseEntity{
    private String name;
    private String username;
    private String sex;
    private Integer age;
    private String address;
    private String phone;
    private Integer account;
    private Integer score;
    private boolean status;
}
