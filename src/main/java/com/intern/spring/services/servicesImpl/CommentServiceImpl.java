package com.intern.spring.services.servicesImpl;

import com.intern.spring.models.Comment;
import com.intern.spring.repositories.CommentRepository;
import com.intern.spring.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }
}
