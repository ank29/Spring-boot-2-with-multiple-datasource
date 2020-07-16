package com.myntra.kuber.manager;

import com.myntra.kuber.dao.impl.CollectionRepoImpl;
import com.myntra.kuber.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 300068200 on 15/07/20.
 */

@Component
public class CollectionManager {

    @Autowired
    private CollectionRepoImpl collectionRepo;

    public List<Collection> getCollectionList(String type){
        return collectionRepo.getCollectionList(type);
    }

    public Collection getCollection(String type, String name){
        return collectionRepo.getCollection(type, name);
    }

    public Collection getCollectionByTag(String tag){
        return collectionRepo.getCollectionByTag(tag);
    }

    public List<String> getPopularTagsByType(String type){
        List<Collection> collectionList = collectionRepo.getPopularTagsByType(type);
        return collectionList.stream().map(collection-> collection.getTag()).collect(Collectors.toList());
    }

    public List<String> getPopularTags(){
        List<Collection> collectionList = collectionRepo.getPopularTags();
        return collectionList.stream().map(collection-> collection.getTag()).collect(Collectors.toList());
    }

    public List<Long> getCollectionIdListWhereTagsIn(List<String> tagList){
        List<Collection> collectionList = collectionRepo.getCollectionByTagsIn(tagList);
        return collectionList.stream().map(collection-> collection.getId()).collect(Collectors.toList());
    }
}
