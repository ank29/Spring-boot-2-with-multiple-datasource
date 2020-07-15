package com.myntra.kuber;

import com.myntra.kuber.model.CreditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class DemoController {



    @GetMapping
    public String demo(){

     return "123";
    }
}

