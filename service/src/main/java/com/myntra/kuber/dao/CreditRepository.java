package com.myntra.kuber.dao;

import com.myntra.kuber.model.CreditLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends CrudRepository<CreditLog, Long> {

    List<CreditLog> findByPpsId(String ppsId);

    CreditLog findByPpsTransactionId(String ppsTransactionId);
}
