package com.esm.controller;

import com.esm.domain.OtherType;
import com.esm.domain.Sector;
import com.esm.service.OtherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/5 22:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/othertype")
public class OtherTypeController {
    @Autowired
    private OtherTypeService otherTypeService;
    @PutMapping
    public Result update(@RequestBody OtherType otherType){
        boolean flag = otherTypeService.update(otherType);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "" : "更新信息错误，请重试！";
        return new Result(code,null,msg);
    }
    @GetMapping
    public Result getAll(){
        List<OtherType> data = otherTypeService.getAll();
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询信息错误，请重试！";
        return new Result(code,data,msg);
    }
    @PostMapping
    public Result save(@RequestBody OtherType otherType){
        boolean flag = otherTypeService.save(otherType);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "" : "添加信息错误，请重试！";
        return new Result(code,null,msg);

    }

}
