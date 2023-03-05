package com.lx.service;

import com.github.pagehelper.PageInfo;
import com.lx.controller.request.BaseRequest;
import com.lx.entity.User;

import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */
public interface IUserService {
    List<User> list();

    PageInfo<User> page(BaseRequest baseRequest);

    void save(User obj);

    User getById(Integer id);

    void update(User obj);

    void deleteById(Integer id);

    void handleAccount(User user);
}
