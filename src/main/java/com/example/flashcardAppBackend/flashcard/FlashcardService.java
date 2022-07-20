package com.example.flashcardAppBackend.flashcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

    private final FlashcardRepository repository;


    @Autowired
    public FlashcardService(FlashcardRepository repository) {
        this.repository = repository;
    }


    public Flashcard updateFlashcard(Long id, Flashcard flashcard){
        List<Flashcard> flashcards = repository.findAll();
        for(int i = 0; i < flashcards.size(); i++){
            Flashcard b = flashcards.get(i);
            if(b.getId().equals(id)){
                flashcards.set(i, flashcard);
                return b;
            }
        }
        return flashcard;
    }
}
