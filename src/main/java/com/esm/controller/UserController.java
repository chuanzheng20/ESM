package com.esm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.Level;
import com.esm.domain.User;
import com.esm.domain.query.UserQuery;
import com.esm.domain.query.UserRoleQuery;
import com.esm.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getLevelAll")
    public Result getLevelAll(){

        List<Level> levels = userService.getLevel();

        Integer code = levels != null ? Code.GET_OK : Code.GET_ERR;
        String msg = levels != null ? "" : "级别数据错误，请重试！";

        return new Result(code,levels,msg);
    }

    @PostMapping("/selectByPageAndCurrentPage")
    public Result getUserPage(@RequestParam Integer currentPage, @RequestParam Integer pageSize,@RequestParam Boolean isAse, @RequestBody User user) throws JSONException {
        System.out.println(user);
        IPage<UserQuery> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page(currentPage,pageSize);
        String strUserId = String.valueOf(user.getUserId()).equals("null")? null:String.valueOf(user.getUserId());

        userService.selectByPageAndCurrentPage(page,strUserId,user.getName(),isAse);
        System.out.println(page);
        ResultPage resultPageData = new ResultPage();
        resultPageData.setRows(page.getRecords());
        resultPageData.setTotalCount((int) page.getTotal());

        Integer code = page.getRecords() != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page.getRecords() != null ? "" : "用户信息错误，请重试！";

        return new Result(code, resultPageData,msg);

    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable String id) {
        System.out.println(id);
        UserQuery userQuery = userService.selectById(id);

        Integer code = userQuery != null ? Code.GET_OK : Code.GET_ERR;
        String msg = userQuery != null ? "" : "用户信息错误，请重试！";

        return new Result(code,userQuery,msg);

    }

    @PutMapping
    public Result update(@RequestBody User user) {
        boolean b = userService.update(user);
        Integer code = b  ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = b  ? "" : "用户信息错误，请重试！";
        return new Result(code,null, msg);
    }
    @PostMapping
    public Result save(@RequestBody User user) {
        System.out.println(user);
        System.out.println(user.getGradedId());
        user.setRoleId(3);
        boolean b = userService.save(user);
        Integer code = b  ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = b  ? "" : "用户信息错误，请重试！";
        return new Result(code,null, msg);
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable List<String> ids){
        System.out.println(ids);
        boolean b = userService.delete(ids);
        Integer code = b  ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = b  ? "" : "删除错误！";
        return new Result(code,null, msg);
    }


    @PostMapping("/selectByPageAndCurrentPageRole")
    public Result getUserPageRole(@RequestParam Integer currentPage, @RequestParam Integer pageSize,@RequestParam Boolean isAse, @RequestBody User user) throws JSONException {
        System.out.println(user);
        IPage<UserRoleQuery> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page(currentPage,pageSize);
        String strUserId = String.valueOf(user.getUserId()).equals("null")? null:String.valueOf(user.getUserId());

        userService.selectByPageAndCurrentPageRole(page,strUserId,user.getName(),isAse);
        System.out.println(page);
        ResultPage resultPageData = new ResultPage();
        resultPageData.setRows(page.getRecords());
        resultPageData.setTotalCount((int) page.getTotal());

        Integer code = page.getRecords() != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page.getRecords() != null ? "" : "用户信息错误，请重试！";

        return new Result(code, resultPageData,msg);

    }

    @GetMapping("/selectByIdRole/{id}")
    public Result selectByIdRole(@PathVariable String id) {
        System.out.println(id);
        UserRoleQuery userRoleQuery = userService.selectByIdRole(id);

        Integer code = userRoleQuery != null ? Code.GET_OK : Code.GET_ERR;
        String msg = userRoleQuery != null ? "" : "用户信息错误，请重试！";

        return new Result(code,userRoleQuery,msg);

    }





}
