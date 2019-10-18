package com.example.demo.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.serviceImpl.BookServiceImpl;

class BookServiceTests {
	
	BookServiceImpl bookService = null;
	
	@BeforeEach
	public void setupClass() {
		bookService = new BookServiceImpl();
	}

	@Test
	void test_addBook() {
		
		assertNotEquals(0, bookService.addBook());
	}

}
