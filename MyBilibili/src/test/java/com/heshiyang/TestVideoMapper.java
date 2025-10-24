package com.heshiyang;  // 和main文件夹一样，test文件夹也要加上软件包名，不然用不了@Autowired，找不到对应文件

import com.heshiyang.dto.Video;
import com.heshiyang.mapper.VideoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestVideoMapper {

    @Autowired
    private VideoMapper videoMapper;

    @Test
    public void test(){
        Video v = videoMapper.findByBv("1");
        System.out.println(v.getBv());
        System.out.println(v.getTitle());
        System.out.println(v.getCover());
        System.out.println(v.getIntroduction());
        System.out.println(v.getPublishTime());
        System.out.println(v.getTagList());
        System.out.println(v.getType());
        System.out.println(v.getCategory());
    }
//    代码运行出错原因：application.properties文件放错位置了，应该放在src/main/resources/目录下
}
