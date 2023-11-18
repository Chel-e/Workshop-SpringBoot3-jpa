package com.demo.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.entities.User;
import com.demo.demo.repositories.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.get();
    }
}
