package com.intern.spring.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Blob image;
}
