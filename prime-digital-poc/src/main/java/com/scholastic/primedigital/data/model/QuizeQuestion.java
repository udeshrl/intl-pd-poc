package com.scholastic.primedigital.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="quiz_questions")
public class QuizeQuestion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quize quize;
	
	@Column(name = "file_path", nullable = true, length = 250)
	private String filePath;
	
	@Column(name = "data", nullable = true, columnDefinition="longtext")
	private String data;
	
	@Column(name = "book_id", nullable = true, length = 11)
	private Integer bookId;
	
	@Column(name = "chapter_id", nullable = true, length = 11)
	private Integer chapterId;
	
	@Column(name = "concept_id", nullable = true, length = 11)
	private Integer conceptId;
	
	@Column(name = "catgorey", nullable = true, length = 11)
	private Integer categoreyId;
	
	@Column(name = "componets", nullable = true, length = 500)
	private String componets;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Quize getQuize() {
		return quize;
	}

	public void setQuize(Quize quize) {
		this.quize = quize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public Integer getConceptId() {
		return conceptId;
	}

	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}

	public Integer getCategoreyId() {
		return categoreyId;
	}

	public void setCategoreyId(Integer categoreyId) {
		this.categoreyId = categoreyId;
	}

	public String getComponets() {
		return componets;
	}

	public void setComponets(String componets) {
		this.componets = componets;
	}
	
	

}
