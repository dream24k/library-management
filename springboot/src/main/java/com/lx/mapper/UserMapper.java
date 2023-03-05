package com.lx.mapper;

import com.lx.controller.request.BaseRequest;
import com.lx.controller.request.UserPageRequest;
import com.lx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:lixiang
 * @Description: User接口
 */

@Mapper
public interface UserMapper {

    List<User> list();

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getById(Integer id);

    void updateById(User user);

    void deleteById(Integer id);

    User getByNo(String userNo);

}
