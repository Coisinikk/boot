package com.zjy.controller;

import com.zjy.entity.User;
import com.zjy.mapper.UserMapper;
import com.zjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userService.selectUsers();
        for(User user:userList){
            System.out.println(user);
        }
        return userList;
    }
    @GetMapping("/queryUserById/{id}")
    public User queryUserById(@PathVariable("id") Integer id){
        User user = userService.selectUser(id);
        System.out.println(user);
        return user;
    }
    @GetMapping("/addUser")
    public int addUser(){
        int num = userService.increaseUser(new User(4,"local","990307"));
        return num;
    }
    @GetMapping("/updateUser")
    public int updateUser(){
        int num = userService.refreshUser(new User(4,"host","000000"));
        return num;
    }
    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id") Integer id){
        int num = userService.removeUser(id);
        return num;
    }

}
