package com.esm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.esm.domain.GradedWages;

import com.esm.domain.query.GradedWagesQuery;
import com.esm.service.GradedWagesService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradedWages")
public class GradedWagesController {

    @Autowired
    private GradedWagesService gradedWagesService;

    @PostMapping
    public Result save(@RequestBody GradedWages gradedWages){
        boolean flag = gradedWagesService.save(gradedWages);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "" : "添加岗位信息错误，请重试！";
        return new Result(code,null,msg);
    }


    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<String> ids){

        boolean flag = gradedWagesService.delete(ids);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = flag ? "" : "删除岗位信息错误，请重试！";
        return new Result(code,null,msg);
    }

    @PutMapping
    public Result update(@RequestBody GradedWages gradedWages){

        boolean flag = gradedWagesService.update(gradedWages);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "" : "更新岗位信息错误，请重试！";
        return new Result(code,null,msg);
    }

    @GetMapping("/{gradedId}")
    public Result getById(@PathVariable Integer gradedId){

        GradedWages data= gradedWagesService.getById(gradedId);
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询岗位信息错误，请重试！";

        return new Result(code,data,msg);

    }

    @GetMapping
    public Result getAll(){

        List<GradedWages> data = gradedWagesService.getAll();
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询部门信息错误，请重试！";
        return new Result(code,data,msg);
    }

    @PostMapping("/selectByPageAndCurrentPage")
    public Result getUserPageRole(@RequestParam Integer currentPage, @RequestParam Integer pageSize,@RequestParam Boolean isAse,@RequestParam List<String> sectorIds, @RequestBody GradedWages gradedWages) throws JSONException {
        System.out.println(gradedWages);
        IPage<GradedWagesQuery> page = new Page<>(currentPage,pageSize);
        gradedWagesService.selectByPageAndCurrentPage(page,gradedWages.getGradedName(),sectorIds,isAse);
        System.out.println(page);
        ResultPage resultPageData = new ResultPage();
        resultPageData.setRows(page.getRecords());
        resultPageData.setTotalCount((int) page.getTotal());

        Integer code = page.getRecords() != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page.getRecords() != null ? "" : "岗位信息错误，请重试！";

        return new Result(code, resultPageData,msg);

    }

}
