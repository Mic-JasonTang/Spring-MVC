package com.springmvc.handlers;

import com.spring.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Spring-MVC
 * <p> 测试数据输出处理模型
 * 四种：ModelAndView、Map 及 Model 、@SessionAttributes、@ModelAttribute
 * Created by JasonTang on 11/01/2017 20:29.
 */
@SessionAttributes(value = "user", types = String.class)
@Controller
public class SrpingMVC_ModelTest {
    private static final String SUCCESS = "success";

    /**
     * 重定、转发向视图
     */
    @RequestMapping("testRedirect")
    public String testRedirect() {
        System.out.println("SrpingMVC_ModelTest.testRedirect");
//        return "redirect:haha.jsp";
        return "forward:haha.jsp";
    }
    /**
     * 测试自定义视图，Helloworld视图
     */
    @RequestMapping("testView")
    public String testView() {
        System.out.println("SrpingMVC_ModelTest.testView");
        return "helloView";
    }
    /**
     * 1. 有@ModelAttribute 标记的方法，会在每个方法被执行之前被SpringMVC 调用
     * 2. @ModelAttribute 注解也可以来修饰目标方法POJO 类型的入参，其Value 属性值有如下的作用：
     *  2.1: SpringMVC 会使用value 属性值在implicitModel 中查找对应的对象，若存在则会直接传入到目标方法的入参中。
     *  2.2: SpringMVC 会以value 为key， POJO 类型的对象为value ，存入到request中。
     */
    @ModelAttribute
    public void getUsers(@RequestParam(value="username",required=false) String username,
                         Map<String, Object> map) {
        System.out.println("SrpingMVC_ModelTest.getUsers");
       if(username != null) {
           User user = new User("Tom", "TomLike",13);
           System.out.println("模拟从数据库中获取一个对象：" + user);
           //这里的key需要和下面testModelAttribute 的入参 user相同，不能修改为别的名字,否则不会起作用
           map.put("user2",user);
       }
    }
    /**
     * 使用上面的@ModelAttribute标记的方法
     * 运行流程如下：
     * 1. 执行@ModelAttribute 注解装饰的方法，从数据库中取出对象，把对象放入到了Map中，键为：user
     * 2. SpringMVC 从Map中取出User对象，并把表单的请求参数映射给User对象的对应属性
     * 3.SpringMVC 把上述对象传入目标方法的参数
     *
     * 注意：在@ModelAttribute 修饰的方法中，放入到Map时 的键需要和目标方法入参类型的第一个小写字母小写的字符串一致
     *
     * SpringMVC 确定目标方法POJO 类型入参的过程
     * 1. 确定一个key：
     *  1.1: 若目标方法的POJO 类型的参数没有使用@ModelAtribute 作为修饰，则key 为POJO 类名第一个字母的小写
     *  1.2: 若使用了@ModelAttribute 来修饰，则key 为@ModleAttribute 注解的value 属性值
     * 2. 在implicitModel 中查找key 对应的对象，若存在，则作为参数传入
     *  2.1: 若在@ModelAttribute 标记的方法中在Map 中保存过，且key 和 1 确定的key 一致，则会获取到。
     * 3. 在implicitModel中不存在 key 对应的对象，则检查当前的Hander 是否使用@SessionAttribute 注解来修饰，
     *    若使用了该注解，且@SessionAttribute 注解的value值中包含了该key ，则会从HttpSession 中来获取 key 所对应的value 值，
     *    若存在则直接传入到目标方法的入参中，若不存在则将抛出异常。
     * 4. 若Hander 没有标识@SessionAttribute 注解或 @SessionAttribute 注解的值中不包含key，则会通过反射来创建POJO类型的参数，
     *    传入目标方法的参数
     * 5. SpringMVC 会把Key 和 POJO 类型的对象保存到implicitModel 中，进而会保存到request中。
     *
     * 源码分析流程：
     * 1. 调用@ModelAttribute 注解修饰的方法，实际把@ModelAttribute 方法中的Map 中的数据放在了implicitModel 中.
     * 2. 解析请求处理器的目标参数，实际上该项目参数来自于 WebDataBinder 对象的target属性
     *  2.1: 创建 WebDataBinder对象：
     *     ①、确定objectName 属性：若传入的attributeName属性值为 "",则objectName 为类名第一个字母小写.
     *    *注意： attrName. 若目标方法的POJO 属性使用了@ModelAttribute 来修饰，则 attrName 值即为@ModelAttribute 的value属性值
     *
     *     ②、确定target属性：
     *      > 在implicitModel 中查找attrName 对应的属性值，若存在，OK
     *      >* 若不存在：则验证当前hander 是否使用了@SessionAttribute 进行修饰，若使用了，则尝试Session 中获取AttrName 所对应的属性值。
     *         若Session中没有对应的属性值，则抛出异常 HTTP Status 500 - Session attribute 'user' required - not found in session

     *  2.2: SpringMVC 把表单的请求参数赋给了WebDataBinder 的target 对应的属性。
     *  2.3*: SpringMVC 会把WebDataBinder 的attrName 和 target 给到implicitModel ，进而传到request 域对象中。
     *  2.4: 把WebDataBinder 的target 作为参数传递给目标方法的入参.
     */
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("SrpingMVC_ModelTest.testModelAttribute ，修改 : " + user);
        return SUCCESS;
    }

    /**
     * 使用@SeesionAttribute 除了可以通过属性名指定需要会话中的属性外（实际上使用的value的属性值）
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（实际上使用的types属性值）
     *
     * 注意：该注解只能放在类的上面，而不能修饰方法
     */
    @RequestMapping("testSessionAttributes")
    public String  testSessionAttributes(Map<String, Object> map) {
        User user = new User("Tom", "TomLike", 18);
        map.put("tom", user);
        map.put("hello", "world");
        return SUCCESS;
    }
    /**
     *目标方法可以添加map 类型的（实际也可以是model 或者ModelMap类型的）参数
     * @param map
     * @return
     */
    @RequestMapping("testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("users", Arrays.asList(new String[]{"Tom", "Jason", "Jack"}));
        return SUCCESS;
    }

    /**
     * 目标方法的返回值是ModelAndView 类型
     * 其中可以包括视图和模型信息
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView () {
        ModelAndView modelAndView = new ModelAndView(SUCCESS);

        //添加模型数据到ModelAndView中
        modelAndView.addObject("time", new Date());

        return modelAndView;
    }

}
