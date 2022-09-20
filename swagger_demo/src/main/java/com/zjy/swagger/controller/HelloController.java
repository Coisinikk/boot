package com.zjy.swagger.controller;

import com.zjy.swagger.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @PostMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
    //只要我们的接口中，返回值中存在实体类，就会被扫描到Swagger
    @GetMapping(value = "/user")
    public User user(){
        return new User();
    }
    @ApiOperation(value = "Hello控制类")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello2"+username;
    }

    @ApiOperation(value = "Post测试类")
    @PostMapping(value = "/post")
    public User post(@ApiParam("用户") User user){
        int i = 5/0;
        return user;
    }

}
