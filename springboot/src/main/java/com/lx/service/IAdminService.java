package com.lx.service;

import com.github.pagehelper.PageInfo;
import com.lx.controller.dto.LoginDTO;
import com.lx.controller.request.BaseRequest;
import com.lx.controller.request.LoginRequest;
import com.lx.controller.request.PasswordRequest;
import com.lx.entity.Admin;

import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */
public interface IAdminService {
    List<Admin> list();

    PageInfo<Admin> page(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(Integer id);

    void update(Admin obj);

    void deleteById(Integer id);

    LoginDTO login(LoginRequest request);

    void changePassword(PasswordRequest request);
}
