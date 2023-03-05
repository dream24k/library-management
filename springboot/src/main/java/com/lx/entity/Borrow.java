package com.lx.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class Borrow extends BaseEntity{
    private String bookName;
    private String bookNo;
    private String userNo;
    private String userName;
    private String userPhone;
    private Integer score;
    private String status;
    private Integer days;
    private LocalDate returnDate;
    private String note;
}
