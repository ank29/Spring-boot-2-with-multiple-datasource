package com.myntra.kuber.cards;

import java.util.List;

public class VideoListArray {


    private String videoLink;
    private String shopLooks;
    private List<Tag> tags;

    public  VideoListArray(){

    }

    public VideoListArray(String videoLink, String shopLooks, List<Tag> tags) {
        this.videoLink = videoLink;
        this.shopLooks = shopLooks;
        this.tags = tags;
    }



    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getShopLooks() {
        return shopLooks;
    }

    public void setShopLooks(String shopLooks) {
        this.shopLooks = shopLooks;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    @Override
    public String toString() {
        return "Tag{" +
                "videoLink=" + videoLink +
                ", shopLooks=" + shopLooks +
                ", tags=" + tags +
                '}';
    }


}
