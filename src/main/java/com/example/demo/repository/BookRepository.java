package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	@Query("SELECT u FROM Book u WHERE u.status = ?1")
	Iterable<Book> findByStatusNamed(int status);
	
	//Iterable<Book> findByStatusEquals(int status);
	
	//Iterable<Book> findByStatusNamedQuery(int status); -- not working
}
