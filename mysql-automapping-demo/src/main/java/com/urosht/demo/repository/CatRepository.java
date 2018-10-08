package com.urosht.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.urosht.demo.entity.Cat;

public interface CatRepository extends CrudRepository<Cat, Long> {

}
