package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    // The service depends on the repository
    private BookRepository bookRepository;

    // We need a Setter method so Spring can inject the repository via XML
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("BookService: Starting library management process.");
        if (bookRepository != null) {
            bookRepository.fetchBooks();
        } else {
            System.out.println("Error: Repository was not injected!");
        }
    }
}