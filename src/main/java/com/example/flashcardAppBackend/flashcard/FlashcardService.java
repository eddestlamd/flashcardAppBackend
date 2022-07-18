package com.example.flashcardAppBackend.flashcard;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class FlashcardService {
/*
    RestTemplate restTemplate =new RestTemplate();

    public ResponseEntity<String> allFlashcards(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameter", headers);
        ResponseEntity<String> response = restTemplate.exchange();
    }*/
}
