package com.ericada.bootstrap;

import com.ericada.model.*;
import com.ericada.repositories.AuthorRepository;
import com.ericada.repositories.BookRepository;
import com.ericada.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,BookRepository bookRepository,PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository=publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){

        Publisher publisher=new Publisher();
        publisher.setName("Harper Colins");
        publisher.setAddress("Wellington");
        publisherRepository.save(publisher);

        //Eric
        Author eric=new Author("Eric", "Evans");
        Book ddd=new Book("Domian Driven Design","1234",publisher);
      
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);
   

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod=new Author("Rod","Johnson");
        Book noEJB=new Book("J2EE Development","23444",publisher);
        rod.getBook().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}