package com.demo.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.demo.demo.entities.User;
import com.demo.demo.services.UserService;
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping // indidca que uma requisiçao do tipo get
    public ResponseEntity<List<User>> findAll() {
        List<User> result = userService.findAll();  
        return ResponseEntity.ok().body(result);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> FindById (@PathVariable Long id) // @PathVariable serve para indicar para o spring considerar o id como parametro que ira chegar pela url 
    {
        User result = userService.findById(id);
        return ResponseEntity.ok().body(result);
    }
}
