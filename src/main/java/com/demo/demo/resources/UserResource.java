package com.demo.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import com.demo.demo.entities.User;
import com.demo.demo.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


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
    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody User obj) { // @RequestBody indica que o spring ira extrair do corpo da solicitacao http um obj do tipo user e enviar para esse metodo 
        obj = userService.insert(obj);
        // nessa classe vamos retornar um codigo diferente do convencioanla (200), vamos retornar o codigo 
        // 201 que representa que criamos um recurso no servidor 
        // para isso teremos que usar uma classe eespecial
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
    
}
