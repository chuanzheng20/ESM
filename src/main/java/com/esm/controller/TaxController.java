package com.esm.controller;

import com.esm.domain.OtherType;
import com.esm.domain.Tax;
import com.esm.service.OtherTypeService;
import com.esm.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/5 23:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/tax")
public class TaxController {
    @Autowired
    private TaxService taxService;
    @PutMapping
    public Result update(@RequestBody Tax tax){
        boolean flag = taxService.update(tax);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "" : "更新信息错误，请重试！";
        return new Result(code,null,msg);
    }
    @PostMapping
    public Result save(@RequestBody Tax tax){
        boolean flag = taxService.save(tax);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "" : "添加信息错误，请重试！";
        return new Result(code,null,msg);

    }
}
