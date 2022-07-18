package com.example.flashcardAppBackend.topic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/topic")
@CrossOrigin(origins = "http://localhost:8080")
public class TopicController {

    @Autowired
    TopicRepository repository;

    @GetMapping("/all")
    public List<Topic> findAll(){

        List<Topic> topics = repository.findAll();

        for(Topic topic : topics){
            System.out.println(topic.getId());
        }

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Topic> getOne(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping("/save")
    public Topic createTopic(@RequestBody Topic topic) {
        Topic persistedTopic = repository.save(topic);
        log.info("New Player added to TopicRepository - {}", topic);
        return repository.save(topic);
    }








}
