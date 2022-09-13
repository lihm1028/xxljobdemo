package com.lihm.xxljobdemo.config;

import com.lihm.xxljobdemo.RestResult;
import com.lihm.xxljobdemo.exception.SharedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Slf4j
@ControllerAdvice
public class ExceptionConfig {


    /**
     * 捕获异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(SharedException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Order(value = 2)
    public RestResult<Object> serviceException(SharedException ex) {
        String message = StringUtils.isEmpty(ex.getMessage()) ? "系统错误" : ex.getMessage();
        RestResult result = RestResult.fail(-1, message);
        log.error("SharedException error", ex);
        return result;
    }


    /**
     * 捕获异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Order(value = 3)
    public RestResult<Object> runtimeException(RuntimeException ex) {
        String message = StringUtils.isEmpty(ex.getMessage()) ? "系统错误" : ex.getMessage();
        RestResult result = RestResult.fail(-2, message);
        log.error("SharedException error", ex);
        return result;
    }


    /**
     * 捕获异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Order(value = 4)
    public RestResult<Object> runtimeException(Exception ex) {
        String message = StringUtils.isEmpty(ex.getMessage()) ? "系统错误" : ex.getMessage();
        RestResult result = RestResult.fail(-3, message);
        log.error("SharedException error", ex);
        return result;
    }

}
