package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name = "quiz_list")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class ListQuizeType {

	private List<QuizType> quizTypes;

	public List<QuizType> getQuizTypes() {
		if (quizTypes == null) {
			quizTypes = new ArrayList<QuizType>();
		}
		return quizTypes;
	}

	public void addQuizType(QuizType quizType) {
		if (quizType != null) {
			getQuizTypes().add(quizType);
		}
	}

	public void setQuizTypes(List<QuizType> quizTypes) {
		this.quizTypes = quizTypes;
	}

}
