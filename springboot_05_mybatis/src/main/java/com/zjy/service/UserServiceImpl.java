package com.zjy.service;

import com.zjy.entity.User;
import com.zjy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectUsers() {
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @Override
    public User selectUser(Integer id) {
        User user = userMapper.queryUserById(id);
        return user;
    }

    @Override
    public int increaseUser(User user) {
        int num = userMapper.addUser(user);
        return num;
    }

    @Override
    public int refreshUser(User user) {
        int num = userMapper.updateUser(user);
        return num;
    }

    @Override
    public int removeUser(Integer id) {
        int num = userMapper.deleteUser(id);
        return num;
    }
}
