package com.lx.mapper;

import com.lx.controller.request.BaseRequest;
import com.lx.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author:lixiang
 * @Description: User接口
 */

@Mapper
public interface BookMapper {

    List<Book> list();

    List<Book> listByCondition(BaseRequest baseRequest);

    void save(Book obj);

    Book getById(Integer id);

    void updateById(Book obj);

    void deleteById(Integer id);

    Book getByNo(String bookNo);

    void updateNumByNo(String bookNo);

}
