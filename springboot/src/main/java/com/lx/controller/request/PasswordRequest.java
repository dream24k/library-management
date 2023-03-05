package com.lx.controller.request;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class PasswordRequest {
    private String username;
    private String password;
    private String newPassword;
}
