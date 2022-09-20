package com.zjy;

import com.zjy.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServerApplicationTests {
    @Autowired
    UserService service;

    @Test
    void contextLoads() {
        service.buyTicket();
    }

}
