package com.myntra.kuber.dao;

import com.myntra.kuber.model.CollectionStyles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Repository
public interface CollectionStyleRepository  extends JpaRepository<CollectionStyles, Long> {

    List<CollectionStyles> findByCollectionId(long collectionId);

    List<CollectionStyles> findByStyleId(long styleId);

    List<CollectionStyles> findDistinctByCollectionIdIn(List<Long> collectionIdList);
}
