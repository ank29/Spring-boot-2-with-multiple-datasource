package com.myntra.kuber.response;

import com.myntra.kuber.model.Videos;
import lombok.Data;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Data
public class PopularVideosResponse {
    public List<Tag> popularTags;
    public List<Videos> videos;
}
