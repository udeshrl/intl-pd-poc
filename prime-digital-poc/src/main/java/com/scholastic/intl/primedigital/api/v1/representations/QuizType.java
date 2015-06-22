package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name = "quizzes")
@JsonRootName("quizzes")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuizType {

	private Integer quizId;
	private String quizName;
	private List<QuizQuestionsType> questions = null;

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public List<QuizQuestionsType> getQuestions() {

		if (questions == null) {
			questions = new ArrayList<QuizQuestionsType>();
		}
		return questions;
	}

	public void setQuestions(List<QuizQuestionsType> questions) {
		this.questions = questions;
	}

	public void addquestionType(QuizQuestionsType questionsType) {
		if (questionsType != null) {
			getQuestions().add(questionsType);
		}
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	

}
