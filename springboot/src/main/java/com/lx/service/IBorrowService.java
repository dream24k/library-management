package com.lx.service;

import com.github.pagehelper.PageInfo;
import com.lx.controller.request.BaseRequest;
import com.lx.entity.Borrow;
import com.lx.entity.ReturnBook;

import java.util.List;
import java.util.Map;

/**
 * @Author:lixiang
 * @Description:
 */
public interface IBorrowService {
    List<Borrow> list();

    PageInfo<Borrow> page(BaseRequest baseRequest);

    void save(Borrow obj);

    PageInfo<ReturnBook> pageReturn(BaseRequest baseRequest);

    void saveReturn(ReturnBook obj);

    Borrow getById(Integer id);

    void update(Borrow obj);

    void deleteById(Integer id);

    void deleteReturnById(Integer id);

    Map<String, Object> getCountByTimeRange(String timeRange);
}
