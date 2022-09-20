package com.zjy.service;

import com.zjy.dao.UserDao;
import com.zjy.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    //引用类型的自动注入 @Autowired @Resource
    @Resource
    private UserDao userDao;
    @Override
    public int login(String userName, String password) {
        int num = userDao.login(userName,password);
        return num;
    }

    @Override
    public int userAdd(User user) {
        int num = userDao.userAdd(user);
        return num;
    }

    @Override
    public List userFindAll() {
        List<User> users = userDao.userFindAll();
        return users;
    }

    @Override
    public User userFindById(Integer userId) {
        User user = userDao.userFindById(userId);
        return user;
    }

    @Override
    public int userDelete(Integer userId) {
        int num = userDao.userDelete(userId);
        return num;
    }

    /*@Override
    public int userUpdate(User user) {
        int num = userDao.userUpdate(user);
        return num;
    }*/
}
