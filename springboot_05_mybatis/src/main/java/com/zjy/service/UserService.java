package com.zjy.service;

import com.zjy.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectUsers();
    User selectUser(Integer id);
    int increaseUser(User user);
    int refreshUser(User user);
    int removeUser(Integer id);

}
