package com.intern.spring.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String username;

    @Column
    private String authority;

}
