package com.lx.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class Book extends BaseEntity{
    private String name;
    private String description;
    private String author;
    private String category;
    private String publisher;
    private String publishDate;
    private String bookNo;
    private String cover;
    private Integer score;
    private Integer nums;

    private List<String> categories;
}
