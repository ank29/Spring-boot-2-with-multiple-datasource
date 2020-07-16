package com.myntra.kuber;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {


    @GetMapping
    public ResponseEntity demo(){
        return ResponseEntity.ok("123");
    }
}

