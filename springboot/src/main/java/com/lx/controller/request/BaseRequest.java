package com.lx.controller.request;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class BaseRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
