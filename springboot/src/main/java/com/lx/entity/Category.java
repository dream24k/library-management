package com.lx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */

@Data
public class Category extends BaseEntity{
    private String name;
    private String remark;
    private Integer pid;

    private List<Category> children;
}
