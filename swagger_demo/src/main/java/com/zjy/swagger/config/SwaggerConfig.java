package com.zjy.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置swagger的docket的bean实例
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("springCloud");
    }
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的Swagger的环境
        Profiles profiles = Profiles.of("dev","test");
        //获取项目的环境
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("springBoot_swagger")   //配置API文档的分组
                //enable是否启动Swagger，false不启动
                .enable(flag)
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式  basePackage指定要扫描的包
                //any 扫描全部    none 不扫描  withClassAnnotation 扫描类上的注解  withMethodAnnotation 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.zjy.swagger.controller"))
                //paths 过滤路径
                //.paths(PathSelectors.ant("/zjy/**"))
                .build();
    }
    //配置swagger信息 apiInfo
    private ApiInfo apiInfo(){
        Contact contact = new Contact("臧家瑶","www.yao.com","zjy18830760471@163.com");
        return new ApiInfo("想去S12的臧家瑶", "银鞍照白马，飒沓如流星", "1.0", "www.yao.com", contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
