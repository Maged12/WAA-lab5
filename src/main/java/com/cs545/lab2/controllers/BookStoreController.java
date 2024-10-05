package com.cs545.lab2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs545.lab2.domain.Book;
import com.cs545.lab2.repository.BookRepo;

@RestController
@RequestMapping
public class BookStoreController {

    @Autowired
    private BookRepo bookRepo;

    // <--------------------- URI versioning ------------------------>
    @GetMapping("/v1/books")
    public List<Book> getAllBooksURI() {
        final List<Book> myBooks = bookRepo.findAll();
        return myBooks;
    }

    @GetMapping("/v1/books/{id}")
    public ResponseEntity<Book> getbookByIdURI(
            @PathVariable Long id) {
        final Optional<Book> myBooks = bookRepo.findById(id);
        return myBooks.isPresent() ? ResponseEntity.ok().body(myBooks.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping("/v1/books")
    public ResponseEntity<Book> createBookURI(@RequestBody Book book) {
        final Book myBook = bookRepo.save(book);
        return ResponseEntity.status(201).body(myBook);
    }

    @PutMapping("v1/books/{id}")
    public ResponseEntity<Book> updateBookURI(@PathVariable String id, @RequestBody Book updBook) {
        final Book myBook = bookRepo.save(Book.builder().id(Long.parseLong(id)).title(updBook.getTitle())
                .isbn(updBook.getIsbn()).price(updBook.getPrice()).build());
        return ResponseEntity.status(200).body(myBook);
    }

    @DeleteMapping("v1/books/{id}")
    public ResponseEntity<Book> deleteBookURI(@PathVariable String id) {
        bookRepo.deleteById(Long.parseLong(id));
        return ResponseEntity.status(200).build();
    }

    // <--------------------- Media type versioning ------------------------>

    @GetMapping(value = "/books", produces = "application/cs.miu.edu-v2+json")
    public List<Book> getAllBooksMediVer() {
        final List<Book> myBooks = bookRepo.findAll();
        return myBooks;
    }

    @GetMapping(value = "/books/{id}", produces = "application/cs.miu.edu-v2+json")
    public ResponseEntity<Book> getbookByIdMediVer(
            @PathVariable Long id) {

        final Optional<Book> myBooks = bookRepo.findById(id);
        return myBooks.isPresent() ? ResponseEntity.ok().body(myBooks.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping(value = "/books", produces = "application/cs.miu.edu-v2+json")
    public ResponseEntity<Book> createBookMediVer(@RequestBody Book book) {
        final Book myBook = bookRepo.save(book);
        return ResponseEntity.status(201).body(myBook);
    }

    @PutMapping(value = "/books/{id}", produces = "application/cs.miu.edu-v2+json")
    public ResponseEntity<Book> updateBookMediVer(@PathVariable String id, @RequestBody Book updBook) {
        final Book myBook = bookRepo.save(Book.builder().id(Long.parseLong(id)).title(updBook.getTitle())
                .isbn(updBook.getIsbn()).price(updBook.getPrice()).build());
        return ResponseEntity.status(200).body(myBook);
    }

    @DeleteMapping(value = "/books/{id}", produces = "application/cs.miu.edu-v2+json")
    public ResponseEntity<Book> deleteBookMediVer(@PathVariable String id) {
        bookRepo.deleteById(Long.parseLong(id));
        return ResponseEntity.status(200).build();
    }

    // <--------------------- (Custom) header versioning ------------------------>

    @GetMapping(value = "/books", headers = "X-API-VERSION=2")
    public List<Book> getAllBooksCustomVer() {
        final List<Book> myBooks = bookRepo.findAll();
        return myBooks;
    }

    @GetMapping(value = "/books/{id}", headers = "X-API-VERSION=2")
    public ResponseEntity<Book> getbookByIdCustomVer(
            @PathVariable Long id) {

        final Optional<Book> myBooks = bookRepo.findById(id);
        return myBooks.isPresent() ? ResponseEntity.ok().body(myBooks.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/books", headers = "X-API-VERSION=2")
    public ResponseEntity<Book> createBookCustomVer(@RequestBody Book book) {
        final Book myBook = bookRepo.save(book);
        return ResponseEntity.status(201).body(myBook);
    }

    @PutMapping(value = "/books/{id}", headers = "X-API-VERSION=2")
    public ResponseEntity<Book> updateBookCustomVer(@PathVariable String id, @RequestBody Book updBook) {
        final Book myBook = bookRepo.save(Book.builder().id(Long.parseLong(id)).title(updBook.getTitle())
                .isbn(updBook.getIsbn()).price(updBook.getPrice()).build());
        return ResponseEntity.status(200).body(myBook);
    }

    @DeleteMapping(value = "/books/{id}", headers = "X-API-VERSION=2")
    public ResponseEntity<Book> deleteBookCustomVer(@PathVariable String id) {
        bookRepo.deleteById(Long.parseLong(id));
        return ResponseEntity.status(200).build();
    }

    // <--------------------- Request Parameter versioning ------------------------>

    @GetMapping(value = "/books", params = "version=1")
    public List<Book> getAllBooksParameterVer() {
        final List<Book> myBooks = bookRepo.findAll();
        return myBooks;
    }

    @GetMapping(value = "/books/{id}", params = "version=1")
    public ResponseEntity<Book> getbookByIdParameterVer(
            @PathVariable Long id) {

        final Optional<Book> myBooks = bookRepo.findById(id);
        return myBooks.isPresent() ? ResponseEntity.ok().body(myBooks.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping(value = "/books", params = "version=1")
    public ResponseEntity<Book> createBookParameterVer(@RequestBody Book book) {
        final Book myBook = bookRepo.save(book);
        return ResponseEntity.status(201).body(myBook);
    }

    @PutMapping(value = "/books/{id}", params = "version=1")
    public ResponseEntity<Book> updateBookParameterVer(@PathVariable String id, @RequestBody Book updBook) {
        final Book myBook = bookRepo.save(Book.builder().id(Long.parseLong(id)).title(updBook.getTitle())
                .isbn(updBook.getIsbn()).price(updBook.getPrice()).build());
        return ResponseEntity.status(200).body(myBook);
    }

    @DeleteMapping(value = "/books/{id}", params = "version=1")
    public ResponseEntity<Book> deleteBookParameterVer(@PathVariable String id) {
        bookRepo.deleteById(Long.parseLong(id));
        return ResponseEntity.status(200).build();
    }

}
