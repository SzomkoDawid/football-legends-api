package com.example.demo.service;

import com.example.demo.model.Footballer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl implements FootballerService {

    private final FootballerRepository footballerRepository;
    private final AnswerRepository answerRepository;

    @Override
    public List<Footballer> findall() {
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
}
