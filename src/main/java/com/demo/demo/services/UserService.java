package com.demo.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.entities.User;
import com.demo.demo.repositories.UserRepository;
import com.demo.demo.services.exceptions.ResourceNotFoundException;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User obj) {
        return userRepository.save(obj);
    }
    public void delete(Long id) {
        User obj = this.findById(id);
        userRepository.delete(obj);
    } 
    public User update(Long id, User obj) {
        if (userRepository.existsById(id)) {
            User entity = userRepository.getReferenceById(id);
            updateData(entity, obj);
            return userRepository.save(entity);
        }
        return null;
    }
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
