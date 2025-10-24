package com.heshiyang.service;

import com.heshiyang.dto.Play;
import com.heshiyang.dto.Video;
import com.heshiyang.mapper.PlayMapper;
import com.heshiyang.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService2 {
    
    @Autowired
    private VideoMapper videoMapper;
    
    @Autowired
    private PlayMapper playMapper;
    
    public Video find(String bv){
        Video video = videoMapper.findByBv(bv);
//        如果没有查询到对应的视频，则返回空
        if (video == null){
            return null;
        }
        List<Play> playList = playMapper.findPlayBv(bv);
        video.setPlayList(playList);
        return video;
    }
}
