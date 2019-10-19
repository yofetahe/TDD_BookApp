package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Size(max = 100)
	@Column(nullable = false)
	private String content;

	@Size(max = 10)
	@Column(nullable = false)
	private String created_date;

	@Size(max = 10)
	@Column(nullable = true)
	private String last_update;
	
	private int status = 1;
	
	@Column(nullable = false)
	private long created_by;
}
