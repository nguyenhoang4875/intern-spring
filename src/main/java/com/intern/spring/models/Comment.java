package com.intern.spring.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
