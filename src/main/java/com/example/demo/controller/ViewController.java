package com.example.demo.controller;

import com.example.demo.model.Footballer;
import com.example.demo.repository.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class ViewController {

    private final FootballerRepository footballerRepository;

    @RequestMapping(value = "mainView", method = RequestMethod.GET)
    public String mainView(Model model) {
        List<Footballer> list = footballerRepository.findAll();
        Collections.shuffle(list);
        model.addAttribute("footballers", list.stream().limit(20).collect(Collectors.toList()));
        return "mainView";
    }
}
