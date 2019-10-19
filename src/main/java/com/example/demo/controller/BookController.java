package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping(value = "/addBook", produces = {"application/json"})
	public ResponseEntity<List<Book>> addBook(@RequestBody Book book){
		
		Book savedBook = bookService.addBook(book);
		
		List<Book> books = new ArrayList<Book>();
		
		if(savedBook.getId() != 0) {
			
			books = bookService.getAllBooks();
			
			return new ResponseEntity<List<Book>>(books, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/getBooks", produces = {"application/json"})
	public ResponseEntity<List<Book>> getBooks(@RequestBody Book book){
					
			List<Book> books = bookService.getAllBooks();
			
			return new ResponseEntity<List<Book>>(books, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/getBook/{id}", produces = {"application/json"})
	public ResponseEntity<Book> getBookById(@PathVariable long id){
					
			Book book = bookService.getBookById(id);
			
			return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping(value = "/updateBook/{book}", produces = {"application/json"})
	public ResponseEntity<List<Book>> updateBook(@RequestBody Book book){
		
		Book savedBook = bookService.updateBook(book);
		
		List<Book> books = new ArrayList<Book>();
		
		if(savedBook.getId() != 0) {
			
			books = bookService.getAllBooks();
			
			return new ResponseEntity<List<Book>>(books, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping(value = "/deleteBook/{id}", produces = {"application/json"})
	public ResponseEntity<List<Book>> deleteBook(@RequestBody Long id){
		
		Book savedBook = bookService.deleteBook(id);
		
		List<Book> books = new ArrayList<Book>();
		
		if(savedBook.getId() != 0) {
			
			books = bookService.getAllBooks();
			
			return new ResponseEntity<List<Book>>(books, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.BAD_REQUEST);
		
	}
	
}
