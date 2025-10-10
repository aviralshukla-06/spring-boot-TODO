package com.aviral.myFirstDocumentation.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="todo_title")
    private String title;
    private boolean completed;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

}


