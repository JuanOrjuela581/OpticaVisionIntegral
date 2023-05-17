package com.usta.opticavisionintegral.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class DemoExceptionHandler {

    @Autowired
    private ErrorAttributes errorAttributes;

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(HttpServletRequest request, WebRequest webRequest, Model model){
        if (is404(request)){
            return "/error/404";
        }

        model.addAllAttributes(buildMapErrors(webRequest));
        return "error";
    }

    private Boolean is404(HttpServletRequest request){
        return HttpStatus.NOT_FOUND.value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    }

    private Map<String, Object> buildMapErrors(WebRequest webRequest){
        ErrorAttributeOptions options = ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE,
                ErrorAttributeOptions.Include.EXCEPTION,
                ErrorAttributeOptions.Include.MESSAGE);

        return errorAttributes.getErrorAttributes(webRequest,options);
    }
}
