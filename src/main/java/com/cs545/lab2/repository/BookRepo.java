package com.cs545.lab2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs545.lab2.domain.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    void deleteById(Long id);

    Book save(Book book);
}
