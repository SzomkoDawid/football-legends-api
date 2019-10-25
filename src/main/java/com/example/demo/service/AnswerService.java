package com.example.demo.service;

import com.example.demo.model.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    Optional<Answer> findById(Long id);
    Answer save(Answer answer);
    List<Answer> findAll();
    void delete(Long id);
}
