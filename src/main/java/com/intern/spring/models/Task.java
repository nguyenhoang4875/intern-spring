package com.intern.spring.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "assigned_user")
    private String assignedUser;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "detail")
    private String detail;

    @Column(name = "status")
    private String status;

}
