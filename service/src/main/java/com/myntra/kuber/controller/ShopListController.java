package com.myntra.kuber.controller;

import com.myntra.kuber.manager.CollectionManager;
import com.myntra.kuber.manager.StyleManager;
import com.myntra.kuber.model.Collection;
import com.myntra.kuber.model.Style;
import com.myntra.kuber.response.ShopListResponse;
import com.myntra.kuber.response.ShopResponse;
import com.myntra.kuber.response.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@RestController
@RequestMapping(value = "/shopList")
public class ShopListController {

    @Autowired
    private CollectionManager collectionManager;

    @Autowired
    private StyleManager styleManager;

    @GetMapping("/{type}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity demo(@PathVariable("type") String type,
                               @PathVariable("name") String name) {
        ShopListResponse shopListResponse = new ShopListResponse();
        List<Tag> tagList = new ArrayList<>();
        List<String> popularTags = collectionManager.getPopularTags();
        popularTags.forEach(popularTag -> {
            Tag tag = new Tag(popularTag);
            tagList.add(tag);
        });
        shopListResponse.setPopularTags(tagList);
        List<Style> styleList = new ArrayList<>();
        Collection collection = collectionManager.getCollection(type, name);
        if (collection != null) {
            styleList = styleManager.styleListByCollectionId(collection.getId());
        }
        shopListResponse.setStyleList(styleList);
        return ResponseEntity.ok(shopListResponse);
    }


    @GetMapping("/videos/{videoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity shopList(@PathVariable("videoId") Long videoId) {
        ShopListResponse shopListResponse = new ShopListResponse();
        List<Tag> tagList = new ArrayList<>();
        List<String> popularTags = collectionManager.getPopularTags();
        popularTags.forEach(popularTag -> {
            Tag tag = new Tag(popularTag);
            tagList.add(tag);
        });
        shopListResponse.setPopularTags(tagList);
        List<Style> styleList =  styleManager.styleListByVideoId(videoId);
        shopListResponse.setStyleList(styleList);
        return ResponseEntity.ok(shopListResponse);
    }

    @GetMapping("/tags")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity shopListTags(@Valid @RequestBody  TagListRequest tagListRequest) {
        ShopListResponse shopListResponse = new ShopListResponse();
        List<Tag> responseTagList = new ArrayList<>();
        List<Style> styleList = new ArrayList<>();
        List<String> popularTags = collectionManager.getPopularTags();
        popularTags.forEach(popularTag -> {
            Tag tag = new Tag(popularTag);
            responseTagList.add(tag);
        });
        shopListResponse.setPopularTags(responseTagList);
        if(tagListRequest != null) {
            List<String> tagList = tagListRequest.getTagList();
            System.out.println(tagList);
            List<Long> collectionIdList = collectionManager.getCollectionIdListWhereTagsIn(tagList);
            styleList = styleManager.getStyleListByCollectionIdList(collectionIdList);
        }
        shopListResponse.setStyleList(styleList);
        return ResponseEntity.ok(shopListResponse);
    }
}