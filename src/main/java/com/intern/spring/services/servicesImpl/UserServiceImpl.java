package com.intern.spring.services.servicesImpl;

import com.intern.spring.models.Users;
import com.intern.spring.repositories.UserRepository;
import com.intern.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Users> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Users user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}
