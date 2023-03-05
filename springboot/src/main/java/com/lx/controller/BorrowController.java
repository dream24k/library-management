package com.lx.controller;

import com.lx.common.Result;
import com.lx.controller.request.BookPageRequest;
import com.lx.controller.request.BorrowPageRequest;
import com.lx.entity.Borrow;
import com.lx.entity.ReturnBook;
import com.lx.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:lixiang
 * @Description:
 */

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    IBorrowService borrowService;

    @PostMapping("/save")
    public Result save(@RequestBody Borrow obj){
        borrowService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Borrow obj){
        borrowService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        borrowService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Borrow borrow = borrowService.getById(id);
        return Result.success(borrow);
    }

    @GetMapping("/list")
    public Result list(){
        List<Borrow> borrows = borrowService.list();
        return Result.success(borrows);
    }

    @GetMapping("/page")
    public Result page(BorrowPageRequest borrowPageRequest){
        return Result.success(borrowService.page(borrowPageRequest));
    }

    @GetMapping("/pageReturn")
    public Result pageReturn(BorrowPageRequest borrowPageRequest){
        return Result.success(borrowService.pageReturn(borrowPageRequest));
    }

    @PostMapping("/saveReturn")
    public Result saveReturn(@RequestBody ReturnBook obj){
        borrowService.saveReturn(obj);
        return Result.success();
    }

    @DeleteMapping("/deleteReturn/{id}")
    public Result deleteReturn(@PathVariable Integer id){
        borrowService.deleteReturnById(id);
        return Result.success();
    }

    @GetMapping("/lineCharts/{timeRange}")
    public Result lineCharts(@PathVariable String timeRange){
        return Result.success(borrowService.getCountByTimeRange(timeRange));
    }
}
