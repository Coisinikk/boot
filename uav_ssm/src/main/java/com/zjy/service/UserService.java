package com.zjy.service;

import com.zjy.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //登录验证
    int login(@Param("userName") String userName, @Param("password") String password);

    //添加用户
    int userAdd(User user);

    //查询所有用户信息
    List userFindAll();

    //按照id查询用户信息
    User userFindById(Integer userId);

    //根据用户编号，删除用户信息
    int userDelete(Integer userId);

    /*//更新用户信息
    int userUpdate(User user);*/
}
