package com.heshiyang.mapper;

import com.heshiyang.dto.Play;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//查询某个视频的选集
@Mapper
public interface PlayMapper {

    @Select("""
        SELECT id,title,duration,url FROM play WHERE bv=#{bv}
        """)
    List<Play> findPlayBv(String bv);  // 返回多个一系列的值
}
