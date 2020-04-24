package com.myntra.kuber;
import com.myntra.kuber.manager.CreditManager;
import com.myntra.kuber.model.CreditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class DemoController {

    @Autowired
    private CreditManager creditManager;

    @GetMapping
    public ResponseEntity demo(){
        List<CreditLog> creditLogList = creditManager.creditLogList("1234");
        if(creditLogList.isEmpty()){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(creditLogList);
    }
}

