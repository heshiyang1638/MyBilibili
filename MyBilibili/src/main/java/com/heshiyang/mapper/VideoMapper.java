package com.heshiyang.mapper;

import com.heshiyang.dto.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
//  注意这里是interface接口，不是class类，不然findByBv会报错，会让你要加方法体{}
public interface VideoMapper {

//    根据 bv号查询视频
    @Select("""
        SELECT bv,title,cover,introduction,publishTime,tags,type,category FROM video WHERE bv=#{bv}
        """)
    Video findByBv(String bv);

    /*
    数据库习惯 underscore 下划线分割多个单词 如：publish_time
    Java 习惯 驼峰命名法 camel case 如：publishTime

    可以在application.properties文件中添加这句代码
    将数据库习惯的下划线命名法变成驼峰命名法
    mybatis.configuration.map-underscore-to-camel-case=true
     */
}
