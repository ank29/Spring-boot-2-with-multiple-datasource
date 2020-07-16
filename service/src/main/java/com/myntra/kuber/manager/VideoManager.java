package com.myntra.kuber.manager;

import com.myntra.kuber.dao.impl.VideoRepoImpl;
import com.myntra.kuber.model.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Component
public class VideoManager {

    @Autowired
    private VideoRepoImpl videoRepo;

    public Videos getVideosById(long id){
        Videos videos = videoRepo.findById(id);
        return videos;
    }

    public List<Videos> getList(){
        List<Videos> videosList = videoRepo.findAll();
        return videosList;
    }

    public Videos save(Videos videos){
        Videos savedVideos = videoRepo.save(videos);
        return savedVideos;
    }
}
