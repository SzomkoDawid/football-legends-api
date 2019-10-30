package com.example.demo.service;
import com.example.demo.model.Answer;
import com.example.demo.model.Footballer;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FootballerService {
     List<Footballer> findAll();
     Footballer save(Footballer footballer);
     Optional<Footballer> findById(Long id);
     void deleteById(Long id);
     Footballer findByName(String name);
}
