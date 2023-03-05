package com.lx.controller.request;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class AdminPageRequest extends BaseRequest{
    private String username;
    private String password;
    private String email;
    private String phone;
}
