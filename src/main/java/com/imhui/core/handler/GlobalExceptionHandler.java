package com.imhui.core.handler;

import com.imhui.common.base.ResponseResult;
import com.imhui.common.base.ResponseUtil;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseResult parameterMissingExceptionHandler(MissingServletRequestParameterException e){
        return ResponseUtil.success();
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseResult requestBodyMissingExceptionHandler(HttpMessageNotReadableException e){
        return ResponseUtil.success();
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseResult methodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return ResponseUtil.success();
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseResult bindExceptionHandler(BindException e){
        return ResponseUtil.success();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        return ResponseUtil.success();
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseResult constraintViolationExceptionHandler(ConstraintViolationException e){
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        return ResponseUtil.success();
    }

}
