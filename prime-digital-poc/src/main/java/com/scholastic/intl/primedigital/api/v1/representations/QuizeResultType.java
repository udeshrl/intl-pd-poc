package com.scholastic.intl.primedigital.api.v1.representations;

public class QuizeResultType {
	
	private Integer quizId;
	private Integer studentId;
	private String answerArray;
	private String resultArray;
	private String resultQuestionObject;
	private Integer totalQuestions;
	private Integer correctAnswers;
	private Double percentage;
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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
	public Integer getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public Integer getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(Integer correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	

}
