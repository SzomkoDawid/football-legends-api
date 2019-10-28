package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Footballer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.FootballerRepository;
import com.example.demo.service.AnswerService;
import com.example.demo.service.FootballerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class ViewController {

    private final FootballerService footballerService;
    private final AnswerService answerService;

    @RequestMapping(value = "mainView", method = RequestMethod.GET)
    public String mainView(Model model) {
        List<Footballer> list = footballerService.findAll();
        Collections.shuffle(list);
        model.addAttribute("footballers", list.stream().limit(20).collect(Collectors.toList()));
        return "mainView";
    }
    @RequestMapping(value = "/quizPage", method = RequestMethod.GET)
    public String quizPage(Model model){
        model.addAttribute("footballers", footballerService.findAll().get(0));
        return "quizPage";
    }
}
