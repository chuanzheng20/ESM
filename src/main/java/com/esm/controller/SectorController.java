package com.esm.controller;


import com.esm.domain.Org;
import com.esm.domain.Sector;
import com.esm.service.OrgService;
import com.esm.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @PostMapping
    public Result save(@RequestBody Sector sector){

        boolean flag = sectorService.save(sector);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "" : "添加部门信息错误，请重试！";
        return new Result(code,null,msg);

    }

    @DeleteMapping("/{sectorId}")
    public Result delete(@PathVariable Integer sectorId){

        boolean flag = sectorService.delete(sectorId);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = flag ? "" : "删除部门信息错误，请重试！";
        return new Result(code,null,msg);
    }

    @PutMapping
    public Result update(@RequestBody Sector sector){

        boolean flag = sectorService.update(sector);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "" : "更新部门信息错误，请重试！";
        return new Result(code,null,msg);
    }

    @GetMapping("/{sectorId}")
    public Result getById(@PathVariable Integer sectorId){

        Sector data = sectorService.getById(sectorId);
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询部门信息错误，请重试！";

        return new Result(code,data,msg);

    }

    @GetMapping
    public Result getAll(){

        List<Sector> data = sectorService.getAll();
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询部门信息错误，请重试！";
        return new Result(code,data,msg);
    }

}
