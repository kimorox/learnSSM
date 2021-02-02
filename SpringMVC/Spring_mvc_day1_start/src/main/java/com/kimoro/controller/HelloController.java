package com.kimoro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/28 11:09
 * 控制器类
 **/
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    /**
     * 入门案例
     *
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     *
     * @return
     */
    @RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
