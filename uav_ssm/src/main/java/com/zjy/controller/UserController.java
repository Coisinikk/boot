package com.zjy.controller;

import com.zjy.entity.User;
import com.zjy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;
    @RequestMapping("/addUser.do")
    public ModelAndView addUser(User user){
        ModelAndView modelAndView = new ModelAndView();
        //调用service处理user
        int nums = service.userAdd(user);
        if(nums>0){
            modelAndView.setViewName("register_win.html");
        }else {
            modelAndView.setViewName("register_fall.html");
        }
        return modelAndView;
    }

    @RequestMapping("/loginUser.do")
    public ModelAndView loginUser(User user){
        ModelAndView modelAndView = new ModelAndView();


        return modelAndView;
    }

}
