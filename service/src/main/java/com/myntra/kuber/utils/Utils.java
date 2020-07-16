package com.myntra.kuber.utils;

import com.myntra.kuber.manager.CollectionManager;
import com.myntra.kuber.response.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 300068200 on 16/07/20.
 */
@Service
public class Utils {

    @Autowired
    private CollectionManager collectionManager;

    public List<Tag> getPopularTags() {
        List<Tag> responseTagList = new ArrayList<>();
        List<String> popularTags = collectionManager.getPopularTags();
        popularTags.forEach(popularTag -> {
            Tag tag = new Tag(popularTag);
            responseTagList.add(tag);
        });
        return responseTagList;
    }
}
