package com.urosht.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urosht.entity.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

	Cat findByName(String name);
}
