package com.zjy.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //想拿到provider-server的信息
    @Reference // 引用，Pom坐标，可以定义路径相同的接口名
    TicketService ticketService;
    public void buyTicket() {
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到的==》"+ticket);
    }

}
