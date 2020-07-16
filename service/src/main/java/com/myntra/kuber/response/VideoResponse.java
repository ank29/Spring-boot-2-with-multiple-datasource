package com.myntra.kuber.response;

import lombok.Data;

import java.util.List;

/**
 * Created by 300068200 on 16/07/20.
 */
@Data
public class VideoResponse {
    public Long videoId;
    public String videoLink;
    public List<Tag> videoTags;
}
