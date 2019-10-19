package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {

		List<Book> books = new ArrayList<Book>();
		
		for(Book b: bookRepository.findByStatusNamed(1)) {
			books.add(b);
		}		
		
		return books;
	}

	public Book getBookById(long id) {
		
		Optional<Book> optBook = bookRepository.findById(id);

		if(optBook != null){
			return optBook.get();
		}
		
		return new Book();
	}

	public Book updateBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public Book deleteBook(Long id) {
		Book book = bookRepository.findById(id).get();
		book.setStatus(0);
		return bookRepository.save(book);
	}

	
}
