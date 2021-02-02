package com.kimoro.controller;

import com.kimoro.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @ClassName AnnoController
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/29 16:40
 **/
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})// 把msg=哈哈存入session域中
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     *
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     *
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头信息
     *
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Accept") String header) {
        System.out.println(header);
        return "success";
    }

    /**
     * 获取cookie的值
     *
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(name = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注释
     *
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser() {
        System.out.println("showUser执行了");
    }

    /**
     * SessionAttributes的注解
     *
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行了");
        //底层会存储到request域对象中
        model.addAttribute("msg", "哈哈");
        return "success";
    }

    /**
     * 获取session值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes执行了");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("delSessionAttributes执行了");
        status.setComplete();
        return "success";
    }

}
