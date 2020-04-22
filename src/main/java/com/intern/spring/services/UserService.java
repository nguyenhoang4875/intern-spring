package com.intern.spring.services;

import com.intern.spring.models.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<Users> findAll();

    public Optional<Users> findById(int id);

    public void save(Users user);

    public void deleteById(int id);

}
