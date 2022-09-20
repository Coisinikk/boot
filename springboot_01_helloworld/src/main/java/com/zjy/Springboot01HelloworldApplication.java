package com.zjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication ：标注这个类是一个springboot的应用
@SpringBootApplication
public class  Springboot01HelloworldApplication {

    public static void main(String[] args) {
        //将springboot应用启动
        //SpringApplication类
        //run方法
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }
    /*
    * SpringApplication 主要做的四件事情：
    *       1、推断应用的类型是普通的项目还是Web项目
    *       2、查找并加载所有可用初始化器，设置initializers属性中
    *       3、找出所有的应用程序监听器，设置到listeners属性中
    *       4、推断并设置main方法的定义类，找到运行的主类
    * */
}
