package com.scholastic.intl.primedigital.api.v1.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.scholastic.intl.api.primedigital.constants.PrimeDigitalConstants;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = PrimeDigitalConstants.STUDENTQUIZRESULT)
public class StudentQuizeResultVo {
	
	@XmlElement(name="ID")
	@JsonProperty("ID")
	private String activityId;
	
	@XmlElement(name="testID")
	@JsonProperty("testID")
	private Integer quizId;
	
	@XmlElement(name="studentID")
	@JsonProperty("studentID")
	private Integer studentId;
	
	@XmlElement(name="ansArr")
	@JsonProperty("ansArr")
	private String answerArray;
	
	@XmlElement(name="resultArr")
	@JsonProperty("resultArr")
	private String resultArray;
	
	@XmlElement(name="resultQuestionObj")
	@JsonProperty("resultQuestionObj")
	private String resultQuestionObject;
	
	@XmlElement(name="totalQuestion")
	@JsonProperty("totalQuestion")
	private Integer totalQuestions;
	
	@XmlElement(name="correctAns")
	@JsonProperty("correctAns")
	private Integer correctAnswers;
	
	@XmlElement(name="resultPercentage")
	@JsonProperty("resultPercentage")
	private Double percentage;

	
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

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
