package com.scholastic.primedigital.data.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_quiz_activity_questions")
public class StudentQuizActivityQuestions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "student_activity_id")
	private StudentQuizActivity studentQuizActivity;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quize quize;
	
	@ManyToOne
	@JoinColumn(name = "quiz_question_id")
	private QuizeQuestion quizQuestions;

	@Column(name = "answer_issued_by_student", nullable = true, length = 11)
	private Integer answerbyStudent;
	
	@Basic
	private Integer sequence;
	
	@Column(name = "result", nullable = true)
	private Integer result;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentQuizActivity getStudentQuizActivity() {
		return studentQuizActivity;
	}

	public void setStudentQuizActivity(StudentQuizActivity studentQuizActivity) {
		this.studentQuizActivity = studentQuizActivity;
	}

	public Quize getQuize() {
		return quize;
	}

	public void setQuize(Quize quize) {
		this.quize = quize;
	}

	public QuizeQuestion getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(QuizeQuestion quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

	public Integer getAnswerbyStudent() {
		return answerbyStudent;
	}

	public void setAnswerbyStudent(Integer answerbyStudent) {
		this.answerbyStudent = answerbyStudent;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
	
	
	

}
