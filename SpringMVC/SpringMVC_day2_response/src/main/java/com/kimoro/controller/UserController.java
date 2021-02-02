package com.kimoro.controller;

import com.kimoro.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/30 10:31
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回String
     *
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    private String testString(Model model) {
        System.out.println("testString执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("kimoro");
        user.setPassword("root");
        user.setAge(18);

        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回void
     *
     * @return
     */
    @RequestMapping("/testVoid")
    private void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //重定向
//        response.sendRedirect(request.getContextPath() + "index.jsp");
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //直接进行相应
        response.getWriter().print("你好");
        return;
    }

    @RequestMapping("/testModelAndView")
    private ModelAndView testModelAndView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("kimoro");
        user.setPassword("root");
        user.setAge(18);
        //把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user", user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 模拟异步请求相应
     * @param user
     */
    @RequestMapping("/testAjax")
    private @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax执行了");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("小明");
        user.setAge(40);
        // 做响应
        return user;
    }
}
