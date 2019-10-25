package com.example.demo.service;
import com.example.demo.model.Footballer;
import java.util.List;
import java.util.Optional;

public interface FootballerService {
     List<Footballer> findall();
     Footballer save(Footballer footballer);
     Optional<Footballer> findById(Long id);
     void deleteById(Long id);
}
