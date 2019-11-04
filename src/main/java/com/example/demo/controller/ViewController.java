package com.example.demo.controller;

import com.example.demo.model.Footballer;
import com.example.demo.service.FootballerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class ViewController {

    private final FootballerService footballerService;

    @RequestMapping(value = "mainView", method = RequestMethod.GET)
    public String mainView(Model model) {
        List<Footballer> list = footballerService.findAll();
        Collections.shuffle(list);
        model.addAttribute("footballers", list.stream().limit(20).collect(Collectors.toList()));
        return "mainView";
    }

       @RequestMapping(value = "/quizPage", method = RequestMethod.GET)
       public String quizPage(Model model){
           List<Footballer> footballers = footballerService.findAll();
           Collections.shuffle(footballers);
           model.addAttribute("footballers", footballers.get(0));
           return "quizPage";
       }
}
