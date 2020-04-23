package com.intern.spring.services;

import com.intern.spring.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<Post> findAll();

    public Optional<Post> findById(int id);

    public Post save(Post post);

    public void deleteById(int id);

}
