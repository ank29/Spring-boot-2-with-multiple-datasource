package com.myntra.kuber.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 300068200 on 15/07/20.
 */
@Entity
@Data
@Table(name="style")
public class Style implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="style_image")
    protected String styleImage;

    @Column(name="celeb_image")
    protected String celebImage;

    @Column(name="article_type")
    protected String articleType;

    @Column(name="score")
    protected int score;

    @Column(name="video_id")
    protected long videoId;

    @Column(name="price")
    protected double price;

    @Column(name="discounted_price")
    protected double discountPrice;

}
