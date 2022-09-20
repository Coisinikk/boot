package com.zjy.mapper;

import com.zjy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示一个mybatis的mapper类  dao类
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);    
}
