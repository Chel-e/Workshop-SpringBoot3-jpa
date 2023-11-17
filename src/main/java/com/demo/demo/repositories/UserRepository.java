package com.demo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
