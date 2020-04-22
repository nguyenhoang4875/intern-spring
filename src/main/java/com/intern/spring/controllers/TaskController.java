package com.intern.spring.controllers;

import com.intern.spring.exeptions.CustomNotFoundException;
import com.intern.spring.models.Task;
import com.intern.spring.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Object GetById(@PathVariable int id) {
        Optional<Task> task = taskService.findById(id);
        verifyTaskExistById(id, task);
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

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable int id) {
        task.setId(id);
        taskService.save(task);
        return task;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        Optional<Task> task = taskService.findById(id);
        verifyTaskExistById(id, task);
        taskService.deleteById(id);
    }

    public void verifyTaskExistById(@PathVariable int id, Optional<Task> task) {
        if (task.isEmpty()) {
            throw new CustomNotFoundException("Task is not found with id: " + id);
        }
    }
}
