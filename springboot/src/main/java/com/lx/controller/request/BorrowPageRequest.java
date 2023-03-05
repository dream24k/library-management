package com.lx.controller.request;

import lombok.Data;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class BorrowPageRequest extends BaseRequest{
    private String bookName;
    private String bookNo;
    private String userName;
}
