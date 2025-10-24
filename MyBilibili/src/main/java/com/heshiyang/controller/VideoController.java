package com.heshiyang.controller;

import com.heshiyang.dto.Play;
import com.heshiyang.dto.Video;
import com.heshiyang.service.VideoService1;
import com.heshiyang.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  路径参数
 *  1. @RequestMapping("video/{bv}")
 *  2. @PathVariable String bv，@PathVariable表示该方法参数要从路径中获取
 */

@Controller
public class VideoController {

    @Autowired
    private VideoService1 videoService1;  // Spring的依赖注入
    @Autowired
    private VideoService2 videoService2;

    @RequestMapping("video/{bv}")
    @ResponseBody
    public Video t(@PathVariable String bv) {
//        if(bv.equals("1")){
//            List<Play> plays = List.of(
//                    new Play("P1","哈哈哈", LocalTime.parse("00:05:05"),""),
//                    new Play("P2","哈哈哈", LocalTime.parse("00:05:05"),"")
//            );
//            return new Video("1","哈哈哈",LocalDateTime.now(),
//                    "1.png","哈哈哈",List.of("gg","ff"),
//                    plays,"自制","动画->国漫");
//        }
//        return null;
//    }
        return videoService2.find(bv);  //  这里换成了service2的调用数据库数据的方法
    }
}

