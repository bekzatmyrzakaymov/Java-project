package com.spring.project.service;


import com.spring.project.model.Book;
import com.spring.project.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public void addBook(Book book) {
        this.bookRepository.save(book);
    }


    public Book getBookById(int id) {
        Optional<Book> optional = bookRepository.findById(id);
        Book book = null;
        if (optional.isPresent()) {
            book = optional.get();
        }
        else {
            throw new RuntimeException("Book not found for id - " + id);
        }
        return book;
    }

    public void deleteBookById(int id) {
        this.bookRepository.deleteById(id);
    }
}
