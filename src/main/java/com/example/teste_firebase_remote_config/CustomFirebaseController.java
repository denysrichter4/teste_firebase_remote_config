package com.example.teste_firebase_remote_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class CustomFirebaseController {
    @Autowired
    CustomFirebaseService service;
    @GetMapping("/")
    public ResponseEntity getCRUD(){
        service.init();
        return ResponseEntity.ok().body("OK");
    }
}
