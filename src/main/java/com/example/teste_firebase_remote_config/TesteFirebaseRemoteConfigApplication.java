package com.example.teste_firebase_remote_config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.remoteconfig.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;

@SpringBootApplication
public class TesteFirebaseRemoteConfigApplication {
    public static void main(String[] args) {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("../api_keys/<SEU-ARQUIVO>.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println(FirebaseApp.initializeApp(options).getName());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        SpringApplication.run(TesteFirebaseRemoteConfigApplication.class, args);
    }
}
