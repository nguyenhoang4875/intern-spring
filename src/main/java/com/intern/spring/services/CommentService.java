package com.intern.spring.services;

import com.intern.spring.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    public List<Comment> findAll();

    public Optional<Comment> findById(int id);

    public Comment save(Comment comment);

    public void deleteById(int id);
}
