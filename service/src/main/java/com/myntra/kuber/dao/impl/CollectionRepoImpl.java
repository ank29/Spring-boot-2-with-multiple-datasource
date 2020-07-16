package com.myntra.kuber.dao.impl;

import com.myntra.kuber.dao.CollectionRepository;
import com.myntra.kuber.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Component
public class CollectionRepoImpl {

    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getCollectionList(String type){
        return collectionRepository.getByType(type);
    }

    public Collection getCollection(String type, String name){
        return collectionRepository.getByTypeAndName(type, name);
    }

    public Collection getCollectionByTag(String tag){
        return collectionRepository.getByTag(tag);
    }

    public List<Collection> getCollectionByTagsIn(List<String> tagList){
        return collectionRepository.getByTagIn(tagList);
    }

    public List<Collection> getPopularTagsByType(String type){
        List<Collection> collectionList = collectionRepository.findTop5ByTypeOrderByScoreDesc(type);
        return collectionList;
    }

    public List<Collection> getPopularTags(){
        List<Collection> collectionList = collectionRepository.findTop5ByOrderByScoreDesc();
        return collectionList;
    }

    public Collection save(Collection collection){
       return collectionRepository.save(collection);
    }
}

