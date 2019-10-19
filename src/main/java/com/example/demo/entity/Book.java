package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NamedQueries({
	@NamedQuery(name = "Book.findById", query = "FROM Book WHERE id = ?1"),
	@NamedQuery(name = "Book.findByStatusNamedQuery", query = "FROM Book WHERE status = ?1")
})

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 100)
	@Column(nullable = false)	
	private String title;
	
	@Size(max = 4000)
	@Column(nullable = false)
	private String description;
	
	@Size(max = 10)
	@Column(nullable = false)
	private String publish_year;
	
	@Size(max = 100)
	@Column(nullable = false)
	private String author_name;

	@Size(max = 10)
	private String last_update;

	private int status = 1;
	
	@Column(nullable = false)
	private long created_by;
	
	@OneToMany(mappedBy = "book")	
	private List<Comment> comments = new ArrayList<Comment>();

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", publish_year=" + publish_year
				+ ", author_name=" + author_name + ", last_update=" + last_update + ", status=" + status
				+ ", created_by=" + created_by + ", comments=" + comments + "]";
	}
}
