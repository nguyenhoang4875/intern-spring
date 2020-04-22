package com.intern.spring.services.servicesImpl;

import com.intern.spring.models.Task;
import com.intern.spring.repositories.TaskRepository;
import com.intern.spring.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void truncateTable() {
        taskRepository.truncateTable();
    }
}
