package com.heshiyang.service;

import com.heshiyang.dto.Play;
import com.heshiyang.dto.Video;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 从文件中获取视频数据
 */

@Service
public class VideoService1 {

    Map<String,Video> map=new HashMap<>();

//    @PostConstruct   // 这是一个初始化方法，在对象创建之后，只会被调用一次
    public void init(){
        //        快捷键  ctrl+Alt+T  快速生成try-catch
        try {
            String first = "data";
            String filename = "p.csv";
            //        Path 代表文件的存储路径    readAllLines是读取文件的每一行
            List<String> data = Files.readAllLines(Path.of(first, filename));
            for (String s : data) {
                String[] ss = s.split(",");//  split(",")   通过,分割数据
                String[] tags = ss[5].split("_");//  分割标签
                //   读取视频选集的文件 v_1.csv
                    ArrayList<Play> list = getPlayList(ss[0], first);

                //  Arrays.asList(tags)是将数组变成list集合;
                Video video = new Video(ss[0], ss[1], LocalDateTime.parse(ss[4]), ss[2], ss[3], Arrays.asList(tags), list, ss[6], ss[7]);

                map.put(ss[0],video);
            }
        } catch (IOException e) {
            //          RuntimeException 运行时异常， 把编译时异常转换为运行时异常
            throw new RuntimeException(e);
        }
    }

//    查询方法，根据视频编号，查询Video对象。这种方法势必会被调用多次
    public Video find(String id) {
        return map.get(id);
    }

    //   读取视频选集的文件
    private static ArrayList<Play> getPlayList(String id, String first){
        try {
            List<String> vdata = Files.readAllLines(Path.of(first, "v_" + id + ".csv"));
            ArrayList<Play> list = new ArrayList<>();  // 创建一个play集合
            for (String vline : vdata) {
                String[] vs = vline.split(",");
                list.add(new Play(vs[0],vs[1], LocalTime.parse(vs[2]),vs[3]));  // play集合里面装play对象
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
