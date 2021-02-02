package com.kimoro.controller;

import com.kimoro.domain.Account;
import com.kimoro.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName ParamController
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/28 14:48
 * 请求参数绑定
 **/
@Controller
@RequestMapping(path = "/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username) {
        System.out.println("执行了...");
        System.out.println("用户名：" + username);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     *
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("执行了saveAccount");
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println(user);
        return "success";
    }
@RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }
}
