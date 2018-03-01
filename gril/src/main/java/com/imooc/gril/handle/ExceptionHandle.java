package com.imooc.gril.handle;

import com.imooc.gril.domain.Result;
import com.imooc.gril.exception.GirlException;
import com.imooc.gril.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类，需要又ControllerAdvice注解
 */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    //此注解表示捕获哪个异常，因为需要返回json格式，所以用的responsebody
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException)e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }
        else {
            logger.error("未知异常:{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
