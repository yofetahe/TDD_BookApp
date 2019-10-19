package com.example.demo.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.serviceImpl.BookServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { BookServiceImpl.class })
@SpringBootTest
class BookServiceTests {
	
	@Autowired
	BookServiceImpl bookService;
	
	@MockBean
	private BookRepository bookRepository;
	
	Book book;
	
	@BeforeEach
	public void setupClass() {
				
		book = new Book();
		book.setId((long)1);
		book.setTitle("Title");
		book.setDescription("description");
		book.setPublish_year("11/20/2019");
		book.setAuthor_name("Author");
		book.setStatus(1);
	}

	@Test
	void test_addBook() {
		
		when(bookRepository.save(book)).thenReturn(book);
		
		Book result = bookService.addBook(book);		
		
		assertNotEquals(0, result.getId());
	}

	@Test
	void test_bookList() {
		
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		
		when(bookRepository.findAll()).thenReturn(books);
		
		List<Book> bks = bookService.getAllBooks();
		
		assertThat(bks).isNotEmpty();		
	}

	@Test
	void test_bookById() {
		
		Optional<Book> optBook = null;
		
		when(bookRepository.findById((long)1)).thenReturn(optBook);
		
		Book bk = bookService.getBookById((long)1);
		
		assertThat(bk.getId()).isEqualTo(0);		
	}
	
	@Test
	void test_updateBookById() {
		
		Book new_book = new Book();		
		new_book.setTitle("New Title");
		
		when(bookRepository.save(book)).thenReturn(new_book);
		
		Book bk = bookService.updateBook(book);
		
		assertThat(bk.getTitle()).isNotEqualTo(book.getTitle());
	}
	
	@Test
	void test_deleteBookById() {
		
		Book new_book = new Book();		
		new_book.setStatus(0);
		
		when(bookRepository.save(book)).thenReturn(new_book);
		
		Book bk = bookService.updateBook(book);
		
		assertThat(bk.getStatus()).isEqualTo(0);
	}
	
}
