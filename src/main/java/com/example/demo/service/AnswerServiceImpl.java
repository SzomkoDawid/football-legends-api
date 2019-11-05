package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {
    public final AnswerRepository answerRepository;

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        answerRepository.deleteById(id);
    }
}
