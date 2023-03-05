package com.lx.service;

import com.github.pagehelper.PageInfo;
import com.lx.controller.request.BaseRequest;
import com.lx.entity.Book;

import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */
public interface IBookService {
    List<Book> list();

    PageInfo<Book> page(BaseRequest baseRequest);

    void save(Book obj);

    Book getById(Integer id);

    void update(Book obj);

    void deleteById(Integer id);
}
