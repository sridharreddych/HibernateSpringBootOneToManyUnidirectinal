package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert one author with three books  ...");
            bookstoreService.insertAuthorWithBooks();

            System.out.println("\n---------------------------------------------");

            System.out.println("\nInsert new book to an author  ...");
            bookstoreService.insertNewBook();

            System.out.println("\n---------------------------------------------");

            System.out.println("\nDelete last book of an author  ...");
            bookstoreService.deleteLastBook();

            System.out.println("\n---------------------------------------------");

            System.out.println("\nDelete first book of an author  ...");
            bookstoreService.deleteFirstBook();
        };
    }
}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * Why You Should Avoid Unidirectional @OneToMany And Prefer Bidirectional @OneToMany Relationship

Description: As a rule of thumb, unidirectional @OneToMany association is less efficient than the bidirectional @OneToMany or the unidirectional @ManyToOne associations. This application is a sample that exposes the DML statements generated for reads, writes and removal operations when the unidirectional @OneToMany mapping is used.

Key points:

regular unidirectional @OneToMany is less efficient than bidirectional @OneToMany association
using @OrderColumn come with some optimizations for removal operations but is still less efficient than bidirectional @OneToMany association
using @JoinColumn eliminates the junction table but is still less efficient than bidirectional @OneToMany association
using Set instead of List or bidirectional @OneToMany with @JoinColumn relationship (e.g., @ManyToOne @JoinColumn(name = "author_id", updatable = false, insertable = false)) still performs worse than bidirectional @OneToMany association
 * 
 * 
 */
