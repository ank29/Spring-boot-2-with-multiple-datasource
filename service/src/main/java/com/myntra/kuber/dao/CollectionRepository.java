package com.myntra.kuber.dao;

import com.myntra.kuber.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    List<Collection> getByType(String type);

    Collection getByTypeAndName(String type, String name);

    Collection getByTag(String tag);

    List<Collection> findTop5ByTypeOrderByScoreDesc(String type);

    List<Collection> findTop5ByOrderByScoreDesc();

    List<Collection> getByTagIn(List<String> tagList);


}
