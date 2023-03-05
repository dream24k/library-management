package com.lx.controller.request;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class UserPageRequest extends BaseRequest{
    private String name;
    private String phone;
}
