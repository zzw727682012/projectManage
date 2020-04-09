package com.project.manager.common.utils;

import com.project.manager.common.IStatusMessage;
import com.project.manager.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handle(HttpServletResponse response, Exception ex){
        ex.printStackTrace();
        logger.info("异常处理...");
        logger.info("异常："  + ex.getMessage());
        Map<String, Object> data = new HashMap<>();

        data.put("code",0);
        data.put("msg","操作异常"+ ex.getMessage());
        return data;
    }

}
