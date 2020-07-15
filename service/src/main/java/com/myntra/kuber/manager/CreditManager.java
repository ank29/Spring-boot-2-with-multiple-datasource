//package com.myntra.kuber.manager;
//
//
//import com.myntra.kuber.dao.CreditRepository;
//import com.myntra.kuber.model.CreditLog;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class CreditManager {
//
//    @Autowired
//    private CreditRepository creditRepository;
//
//    public List<CreditLog> creditLogList(String ppsId){
//
//        List<CreditLog> creditLogList = creditRepository.findByPpsId(ppsId);
//        return creditLogList;
//    }
//}
