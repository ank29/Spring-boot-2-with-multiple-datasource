package com.myntra.kuber.dao;

import com.myntra.kuber.model.Videos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Repository
public interface VideoRepository extends CrudRepository<Videos, Long> {

    Videos findById(long id);

    List<Videos> findAll();

    List<Videos> findTop5ByOrderByScoreDesc();

}
