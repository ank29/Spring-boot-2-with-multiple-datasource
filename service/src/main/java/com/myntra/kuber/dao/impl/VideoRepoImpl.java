package com.myntra.kuber.dao.impl;

import com.myntra.kuber.dao.VideoRepository;
import com.myntra.kuber.model.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Service
public class VideoRepoImpl {


    @Autowired
    private VideoRepository videoRepository;


    public Videos findById(long id) {
       return videoRepository.findById(id);
    }

    public List<Videos> findAll() {
        return videoRepository.findAll();
    }

    public Videos save(Videos videos) {
        return videoRepository.save(videos);
    }

    public List<Videos> getTopVideos() {
        return videoRepository.findTop5ByOrderByScoreDesc();
    }
}
