package com.myntra.kuber.controller;

import com.myntra.kuber.dao.impl.VideoRepoImpl;
import com.myntra.kuber.manager.CollectionManager;
import com.myntra.kuber.model.Videos;
import com.myntra.kuber.response.PopularVideosResponse;
import com.myntra.kuber.response.Tag;
import com.myntra.kuber.response.VideoResponse;
import com.myntra.kuber.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@RestController
@RequestMapping(value = "/popularVideos")
public class VideosController {

    @Autowired
    private Utils utils;

    @Autowired
    private VideoRepoImpl videoRepo;

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity popularVideos(){
        PopularVideosResponse popularVideosResponse = new PopularVideosResponse();
        List<VideoResponse> videoResponseList = new ArrayList<>();
        List<Tag> popularTagList = utils.getPopularTags();
        popularVideosResponse.setPopularTags(popularTagList);
        List<Videos> popularVideoList = videoRepo.getTopVideos();
        if(!popularVideoList.isEmpty()){
            popularVideoList.forEach(popularVideos -> {
                VideoResponse videoResponse = new VideoResponse();
                videoResponse.setVideoId(popularVideos.getVideoId());
                videoResponse.setVideoLink(popularVideos.getVideoLink());
                videoResponse.setVideoId(popularVideos.getVideoId());
                List<Tag> videoTags = new ArrayList<>();
                List<String> tagList = Arrays.asList(popularVideos.getVideoTags().split(","));
                tagList.forEach(tags -> {
                        Tag tag = new Tag(tags);
                        videoTags.add(tag);

                });
                videoResponse.setVideoTags(videoTags);
                videoResponseList.add(videoResponse);
            });
        }
        popularVideosResponse.setVideos(videoResponseList);

        return ResponseEntity.ok(popularVideosResponse);
    }

}
