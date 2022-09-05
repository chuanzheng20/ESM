package com.esm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.esm.domain.Five;
import com.esm.domain.Tax;
import com.esm.domain.YM;
import com.esm.domain.query.*;
import com.esm.service.FiveService;

import com.esm.service.OtherDetailsService;
import com.esm.service.TaxService;
import com.esm.service.YMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/2 9:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/wages")
public class WagesController {
    @Autowired
    private FiveService fiveService;
    @Autowired
    private OtherDetailsService otherDetailsServices;
    @Autowired
    private TaxService taxService;
    @Autowired
    private YMService ymService;

    @GetMapping("/selectById")
    public Result selectById(@RequestParam String userId, @RequestParam Integer yMId) {
        List<OtherDetailsQuery> otherDetailsQuery = otherDetailsServices.select(userId, yMId);

        Integer code = otherDetailsQuery != null ? Code.GET_OK : Code.GET_ERR;
        String msg = otherDetailsQuery != null ? "" : "用户信息错误，请重试！";

        return new Result(code, otherDetailsQuery, msg);
    }

    @PostMapping("/selectByPageAndCurrentPage")
    public Result getWagesPage(@RequestParam Integer currentPage, @RequestParam Integer pageSize, @RequestParam Boolean isAse, @RequestBody FiveQuery fiveQuery) {
        IPage<FiveQuery> page = new Page<>(currentPage, pageSize);
        String strUserId = String.valueOf(fiveQuery.getUserId()).equals("null") ? null : String.valueOf(fiveQuery.getUserId());
        fiveService.selectByPageAndCurrentPage(page, strUserId, isAse);
        System.out.println(page);
        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getRecords());
        resultPage.setTotalCount((int) page.getTotal());
        Integer code = page.getRecords() != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page.getRecords() != null ? "" : "信息错误，请重试！";
        return new Result(code, resultPage, msg);
    }

    @PutMapping
    public Result selectTrigger(@PathVariable Integer yMId) {
        List<Five> fives = fiveService.selectById(yMId);
        Integer code = fives != null ? Code.GET_OK : Code.GET_ERR;
        String msg = fives != null ? "" : "用户信息错误，请重试！";
        return new Result(code, fives, msg);
    }

    @GetMapping("/taxRateAll")
    public Result taxRateAll() {
        List<Tax> data = taxService.getAll();
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询信息错误，请重试！";
        return new Result(code, data, msg);
    }

    @GetMapping("/selectFive")
    public Result selectFive(@RequestParam Integer fiveId) {
        List<Five> fives = fiveService.selectByIds(fiveId);
        Integer code = fives != null ? Code.GET_OK : Code.GET_ERR;
        String msg = fives != null ? "" : "用户信息错误，请重试！";
        return new Result(code, fives, msg);
    }
    @GetMapping("/timeToAll")
    public Result  timeTo() {
        List<YM> data =ymService.getAll();
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询信息错误，请重试！";
        return new Result(code, data, msg);
    }
}
