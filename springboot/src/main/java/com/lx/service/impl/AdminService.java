package com.lx.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.controller.dto.LoginDTO;
import com.lx.controller.request.BaseRequest;
import com.lx.controller.request.LoginRequest;
import com.lx.controller.request.PasswordRequest;
import com.lx.entity.Admin;
import com.lx.entity.User;
import com.lx.exception.ServiceException;
import com.lx.mapper.AdminMapper;
import com.lx.mapper.UserMapper;
import com.lx.service.IAdminService;
import com.lx.service.IUserService;
import com.lx.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */

@Slf4j
@Service
public class AdminService implements IAdminService {

    @Resource
    AdminMapper adminMapper;

    private static final String DEFAULT_PASSWORD = "123456";
    private static final String PASSWORD_SALT = "YINNONG";

    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public void save(Admin obj) {
        // 设置默认密码 ：123456
        if (StrUtil.isBlank(obj.getPassword())){
            obj.setPassword(DEFAULT_PASSWORD);
        }
        obj.setPassword(securePassword(obj.getPassword()));
        try{
            adminMapper.save(obj);
        }catch (DuplicateKeyException e){
            log.error("数据插入失败，username: {}", obj.getUsername(), e);
            throw new ServiceException("用户名重复");
        }
    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }

    @Override
    public void update(Admin obj) {
        obj.setUpdatetime(LocalDate.now());
        adminMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
        Admin admin = null;
        try{
            admin = adminMapper.getByUsername(request.getUsername());
        }catch (Exception e){
            log.error("根据用户名{} 查询出错", request.getUsername());
            throw new ServiceException("用户名错误");
        }
        if (admin == null){
            throw new ServiceException("用户名或密码错误！");
        }
        // 判断密码是否合法
        String securePassword = securePassword(request.getPassword());
        if (!securePassword.equals(admin.getPassword())){
            throw new ServiceException("用户名或密码错误");
        }
        if (!admin.isStatus()){
            throw new ServiceException("当前用户处于禁用状态，请联系系统管理员");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin, loginDTO);

        // 生成token
        String token = TokenUtils.getToken(String.valueOf(admin.getId()), admin.getPassword());
        loginDTO.setToken(token);
        return loginDTO;
    }

    @Override
    public void changePassword(PasswordRequest request) {
        request.setNewPassword(securePassword(request.getNewPassword()));
        int count = adminMapper.updatePassword(request);
        if (count <= 0){
            throw new ServiceException("修改密码失败");
        }
    }

    private String securePassword(String password){
        return SecureUtil.md5(password + PASSWORD_SALT);
    }
}
