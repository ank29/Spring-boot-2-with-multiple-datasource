package com.myntra.kuber.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 300068200 on 15/07/20.
 */
@Entity
@Data
@Table(name="collection_styles")
public class CollectionStyles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="collectionId")
    protected  long collectionId;

    @Column(name="style_id")
    protected long styleId;

}
