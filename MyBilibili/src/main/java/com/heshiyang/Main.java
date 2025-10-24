package com.heshiyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Main implements WebMvcConfigurer {
    static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

//    重写静态资源映射，重写之前主函数要加上implements WebMvcConfigurer，不然找不到
//    修改addResourceHandlers，能够把 url路径 和 磁盘路径 做一个映射
//    比如之前是http://localhost:8080/play/xxx => static/play，现在指向成D:/aaa目录
//    快捷键 Ctrl + O
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//  addResourceHandler是URL路径       addResourceLocations是磁盘路径
        registry.addResourceHandler("/play/**").addResourceLocations("file:d:\\希尔达第三季\\");
    }
}
