package com.myntra.kuber.dao.impl;

import com.myntra.kuber.dao.CollectionStyleRepository;
import com.myntra.kuber.model.CollectionStyles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 300068200 on 15/07/20.
 */
@Component
public class CollectionStyleRepoImpl {

    @Autowired
    private CollectionStyleRepository collectionStyleRepository;

    public List<Long> findStyleIdListByCollectionId(long collectionId){
        List<CollectionStyles> collectionStylesList = collectionStyleRepository.findByCollectionId(collectionId);
        return collectionStylesList.stream().map(collectionStyles -> collectionStyles.getStyleId()).collect(Collectors.toList());
    }

    public List<Long> findCollectionIdByStyleId(long styleId){
        List<CollectionStyles> collectionStylesList = collectionStyleRepository.findByStyleId(styleId);
        return collectionStylesList.stream().map(collectionStyles -> collectionStyles.getCollectionId()).collect(Collectors.toList());
    }

    public List<Long> findDistinctStyleIdByCollectionId(List<Long> collectionIdList){
        List<CollectionStyles> collectionStylesList = collectionStyleRepository.findDistinctByCollectionIdIn(collectionIdList);
        return collectionStylesList.stream().map(collectionStyles -> collectionStyles.getStyleId()).collect(Collectors.toList());
    }

    public void save(CollectionStyles collectionStyles){
        collectionStyleRepository.save(collectionStyles);
    }

}
