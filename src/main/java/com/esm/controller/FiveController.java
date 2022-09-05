package com.esm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.esm.domain.Five;
import com.esm.domain.Sector;
import com.esm.domain.Tax;
import com.esm.domain.query.FiveQuery;
import com.esm.service.FiveService;
import com.esm.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/5 3:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/five")
public class FiveController {
    @Autowired
    private FiveService fiveService;
    @Autowired
    private TaxService taxService;
    @PostMapping("/selectByPageAndCurrentPage")
    public Result getFivePage(@RequestParam Integer currentPage, @RequestParam Integer pageSize, @RequestParam Boolean isAse, @RequestBody FiveQuery fiveQuery){
        IPage<Five> page=new Page<>(currentPage,pageSize);
        fiveService.selectByPageAndCurrentPages(page,isAse);
        System.out.println(page);
        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getRecords());
        resultPage.setTotalCount((int) page.getTotal());
        Integer code = page.getRecords() != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page.getRecords() != null ? "" : "信息错误，请重试！";
        return new Result(code,resultPage,msg);
    }
    @DeleteMapping("/{fiveId}")
    public Result deleteById(@PathVariable Integer fiveId){
        System.out.println(fiveId);
        boolean b = fiveService.delete(fiveId);
        Integer code = b  ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = b  ? "" : "删除错误！";
        return new Result(code,null, msg);
    }
    @PostMapping
    public Result save(@RequestBody Five five){
        boolean flag = fiveService.save(five);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "" : "添加五险一金信息错误，请重试！";
        return new Result(code,null,msg);

    }

}
