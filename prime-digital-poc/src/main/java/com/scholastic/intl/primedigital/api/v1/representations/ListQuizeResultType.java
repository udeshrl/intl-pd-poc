package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name = "quiz_result_list")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class ListQuizeResultType {
	
	private List<QuizeResultType> quizResultType;

	public List<QuizeResultType> getQuizResultType() {
		if (quizResultType == null) {
			quizResultType = new ArrayList<QuizeResultType>();
		}
		return quizResultType;
	}
	
	public void addQuizeResultType(QuizeResultType quizeResultType) {
		if (quizeResultType != null) {
			getQuizResultType().add(quizeResultType);
		}
	}

	public void setQuizResultType(List<QuizeResultType> quizResultType) {
		this.quizResultType = quizResultType;
	}
	
	

}
