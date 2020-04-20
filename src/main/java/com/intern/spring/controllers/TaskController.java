package com.intern.spring.controllers;

import com.intern.spring.exeptions.CustomNotFoundException;
import com.intern.spring.models.Task;
import com.intern.spring.services.TaskService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Optional<Task> GetById(@PathVariable int id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isEmpty()) {
            throw new CustomNotFoundException("Task is not found with id: " + id);
        }
        return task;
    }

    @GetMapping
    public Iterable<Task> getAll() {
        return taskService.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setId(0);
        taskService.save(task);
        return task;
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isEmpty()) {
            throw new CustomNotFoundException("Task is not found with id: " + id);
        }
        taskService.deleteById(id);
        return "Deleted task id: " + id;
    }
}
