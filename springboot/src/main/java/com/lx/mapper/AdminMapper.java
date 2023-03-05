package com.lx.mapper;

import com.lx.controller.request.BaseRequest;
import com.lx.controller.request.LoginRequest;
import com.lx.controller.request.PasswordRequest;
import com.lx.controller.request.UserPageRequest;
import com.lx.entity.Admin;
import com.lx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:lixiang
 * @Description: User接口
 */

@Mapper
public interface AdminMapper {

    List<Admin> list();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(Integer id);

    void updateById(Admin obj);

    void deleteById(Integer id);

    Admin getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int updatePassword(PasswordRequest request);

    Admin getByUsername(String username);
}
