package com.myntra.kuber.response;

import com.myntra.kuber.model.Style;
import lombok.Data;

import java.util.List;

/**
 * Created by 300068200 on 16/07/20.
 */
@Data
public class ShopListResponse {
    List<Tag> popularTags;
    List<Style> styleList;
}
