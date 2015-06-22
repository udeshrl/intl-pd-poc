package com.scholastic.primedigital.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "student_quiz_activites")
@NamedQueries({ 
	@NamedQuery(name = StudentQuizActivity.QUERY_ALL, 
			query = "SELECT SA FROM StudentQuizActivity SA WHERE SA.studentUser.id= :studentId "),
	@NamedQuery(name = StudentQuizActivity.QUERY_FIND_ACTIVITY, 
			query = "SELECT SA FROM StudentQuizActivity SA WHERE SA.studentUser.id= :studentId AND SA.quize.id= :quizeId "),
	@NamedQuery(name = StudentQuizActivity.QUERY_COMPLETED_ACTIVITY, 
			query = "SELECT SA FROM StudentQuizActivity SA WHERE SA.studentUser.id= :studentId AND SA.status :status"),
	
})
public class StudentQuizActivity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String QUERY_ALL = "studentQuizActivity.getStudentQuizActitiy";
	public static final String QUERY_FIND_ACTIVITY = "studentQuizActivity.findStudentQuizActitiy";
	public static final String QUERY_COMPLETED_ACTIVITY = "studentQuizActivity.getStudentCompletedQuizActivity";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "activity_date", nullable = true, length = 19)
	@Temporal(TemporalType.TIMESTAMP)
	private Date activityDate;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quize quize;
	
	@ManyToOne
	@JoinColumn(name="student_user_id",nullable=false)
	private User studentUser; 
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "studentQuizActivity", cascade= CascadeType.ALL)
	@BatchSize(size=40)
	protected List<StudentQuizActivityQuestions> question = new ArrayList<StudentQuizActivityQuestions>();
	
	@Column(name = "total_number_questions_issued", nullable = true, length = 11)
	private Integer totalNumberQuestionIssued;
	
	@Column(name = "total_number_questions_answered_correct", nullable = true, length = 11)
	private Integer numQuestionAnsweredCorrect;
	
	@Column(name = "result", nullable = true)
	private Integer result;
	
	@Column(name = "percentage", nullable = true)
	private Double percentage;
	
	@Column(name = "status", nullable = true)
	private Integer status;
	
	@Column(name = "answers_array", nullable = true, columnDefinition="longtext")
	private String answerArray;
	
	@Column(name = "result_array", nullable = true, columnDefinition="longtext")
	private String resultArray;
	
	@Column(name = "result_question_object", nullable = true, columnDefinition="longtext")
	private String resultQuestionObject;
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Quize getQuize() {
		return quize;
	}

	public void setQuize(Quize quize) {
		this.quize = quize;
	}

	public User getStudentUser() {
		return studentUser;
	}

	public void setStudentUser(User studentUser) {
		this.studentUser = studentUser;
	}

	public Integer getTotalNumberQuestionIssued() {
		return totalNumberQuestionIssued;
	}

	public void setTotalNumberQuestionIssued(Integer totalNumberQuestionIssued) {
		this.totalNumberQuestionIssued = totalNumberQuestionIssued;
	}

	public Integer getNumQuestionAnsweredCorrect() {
		return numQuestionAnsweredCorrect;
	}

	public void setNumQuestionAnsweredCorrect(Integer numQuestionAnsweredCorrect) {
		this.numQuestionAnsweredCorrect = numQuestionAnsweredCorrect;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<StudentQuizActivityQuestions> getQuestion() {
		return question;
	}

	public void setQuestion(List<StudentQuizActivityQuestions> question) {
		this.question = question;
	}

	public String getAnswerArray() {
		return answerArray;
	}

	public void setAnswerArray(String answerArray) {
		this.answerArray = answerArray;
	}

	public String getResultArray() {
		return resultArray;
	}

	public void setResultArray(String resultArray) {
		this.resultArray = resultArray;
	}

	public String getResultQuestionObject() {
		return resultQuestionObject;
	}

	public void setResultQuestionObject(String resultQuestionObject) {
		this.resultQuestionObject = resultQuestionObject;
	}

		

}
