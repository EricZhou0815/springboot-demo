package com.ericada.repositories;

import com.ericada.model.Author;

import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}