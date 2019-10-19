package com.example.demo.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Book;
import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CommentServiceTest {

	@MockBean
	private CommentRepository commentRepository;
	
	@Autowired
	CommentServiceImpl commentService;
	
	Comment comment;
	
	@BeforeEach
	public void setupClass() {

		Book book = new Book();
		book.setId((long)1);
		
		comment = new Comment();
		comment.setId(1);
		comment.setBook(book);
		comment.setContent("Comment content");
		comment.setCreated_date("10/10/2019");
		comment.setStatus(1);
		
	}
	
	@Test
	void test_addCommentByBookId() {
		Mockito.when(commentRepository.save(comment)).thenReturn(comment);
		Comment newComment = commentService.addCommentByBookId(comment);
		System.out.println(comment.getId());
		
		assertEquals(comment.getId(), newComment.getId());
	}
	
	@Test
	void test_updateCommentBookById() {
		
		Comment new_comment = new Comment();		
		new_comment.setContent("New Content");
		
		when(commentRepository.save(comment)).thenReturn(new_comment);
		
		Comment co = commentService.updateComment(comment);
		
		assertThat(co.getContent()).isEqualTo("New Content");
	}
	
	@Test
	void test_getCommentById() {
		Optional<Comment> optComment = null;
		when(commentRepository.findById(comment.getId())).thenReturn(optComment);
		Comment co = commentService.getCommentById((long)1);
		assertThat(co.getId()).isEqualTo(0);
	}

	@Test
	void test_deleteCommentByBookId() {
		
		Comment new_comment = new Comment();		
		new_comment.setStatus(0);
		
		when(commentRepository.save(comment)).thenReturn(new_comment);
		
		Comment co = commentService.updateComment(comment);
		
		assertThat(co.getStatus()).isEqualTo(0);
	}
	
}
