package com.springmvc.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 1/15/2017 10:51 PM.
 */
@ControllerAdvice
public class ExceptionHandlerTest {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception ex) {
        System.out.println("嘿嘿----》出异常了: " + ex);
        //参数就是视图名称
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex.toString());
        return mv;
    }
}
