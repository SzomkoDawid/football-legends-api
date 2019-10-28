package com.example.demo.repository;

import com.example.demo.model.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Long> {
    Footballer findByName(String name);
}
