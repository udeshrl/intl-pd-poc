package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="questions")
@JsonRootName("questions")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuizQuestionsType {
	
	private Integer questionId;
	private Integer sequence;
	private String  filePath;
	private String  jsonData;
	private Integer bookId;
	private Integer chapterId;
	private Integer conceptId;
	private Integer categoreyId;
	private String  componets;
	private List<BookType> bookType;
	private List<ChapterType> chapterType;
	private List<ConceptType> conceptType;
	private List<TopicType> topicType;
	
	
	
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
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
	public List<BookType> getBookType() {
		if (bookType == null) {
			bookType = new ArrayList<BookType>();
		}
		return bookType;
	}
	public void setBookType(List<BookType> bookType) {
		this.bookType = bookType;
	}
	public List<ChapterType> getChapterType() {
		if (chapterType == null) {
			chapterType = new ArrayList<ChapterType>();
		}
		return chapterType;
	}
	public void setChapterType(List<ChapterType> chapterType) {
		this.chapterType = chapterType;
	}
	public List<ConceptType> getConceptType() {
		if (conceptType == null) {
			conceptType = new ArrayList<ConceptType>();
		}
		return conceptType;
	}
	public void setConceptType(List<ConceptType> conceptType) {
		this.conceptType = conceptType;
	}
	public List<TopicType> getTopicType() {
		if (topicType == null) {
			topicType = new ArrayList<TopicType>();
		}
		return topicType;
	}
	public void setTopicType(List<TopicType> topicType) {
		this.topicType = topicType;
	}

	public void addbookType(BookType bookType) {
		if (bookType != null) {
			getBookType().add(bookType);
		}
	}
	
	public void addchapterType(ChapterType chapterType) {
		if (chapterType != null) {
			getChapterType().add(chapterType);
		}
	}
	
	public void addconceptType(ConceptType conceptType) {
		if (conceptType != null) {
			getConceptType().add(conceptType);
		}
	}
	
	public void addtopicType(TopicType topicType) {
		if (topicType != null) {
			getTopicType().add(topicType);
		}
	}

}
