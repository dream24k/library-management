package com.lx.mapper;

import com.lx.controller.request.BaseRequest;
import com.lx.entity.Book;
import com.lx.entity.Borrow;
import com.lx.entity.ReturnBook;
import com.lx.mapper.po.BorrowReturnCountPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:lixiang
 * @Description: User接口
 */

@Mapper
public interface BorrowMapper {

    List<Borrow> list();

    List<Borrow> listByCondition(BaseRequest baseRequest);

    List<ReturnBook> listReturnByCondition(BaseRequest baseRequest);

    void save(Borrow obj);

    void saveReturn(ReturnBook obj);

    Borrow getById(Integer id);

    void updateById(Borrow obj);

    void deleteById(Integer id);

    void deleteReturnById(Integer id);

    void updateStatus(String status, Integer id);

    List<BorrowReturnCountPO> getCountByTimeRange(@Param("timeRange") String timeRange, @Param("type") int type);
}
