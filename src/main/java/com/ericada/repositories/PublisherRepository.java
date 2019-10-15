package com.ericada.repositories;

import com.ericada.model.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}