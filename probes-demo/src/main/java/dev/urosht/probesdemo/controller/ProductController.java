package dev.urosht.probesdemo.controller;

import dev.urosht.probesdemo.enity.Product;
import dev.urosht.probesdemo.exception.ProductNotFoundException;
import dev.urosht.probesdemo.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductRepository repository;

    public ProductController(final ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/product/{id}")
    public Product get(@PathVariable final String id) {
        return repository.findById(Long.parseLong(id)).orElseThrow(ProductNotFoundException::new);
    }
}
