package com.springmvc.handlers;

import com.spring.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 11/01/2017 14:44.
 */
@RequestMapping("springmvc")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS = "success";

    /**
     * SpringMVC支持原生ServletAPI的使用
     • HttpServletRequest
     • HttpServletResponse
     • HttpSession
     • java.security.Principal
     • Locale
     • InputStream
     • OutputStream
     • Reader
     • Writer
     * @param request
     * @param response
     * @param writer
     * @throws IOException
     */
    @RequestMapping("testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response,
                               Writer writer) throws IOException {
        System.out.println("SpringMVCTest.testServletAPI"+ request + "__" + response);
        writer.write("hello SpringMVC");
//        return  SUCCESS;
    }
    /**
     * 测试一下Pojo
     * @param user
     * @return
     */
    @RequestMapping(value = "testPojo")
    public String testPojo(User user) {
        System.out.println("SpringMVCTest.testPojo : " + user);
        return SUCCESS;
    }
    /**
     * 使用@CookieValue : 获取Cookie的值
     * 用法和RequestParam差不多
     * @param seesionID
     * @return
     */
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String seesionID) {
        System.out.println("SpringMVCTest.testCookieValue sessionID : " + seesionID);
        return SUCCESS;
    }
    /**
     * 使用@RequestHeader
     * 映射请求头信息
     * 用法同RequestParam
     * @param al
     * @return
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String al) {
        System.out.println("SpringMVCTest.testRequestHeader, Accept-Language :" + al);
        return SUCCESS;
    }

    /**
     * 使用@RequestParam 来映射请求参数
     * value 值即为请求的参数名
     * required 该参数表示是否为必须，默认值为true
     * defaultValue 请求参数默认值
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
                                   @RequestParam(value = "age", required = false,
                                           defaultValue = "0") Integer age) {
        System.out.println("SpringMVCTest.testRequestParam" + " username:" + username + ", age:" + age);
        return SUCCESS;
    }

    /**
     * REST风格——PUT
     */
    @RequestMapping(value = "testREST/{id}", method = RequestMethod.PUT)
    public String testRESTPUT(@PathVariable("id") Integer id) {
        System.out.println("SpringMVCTest.testREST PUT : " + id);
        return SUCCESS;
    }
    /**
     * REST风格——DELETE
     */
    @RequestMapping(value = "testREST/{id}", method = RequestMethod.DELETE)
    public String testRESTDELETE(@PathVariable("id") Integer id) {
        System.out.println("SpringMVCTest.testREST DELETE : " + id);
        return SUCCESS;
    }
    /**
     * REST风格——POST
     */
    @RequestMapping(value = "testREST", method = RequestMethod.POST)
    public String testREST() {
        System.out.println("SpringMVCTest.testREST POST");
        return SUCCESS;
    }
    /**
     * REST风格——GET
     */
    @RequestMapping(value = "testREST/{id}", method = RequestMethod.GET)
    public String testREST(@PathVariable("id") Integer id) {
        System.out.println("SpringMVCTest.testREST GET : " + id);
        return SUCCESS;
    }
    /**
     * 测试PathVariable的作用，可以传入id
     * 可以来映射URL中的占位符到目标方法的参数中
     * @param id testPathVariable/12
     */
    @RequestMapping("testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("SpringMVCTest.testPathVariable : " + id);
        return SUCCESS;
    }
    /**
     * 测试ant风格的路径，
     * ?：匹配一个字符
     * *：匹配任意字符
     * ** :匹配多层路径
     */
    @RequestMapping("testAntPath/*/test")
    public String testAntPath() {
        System.out.println("SpringMVCTest.testAntPath");
        return SUCCESS;
    }
    /**
     * 测试 params 和 headers 属性
     */
    @RequestMapping(value = "testParamsAndHeaders", params = {"username", "age!=10"},
            headers = {"Accept-Language:zh-CN,zh;q=0.8"})
    public String testParamsAndHeaders() {
        System.out.println("SpringMVCTest.testParamsAndHeaders");
        return SUCCESS;
    }
    /**
     * 使用method 属性来指定请求方式
     */
    @RequestMapping(value = "testMethod", method = RequestMethod.POST)
    public String  testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }
    /**
     * 1. @RequestMapping 除了修饰方法，还可以来修饰类
     * 2.
     *  1). 类定义处，提供初步的请求映射信息，相当于 WEB应用的根目录
     *  2). 方法处，提供进一步的细分映射信息
     *  相当于类定义处的url，若类定义处未标注@RequestMapping，则方法处标记的URL相对于WEB应用的根应用
     */
    @RequestMapping("testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
