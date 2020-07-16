package com.myntra.kuber.controller;

import com.myntra.kuber.dao.impl.CollectionStyleRepoImpl;
import com.myntra.kuber.manager.CollectionManager;
import com.myntra.kuber.manager.StyleManager;
import com.myntra.kuber.manager.VideoManager;
import com.myntra.kuber.model.Collection;
import com.myntra.kuber.model.CollectionStyles;
import com.myntra.kuber.model.Style;
import com.myntra.kuber.model.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by 300068200 on 16/07/20.
 */
@RestController
@RequestMapping(value = "/dbInsert/insert")
public class InsertController {

    @Autowired
    CollectionManager collectionManager;

    @Autowired
    StyleManager styleManager;

    @Autowired
    VideoManager videoManager;

    @Autowired
    private CollectionStyleRepoImpl collectionStyleRepo;

    @PostMapping("/collection")
    @Produces(MediaType.APPLICATION_JSON)
    public Long collectionAdd(@Valid @RequestBody Collection collection) {
        return collectionManager.saveCollection(collection).getId();
    }

    @GetMapping("/Videos")
    @Produces(MediaType.APPLICATION_JSON)
    public Long videosAdd(@Valid @RequestBody Videos videos) {
        Long videoId =  videoManager.save(videos).getVideoId();
        return videoId;
    }

    @GetMapping("/styles/{collectionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void stylesAdd(@Valid @RequestBody  Style style, @PathVariable Long collectionId) {
       Long styleId =  styleManager.saveStyle(style);
       CollectionStyles collectionStyles = new CollectionStyles(collectionId, styleId);
       collectionStyleRepo.save(collectionStyles);
    }
}
