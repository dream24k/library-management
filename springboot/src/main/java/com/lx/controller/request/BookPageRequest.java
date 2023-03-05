package com.lx.controller.request;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class BookPageRequest extends BaseRequest{
    private String name;
    private String bookNo;
}
