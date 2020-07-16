package com.myntra.kuber.controller;

import com.myntra.kuber.dao.impl.VideoRepoImpl;
import com.myntra.kuber.manager.CollectionManager;
import com.myntra.kuber.model.Collection;
import com.myntra.kuber.model.Style;
import com.myntra.kuber.model.Videos;
import com.myntra.kuber.response.PopularVideosResponse;
import com.myntra.kuber.response.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private CollectionManager collectionManager;

    @Autowired
    private VideoRepoImpl videoRepo;

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity popularVideos(){
        PopularVideosResponse popularVideosResponse = new PopularVideosResponse();
        List<Videos> popularVideoList = videoRepo.getTopVideos();
        if(!popularVideoList.isEmpty()){
            popularVideosResponse.setVideos(popularVideoList);
            popularVideoList.forEach(popularVideos -> {

                List<Tag> popularVideosTags = new ArrayList<>();
                List<String> tagList = Arrays.asList(popularVideos.getVideoTags().split(","));
                tagList.forEach(tags -> {
                    Collection collection = collectionManager.getCollectionByTag(tags);
                    if(collection != null) {
                        Tag tag = new Tag(collection.getTag());
                        popularVideosTags.add(tag);
                    }
                });
                popularVideosResponse.setPopularTags(popularVideosTags);
            });

        }

        return ResponseEntity.ok(popularVideosResponse);
    }

}
