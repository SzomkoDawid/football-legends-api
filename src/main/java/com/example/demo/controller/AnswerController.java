package com.example.demo.controller;
import com.example.demo.model.Answer;
import com.example.demo.service.AnswerService;
import com.example.demo.service.FootballerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/answers")
public class AnswerController {

    public final AnswerService answerService;
    public final FootballerService footballerService;

    @GetMapping
    public ResponseEntity<List<Answer>> findAll() {
        return ResponseEntity.ok(answerService.findAll());
    }
    @PostMapping
    public ResponseEntity createAnswer(@RequestBody Answer answer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(answerService.save(answer));
    }
    @PatchMapping("/{answerId}")
    public ResponseEntity<Answer> update(@PathVariable Long answerId,
                                             @RequestBody Answer updatingAnswer) {

        Optional<Answer> answerOptional = answerService.findById(answerId);
        if (!answerOptional.isPresent()) {
            log.error("Footballer id " + answerId + "   not exist");
            ResponseEntity.badRequest().build();
        }

        Answer answer = answerOptional.get();
        if (!StringUtils.isEmpty(updatingAnswer.getFirstAnswer())) answer.setFirstAnswer(updatingAnswer.getFirstAnswer());
        if (!StringUtils.isEmpty(updatingAnswer.getSecondAnswer())) answer.setSecondAnswer(updatingAnswer.getSecondAnswer());

        return ResponseEntity.accepted().body(answerService.save(answer));
    }
    @DeleteMapping("/{answerId}")
    public ResponseEntity deleteById(@PathVariable Long answerId) {
        answerService.findById(answerId);
        return ResponseEntity.accepted().build();
    }
}