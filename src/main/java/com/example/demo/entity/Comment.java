package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	@Getter
	@Setter
	private Long book_id;
	
	@Size(max = 100)
	@Column(nullable = false)
	@Getter
	@Setter
	private String content;

	@Size(max = 10)
	@Column(nullable = false)
	@Getter
	@Setter
	private String created_date;

	@Size(max = 10)
	@Column(nullable = true)
	@Getter
	@Setter
	private String last_update;
	
	@Getter
	@Setter
	private int status = 1;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private long created_by;
}
