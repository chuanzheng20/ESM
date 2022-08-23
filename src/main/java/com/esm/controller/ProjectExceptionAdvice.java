package com.esm.controller;



import com.esm.exception.BusinessException;
import com.esm.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        System.out.println(ex);
        //记录日志

        //发送信息给运维

        //发送邮件给开发人员


        return new Result(ex.getCode(), null, ex.getMessage());
    }


    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        System.out.println(ex);
        return new Result(ex.getCode(), null, ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        System.out.println(ex);

        //记录日志
        //发送信息给运维
        //发送邮件给开发人员

        System.out.println("抓到异常");
        return new Result(Code.SYSTEM_UNKNOW_ERR, null, "系统繁忙，请稍后再试!");
    }
}
