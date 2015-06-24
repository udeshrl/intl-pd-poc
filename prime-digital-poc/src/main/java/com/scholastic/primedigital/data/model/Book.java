package com.scholastic.primedigital.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy="bookQuestion")
	private List<QuizeQuestion> quizeQuestions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<QuizeQuestion> getQuizeQuestions() {
		return quizeQuestions;
	}

	public void setQuizeQuestions(List<QuizeQuestion> quizeQuestions) {
		this.quizeQuestions = quizeQuestions;
	}
	
	
	

}
