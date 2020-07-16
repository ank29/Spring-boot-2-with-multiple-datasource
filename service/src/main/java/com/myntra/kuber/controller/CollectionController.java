package com.myntra.kuber.controller;

import com.myntra.kuber.manager.CollectionManager;
import com.myntra.kuber.manager.StyleManager;
import com.myntra.kuber.model.Collection;
import com.myntra.kuber.model.Style;
import com.myntra.kuber.response.ShopResponse;
import com.myntra.kuber.response.Tag;
import com.myntra.kuber.response.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@RestController
@RequestMapping(value = "/shop")
public class CollectionController {

    @Autowired
    private CollectionManager collectionManager;

    @Autowired
    private StyleManager styleManager;

    @GetMapping("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity shopList(@PathVariable("type") String type){
        System.out.println(type);
        ShopResponse shopListResponse = new ShopResponse();
        List<Collection> collectionList = collectionManager.getCollectionList(type);
        List<Type> typeList = new ArrayList<>();
        List<Tag> popularTags = new ArrayList<>();
        if(!collectionList.isEmpty()){
            collectionList.forEach(collection -> {
                List<Style> styleList = styleManager.styleListByCollectionId(collection.getId());
                Type type1 = new Type();
                type1.setName(collection.getName());
                type1.setStyleCount(styleList.size());
                type1.setImage(collection.getImage_data());
                typeList.add(type1);
            });
        }
        List<String> popularTagsByType = collectionManager.getPopularTagsByType(type);
        popularTagsByType.forEach(popularTag -> {
            Tag tag = new Tag(popularTag);
            popularTags.add(tag);
        });
        shopListResponse.setShopList(typeList);
        shopListResponse.setPopularTags(popularTags);
        return ResponseEntity.ok(shopListResponse);
    }

    @GetMapping("/styles/{tags}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getStyles(@PathVariable("tags") String tags){
        List<Style> styleList = new ArrayList<>();
        Collection collection = collectionManager.getCollectionByTag(tags);
        if(collection != null){
            styleList = styleManager.styleListByCollectionId(collection.getId());
        }
        return ResponseEntity.ok(styleList);
    }

}
