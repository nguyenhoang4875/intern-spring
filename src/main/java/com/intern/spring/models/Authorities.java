package com.intern.spring.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String username;

    @Column
    private String authority;

    @Column(name = "user_id")
    private Integer userId;
}
