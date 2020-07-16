package com.myntra.kuber.response;

import lombok.Data;

/**
 * Created by 300068200 on 15/07/20.
 */
@Data
public class Tag {
    public String tagValue;
    public Tag(String tagValue){
        this.tagValue = tagValue;
    }

}
