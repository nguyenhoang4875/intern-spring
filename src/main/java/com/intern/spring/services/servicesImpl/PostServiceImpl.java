package com.intern.spring.services.servicesImpl;

import com.intern.spring.models.Post;
import com.intern.spring.repositories.PostRepository;
import com.intern.spring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(int id) {
        postRepository.deleteById(id);
    }
}
