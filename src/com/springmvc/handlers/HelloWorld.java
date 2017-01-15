package com.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 11/01/2017 10:44.
 */
@Controller
public class HelloWorld {


    /**
     * 1、使用@requestMapping 注解来映射请求的URL
     * 2、返回值会通过视图解析器，解析为实际的物理视图，对于InternalResourceViewResolver 视图解析器，会做如下的解析：
     * 通过prefix + reutrn Value + 后缀，这样的方法得到实际的物理视图，然后做转发操作
     *
     * /WEB-INF/views/ + success + .jsp
     * @return 返回的页面的值
     */
    @RequestMapping("helloworld")
    public String hello() {
        System.out.println("helloworld");
        return "success";
    }
}
