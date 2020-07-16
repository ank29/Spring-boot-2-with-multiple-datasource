package com.myntra.kuber.controller;

import lombok.Data;

import java.util.List;

/**
 * Created by 300068200 on 16/07/20.
 */
@Data
public class TagListRequest {
    List<String> tagList;
}
