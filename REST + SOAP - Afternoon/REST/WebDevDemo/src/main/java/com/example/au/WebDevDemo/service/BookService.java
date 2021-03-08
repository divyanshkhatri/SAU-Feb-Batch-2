package com.example.au.WebDevDemo.service;

import com.example.au.WebDevDemo.model.Book;
import com.example.au.WebDevDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public int saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    public Book findBookId(int id) {
        return bookRepository.findBookById(id);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public boolean deleteBook(int id) {
        return bookRepository.deleteBookById(id);
    }
}
