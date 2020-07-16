package com.myntra.kuber.dao.impl;

import com.myntra.kuber.dao.StyleRepository;
import com.myntra.kuber.model.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Component
public class StyleRepoImpl {

    @Autowired
    private StyleRepository styleRepository;

    public List<Style> styleList(List<Long> idList){
        return styleRepository.getAllByIdIn(idList);
    }

    public List<Style> styleListByVideoId(long videoId){
        return styleRepository.getAllByVideoId(videoId);
    }

    public Style saveStyle(Style style){
        return styleRepository.save(style);
    }
}
