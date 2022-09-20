package com.zjy.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //在特定的时间执行这个方法 Timer
    //cron表达式
    //秒 分 时 日 月 周几~
    //@Scheduled(cron = "0 39 22 * * ?") 每天的22点39分执行
    //@Scheduled(cron = "30 0/5 10,18 * * ?")  每天的10点18点，每隔5分钟执行一次
    //@Scheduled(cron = "0 15 10 ? * 1-6")   每个月的周一到周六 10点15分执行一次
    //@Scheduled(cron = "0 * * * * 0-7")
    @Scheduled(cron = "0/2 * * * * ?")//每隔两秒执行一次
    public void hello(){
        System.out.println("执行hello");
    }
}
