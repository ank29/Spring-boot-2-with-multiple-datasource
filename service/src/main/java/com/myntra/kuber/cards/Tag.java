package com.myntra.kuber.cards;

public class Tag {

    String tagKey;
    String  tagValue;

    public Tag(){

    }

    public Tag(String tagKey, String tagValue) {
        this.tagKey = tagKey;
        this.tagValue = tagValue;
    }

    public String getTagKey() {
        return tagKey;
    }

    public void setTagKey(String tagKey) {
        this.tagKey = tagKey;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }



    @Override
    public String toString() {
        return "Tag{" +
                "tagKey=" + tagKey +
                ", tagValue=" + tagValue +
                '}';
    }

}
