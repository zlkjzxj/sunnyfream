package com.sunny.sunnyfream.exception;

import com.sunny.sunnyfream.result.CodeMsg;
import com.sunny.sunnyfream.result.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
//        e.printStackTrace();
//        if (e instanceof BindException) {
//            BindException bindException = (BindException) e;
//            String message = bindException.getMessage();
//            return Result.error(CodeMsg.BIND_ERROR.fillArgs(message));
//        } else
        GlobalException exception = (GlobalException) e;
        if (e instanceof NoHandlerFoundException) {
            return Result.error(exception.getCodeMsg());
        }
        if (e instanceof GlobalException) {
            return Result.error(exception.getCodeMsg());
        }
        if (e instanceof UnknownAccountException) {
            return Result.error(exception.getCodeMsg());
        }
        if (e instanceof DisabledAccountException) {
            return Result.error(exception.getCodeMsg());
        }
        if (e instanceof AuthenticationException) {
            return Result.error(exception.getCodeMsg());
        }
//        if (e instanceof Exception) {
//            return Result.error(exception.getCodeMsg());
//        }
        return Result.error(CodeMsg.VISIT_MANAGER_ERR);
    }
}
