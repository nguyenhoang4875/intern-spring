package com.intern.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
