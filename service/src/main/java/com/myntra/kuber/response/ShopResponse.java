package com.myntra.kuber.response;

import lombok.Data;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Data
public class ShopResponse {
    public List<Tag> popularTags;
    public List<Type> shopList;
}
