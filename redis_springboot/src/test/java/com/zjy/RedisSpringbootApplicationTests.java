package com.zjy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class RedisSpringbootApplicationTests {
    @Autowired
    @Qualifier("redisTemplate1")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //redisTemplate 操作不同的数据类型，api和我们指令一样
        //opsForValue 简单的Key-Value操作
        //opsForList  针对List集合的相关操作。
        //opsForSet   针对Set类型的相关操作。
        //opsForHash   针对Hash类型的相关操作
        //opsForZSet  针对ZSet的相关操作。zSet也是一种集合
        //opsForGeo   在地图中使用
        //opsForHyperLogLog   是用来做基数统计的算法

        //除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的CRUD
        //获取redis的连接对象
        /*RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushAll();
        connection.flushDb();*/
        redisTemplate.opsForValue().set("local","host");
        System.out.println(redisTemplate.opsForValue().get("local"));
    }

    @Test
    public void test() throws JsonProcessingException {
        User user = new User("臧家瑶",24);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }

}
