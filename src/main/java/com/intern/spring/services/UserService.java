package com.intern.spring.services;

import com.intern.spring.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public Optional<User> findById(int id);

    public User save(User user);

    public void deleteById(int id);

}
