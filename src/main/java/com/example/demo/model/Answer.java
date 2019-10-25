package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answers")
public class Answer extends ModelAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 80)
    @NotNull
    @Column(name = "first_answer")
    private String firstAnswer;
    @Size(min = 2, max = 80)
    @NotNull
    @Column(name = "second_answer")
    private String secondAnswer;
}
