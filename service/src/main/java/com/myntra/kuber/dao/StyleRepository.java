package com.myntra.kuber.dao;

import com.myntra.kuber.model.Style;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 300068200 on 15/07/20.
 */
@Repository
public interface StyleRepository extends CrudRepository<Style, Long> {

    List<Style> getAllByIdIn(List<Long> id);

    List<Style> getAllByVideoId(Long videoId);
}
