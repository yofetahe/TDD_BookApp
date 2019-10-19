package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;

public interface BookService {

	public Book addBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(long id);
	public Book updateBook(Book book);
	public Book deleteBook(Long id);

}
