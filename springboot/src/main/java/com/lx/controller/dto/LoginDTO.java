package com.lx.controller.dto;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class LoginDTO {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private String token;
}
