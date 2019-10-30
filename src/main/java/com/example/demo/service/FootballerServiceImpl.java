package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.model.Footballer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl implements FootballerService {

    private final FootballerRepository footballerRepository;
    private final AnswerRepository answerRepository;

    @Override
    public List<Footballer> findAll() {
        return footballerRepository.findAll();
    }
    @Override
    public Footballer save(Footballer footballer) {
        return footballerRepository.save(footballer);
    }

    @Override
    public Optional<Footballer> findById(Long id) {
        return footballerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        footballerRepository.deleteById(id);
    }

    @Override
    public Footballer findByName(String name) {
       return footballerRepository.findByName(name);
    }

}
