package com.example.demo.controller;
import com.example.demo.model.Answer;
import com.example.demo.model.Footballer;
import com.example.demo.service.AnswerService;
import com.example.demo.service.FootballerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/footballers")
public class FootballerController {

    private final FootballerService footballerService;
    private final AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Footballer>> findAllFootballers(){
        return ResponseEntity.ok(footballerService.findAll());
    }
    @GetMapping("/{footballerId}")
    public ResponseEntity<Footballer> footballerById(@PathVariable Long footballerId){
        Optional<Footballer> footballerOptional = footballerService.findById(footballerId);
        if (!footballerOptional.isPresent()){
            log.error("footballer id : " + footballerId + " not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(footballerOptional.get());
    }
    @PostMapping("/{answerId}/footballers")
    public ResponseEntity createFootballer(@RequestBody Footballer footballer, @PathVariable Long answerId){
        Optional<Answer> answerOptional = answerService.findById(answerId);
        if (!answerOptional.isPresent()){
            log.error("answer id : " + answerId + " not exist");
            ResponseEntity.badRequest().build();
        }
        Answer answer = answerOptional.get();
        footballer.setAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(footballerService.save(footballer));
    }
    @PatchMapping("/{footballerId}")
    public ResponseEntity<Footballer> update(@PathVariable Long footballerId,
                                             @RequestBody Footballer updatingFootballer) {
        Optional<Footballer> footballerOptional = footballerService.findById(footballerId);
        if (!footballerOptional.isPresent()) {
            log.error("Footballer id " + footballerId + "   not exist");
            ResponseEntity.badRequest().build();
        }

        Footballer footballer = footballerOptional.get();
        if (!StringUtils.isEmpty(updatingFootballer.getName())) footballer.setName(updatingFootballer.getName());
        if (!StringUtils.isEmpty(updatingFootballer.getPictureUrl())) footballer.setPictureUrl(updatingFootballer.getPictureUrl());
        if (!Objects.isNull(updatingFootballer.getAnswer())) footballer.setAnswer(updatingFootballer.getAnswer());

        return ResponseEntity.accepted().body(footballerService.save(footballer));
    }
    @DeleteMapping("/{footballerId}")
    public ResponseEntity deleteById(@PathVariable Long footballerId){
        footballerService.deleteById(footballerId);
        return ResponseEntity.accepted().build();
    }
}
