package com.lx.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.controller.request.BaseRequest;
import com.lx.entity.Book;
import com.lx.exception.ServiceException;
import com.lx.mapper.BookMapper;
import com.lx.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */

@Slf4j
@Service
public class BookService implements IBookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public PageInfo<Book> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        return new PageInfo<>(bookMapper.listByCondition(baseRequest));
    }

    @Override
    public void save(Book obj) {
        try {
            obj.setCategory(category(obj.getCategories()));
            bookMapper.save(obj);
        }catch (Exception e){
            throw new ServiceException("数据插入错误", e);
        }
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }

    @Override
    public void update(Book obj) {
        try {
            obj.setCategory(category(obj.getCategories()));
            obj.setUpdatetime(LocalDate.now());
            bookMapper.updateById(obj);
        }catch (Exception e){
            throw new ServiceException("数据更新错误", e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        bookMapper.deleteById(id);
    }

    private String category(List<String> categories){
        StringBuilder stringBuilder = new StringBuilder();
        if (CollUtil.isNotEmpty(categories)){
            categories.forEach(v -> stringBuilder.append(v).append(" > "));
            return stringBuilder.substring(0, stringBuilder.lastIndexOf(" > "));
        }
        return stringBuilder.toString();
    }
}
