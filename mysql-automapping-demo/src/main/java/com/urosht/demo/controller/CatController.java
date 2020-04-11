package com.urosht.demo.controller;

import com.urosht.demo.entity.Cat;
import com.urosht.demo.repository.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
public class CatController {

    final private static Logger LOG = LoggerFactory.getLogger("CatController");

    private CatRepository repository;

    public CatController(CatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get")
    public Cat get(final Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Cat create(@RequestBody final Cat cat) {
        return repository.save(cat);
    }

    @PutMapping("/update/{id}")
    public Cat update(@RequestBody final Cat newCat, @PathVariable Long id) {
        if (repository.existsById(id)) {
            newCat.setId(id);
            return repository.save(newCat);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        final Cat cat = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(cat);
    }

}
