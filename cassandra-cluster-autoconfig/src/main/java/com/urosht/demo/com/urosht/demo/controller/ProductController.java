package com.urosht.demo.com.urosht.demo.controller;

import com.urosht.demo.com.urosht.demo.entity.Product;
import com.urosht.demo.com.urosht.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

  private ProductRepository repository;

  public ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/get/{id}")
  public Product get(@PathVariable String id) {
    log.info("Get product with id {}", id);
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Could not find entity with id " + id));
  }

  @PostMapping("/create")
  public Product create(Product product) {
    log.info("Create product: {}", product);
    product.setId(UUID.randomUUID().toString());
    return repository.save(product);
  }

}
