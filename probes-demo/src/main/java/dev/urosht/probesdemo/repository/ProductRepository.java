package dev.urosht.probesdemo.repository;

import dev.urosht.probesdemo.enity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
