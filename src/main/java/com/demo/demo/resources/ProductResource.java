package com.demo.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entities.Product;
import com.demo.demo.services.ProductService;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> findAll() {
        List<Product> result = productService.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product result = productService.findById(id);
        return ResponseEntity.ok().body(result);
    }
}
