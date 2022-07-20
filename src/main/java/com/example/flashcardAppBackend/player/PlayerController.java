package com.example.flashcardAppBackend.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/player")
@CrossOrigin(origins = "http://localhost:8080")
public class PlayerController {

    @Autowired
    PlayerRepository repository;

    @GetMapping("/all")
    public List<Player> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Player> getOne(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping("/save")
    public Player createPlayer(@RequestBody Player player) {

        log.info("New Player added to PlayerRepository - {}", player);
        return repository.save(player);
    }

}
