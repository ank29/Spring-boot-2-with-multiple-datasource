package com.myntra.kuber.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 300068200 on 15/07/20.
 */
@Entity
@Data
@Table(name="videos")
public class Videos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    @Column(name="score")
    protected int score;

    @Column(name="video_link")
    protected String videoLink;

    @Column(name="video_tags")
    protected String videoTags;
}
