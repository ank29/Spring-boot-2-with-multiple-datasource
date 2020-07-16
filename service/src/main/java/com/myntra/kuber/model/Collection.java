package com.myntra.kuber.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="collection")
public class Collection  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="type")
    protected String type;

    @Column(name="name")
    protected String name;

    @Column(name="image_data")
    protected String image_data;

    @Column(name="score")
    protected int score;

    @Column(name="tag")
    protected String tag;

}
