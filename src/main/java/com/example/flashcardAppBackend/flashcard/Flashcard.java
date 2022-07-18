package com.example.flashcardAppBackend.flashcard;

import com.example.flashcardAppBackend.topic.Topic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    Long id;
    String term;
    String answer;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "topic_id")
    @Nullable
    Topic topic;

    public Flashcard() {
    }

    public Flashcard(Long id, String term, String answer, Topic topic) {
        this.id = id;
        this.term = term;
        this.answer = answer;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", answer='" + answer + '\'' +
                ", topic=" + topic +
                '}';
    }
}
