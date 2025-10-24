package com.heshiyang;

import com.heshiyang.dto.Video;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Files 包含都是跟文件操作相关的方法（读取文件内容、拷贝文件、删除文件...）
 */

public class TestFile {

    static void main() throws IOException {

        String first = "data";
        String filename = "p.csv";

//        Path 代表文件的存储路径    readAllLines是读取文件的每一行
        List<String> data = Files.readAllLines(Path.of(first, filename));

        for (String s : data) {
//            System.out.println(s);

            String[] ss = s.split(",");//  split(",")   通过,分割数据
            String[] tags = ss[5].split("_");//  分割标签
            System.out.println(ss[0] + " " + tags[0] + " " + tags[1]);

//            Arrays.asList(tags)是将数组变成list集合
            new Video(ss[0],ss[1], LocalDateTime.parse(ss[4]),ss[2],ss[3], Arrays.asList(tags),List.of(),ss[6],ss[7]);
        }
    }
}
