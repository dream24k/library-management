package com.lx.entity;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description: User类
 */

@Data
public class Admin extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String phone;
    private boolean status;
}
