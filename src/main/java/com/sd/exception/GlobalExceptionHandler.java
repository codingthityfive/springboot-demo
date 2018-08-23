package com.sd.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springboot-demo
 * @description: 全局异常处理类 通过使用@ControllerAdvice定义统一的异常处理类，可以不用在每个Controller中逐个定义异常处理方式
 * 用来定义函数针对的异常类型，controller通过抛出的异常类型匹配 最后将Exception对象和请求URL映射到 resource/templates/error.html中
 * @author: zZ
 * @create: 2018-07-05 13:25
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    //默认异常处理页面
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 默认异常处理方法,返回异常请求路径和异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws  Exception{

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);                   //异常信息
        mav.addObject("url", "请求路径：" + request.getRequestURI());   //异常请求路径
        mav.setViewName(DEFAULT_ERROR_VIEW);                          //返回异常处理页面
        return mav;
    }

    /**
     *
     * @ExceptionHandler 匹配抛出的异常类型
     * ErrorInfo<String> 为自定义的一个数据封装类，用于返回的json数据
     * 如果返回的是json格式，需要加上@ResponsBody
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException e) {

        return getStringErrorInfo(request, e.getMessage());
    }

    /**
     * 业务异常处理
     * @ExceptionHandler 匹配抛出的异常类型
     * ErrorInfo<String> 为自定义的一个数据封装类，用于返回的json数据
     * 如果返回的是json格式，需要加上@ResponsBody
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, BusinessException e) {
        return getStringErrorInfo(request, e.getMessage());
    }

    private ErrorInfo<String> getStringErrorInfo(HttpServletRequest request, String message) {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(ErrorEnum.getResponseCode(message));
        errorInfo.setMessage(ErrorEnum.getResponseMsg(ErrorEnum.getResponseCode(message)));
        errorInfo.setUrl(request.getRequestURI());
        errorInfo.setData(null);

        return errorInfo;
    }
}
