package com.ericada.bootstrap;

import com.ericada.model.*;
import com.ericada.repositories.AuthorRepository;
import com.ericada.repositories.BookRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository,BookRepository bookRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){

        //Eric
        Author eric=new Author("Eric", "Evans");
        Book ddd=new Book("Domian Driven Design","1234","Harper Colins");
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod=new Author("Rod","Johnson");
        Book noEJB=new Book("J2EE Development","23444","Wrox");
        rod.getBook().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}