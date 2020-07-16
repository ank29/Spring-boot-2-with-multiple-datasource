package com.myntra.kuber.manager;
import com.myntra.kuber.dao.impl.CollectionStyleRepoImpl;
import com.myntra.kuber.dao.impl.StyleRepoImpl;
import com.myntra.kuber.model.Collection;
import com.myntra.kuber.model.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Component
public class StyleManager {

    @Autowired
    private StyleRepoImpl styleRepo;

    @Autowired
    private CollectionStyleRepoImpl collectionStyleRepo;

    public List<Style> getstyleList(List<Long> styleIdList){
        return styleRepo.styleList(styleIdList);
    }

    public List<Style> styleListByCollectionId(long collectionId){
        List<Long> styleIdList = collectionStyleRepo.findStyleIdListByCollectionId(collectionId);
        return getstyleList(styleIdList);
    }

    public List<Style> styleListByVideoId(long videoId){
        List<Style> styleList = styleRepo.styleListByVideoId(videoId);
        return styleList;
    }

    public List<Style> getStyleListByCollectionIdList(List<Long> collectionIdList){
        List<Long> styleIdList = collectionStyleRepo.findDistinctStyleIdByCollectionId(collectionIdList);
        return getstyleList(styleIdList);
    }

    public Long saveStyle(Style  style){
       return styleRepo.saveStyle(style).getId();
    }
}

