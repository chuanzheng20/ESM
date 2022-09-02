package com.esm.controller;

import com.esm.domain.Root;
import com.esm.domain.query.RootQuery;
import com.esm.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/roots")
public class RootController {

    @Autowired
    private RootService rootService;

    // @PostMapping
    // public Result save(Root root){
    //
    //
    //     return null;
    // }
    // @DeleteMapping
    // public Result delete(Integer rootId) {
    //
    //     return null;
    //
    // }
    //
    // @PutMapping
    // public Result update(Root root) {
    //     return null;
    //
    // }
    //
    // @GetMapping("/{rootId}")
    // public Result getById(@PathVariable Integer rootId) {
    //
    //     return null;
    // }

    @GetMapping
    public Result getAll() {

        List<Root> rootList = rootService.getAll();
        Integer code = rootList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = rootList != null ? "" : "用户信息错误，请重试！";
        return new Result(code,rootList,msg);
    }

    @GetMapping("/getToLevelAll")
    public Result getToLevelAll(){
        List<RootQuery> rootList = rootService.getToLevelAll();
        Integer code = rootList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = rootList != null ? "" : "用户信息错误，请重试！";
        return new Result(code,rootList,msg);
    }

}
