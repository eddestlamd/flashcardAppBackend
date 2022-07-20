package com.example.flashcardAppBackend.flashcard;

import com.example.flashcardAppBackend.topic.Topic;
import com.example.flashcardAppBackend.topic.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/card")
@CrossOrigin(origins = "http://localhost:8080")
public class FlashcardController {

    @Autowired
    FlashcardRepository repository;
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    FlashcardService service;

    @GetMapping("/all")
    public List<Flashcard> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Flashcard> getOne(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping("/save")
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard) {
        Flashcard persistedFlashcard = repository.save(flashcard);
        log.info("New Card added to FlashcardRepository - {}", flashcard);
        return repository.save(persistedFlashcard);
    }

    @PutMapping("/edit/{id}")
    public Flashcard updateFlashcard(@PathVariable Long id, @RequestBody Flashcard flashcard) {

        return service.updateFlashcard(id, flashcard);
    }

}
