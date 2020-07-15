package com.myntra.kuber.cards;

import java.util.List;

public class VideoListProps {
    private String title;
    private String seaAll;
    private String alignment;
    private List<VideoListArray> videoArray;

    public VideoListProps(String title, String seaAll, String alignment, List<VideoListArray> videoArray) {
        this.title = title;
        this.seaAll = seaAll;
        this.alignment = alignment;
        this.videoArray = videoArray;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeaAll() {
        return seaAll;
    }

    public void setSeaAll(String seaAll) {
        this.seaAll = seaAll;
    }

    public List<VideoListArray> getVideoArray() {
        return videoArray;
    }

    public void setVideoArray(List<VideoListArray> videoArray) {
        this.videoArray = videoArray;
    }


    @Override
    public String toString() {
        return "Tag{" +
                "title=" + title +
                ", seaAll=" + seaAll +
                ", alignment=" + alignment +
                ", videoArray=" + videoArray +
                '}';
    }

}
