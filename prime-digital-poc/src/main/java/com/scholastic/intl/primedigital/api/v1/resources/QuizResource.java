package com.scholastic.intl.primedigital.api.v1.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scholastic.intl.primedigital.api.v1.representations.BookType;
import com.scholastic.intl.primedigital.api.v1.representations.ChapterType;
import com.scholastic.intl.primedigital.api.v1.representations.ConceptType;
import com.scholastic.intl.primedigital.api.v1.representations.ListQuizeResultType;
import com.scholastic.intl.primedigital.api.v1.representations.ListQuizeType;
import com.scholastic.intl.primedigital.api.v1.representations.LstQuizReportType;
import com.scholastic.intl.primedigital.api.v1.representations.QuizQuestionsType;
import com.scholastic.intl.primedigital.api.v1.representations.QuizReportType;
import com.scholastic.intl.primedigital.api.v1.representations.QuizType;
import com.scholastic.intl.primedigital.api.v1.representations.QuizeResultType;
import com.scholastic.intl.primedigital.api.v1.representations.TopicType;
import com.scholastic.intl.primedigital.api.v1.vo.ResponseVo;
import com.scholastic.intl.primedigital.api.v1.vo.StudentQuizeResultVo;
import com.scholastic.primedigital.data.model.Book;
import com.scholastic.primedigital.data.model.Chapter;
import com.scholastic.primedigital.data.model.Concept;
import com.scholastic.primedigital.data.model.QuizeQuestion;
import com.scholastic.primedigital.data.model.StudentQuizActivity;
import com.scholastic.primedigital.data.model.Topic;

/**
 * @author dora.babu
 * 
 */
@Path("/quizzes")
public class QuizResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(QuizResource.class);

	@Inject
	QuizService quizService;

	@Inject
	EntityManager em;

	@Inject
	UserTransaction ut;



	@GET
	@Path("/getquizeData/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListQuizeType getQuizzesData(@PathParam("studentId") Integer studentId) {
			try {
					ut.begin();
				List<StudentQuizActivity> studentActity = quizService.getStudentQuizActitiy(studentId);
				ListQuizeType listquizetype = getQuizeTypeLst(studentActity);
				ut.commit();
				return listquizetype;

				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		
		
	}
	
	private ListQuizeType getQuizeTypeLst(List<StudentQuizActivity> studentActity) {
		ListQuizeType listquizetype = new ListQuizeType();
			for (StudentQuizActivity activity : studentActity) {
						QuizType quizType = new QuizType();
						quizType.setQuizId(activity.getQuize().getId());
						quizType.setQuizName(activity.getQuize().getName());
						for (QuizeQuestion question : activity.getQuize().getQuestions()) {
								QuizQuestionsType questionsType = new QuizQuestionsType();
								questionsType.setQuestionId(question.getId());
								// questionsType.setSequence(question.getSequence());
								questionsType.setFilePath(question.getFilePath());
								questionsType.setJsonData(question.getData());
								questionsType.setComponets(question.getComponets());
								questionsType.setBookId(question.getBookId());
								questionsType.setChapterId(question.getChapterId());
								questionsType.setConceptId(question.getConceptId());
								questionsType.setCategoreyId(question.getCategoreyId());
								quizType.addquestionType(questionsType);
								questionsType.setBookType(getBookTypeQuestion(question.getBookQuestion()));
								questionsType.setChapterType(getChapterTypeQuestion(question.getChapterQuestion()));
								questionsType.setConceptType(getConceptTypeQuestion(question.getConceptQuestion()));
								questionsType.setTopicType(getTopicTypeQuestion(question.getTopicQuestion()));
				}
				listquizetype.addQuizType(quizType);
			}
		return listquizetype;
		
	}
	
	private List<BookType> getBookTypeQuestion (List<Book> bookLst) {
			List<BookType> lstBookType = new ArrayList<BookType>();
				for (Book book : bookLst) {
						BookType booktype = new BookType();
						booktype.setId(book.getId());
						booktype.setName(book.getName());
						lstBookType.add(booktype);
				}
			return lstBookType;
		}
	
	
	private List<ChapterType> getChapterTypeQuestion (List<Chapter> chapterLst) {
		List<ChapterType> lstChapterType = new ArrayList<ChapterType>();
			for (Chapter chapter : chapterLst) {
					ChapterType chapterType = new ChapterType();
					chapterType.setId(chapter.getId());
					chapterType.setName(chapter.getName());
					chapterType.setCode(chapter.getCode());	
					lstChapterType.add(chapterType);
			}
		
			return lstChapterType;
		
	}
	
	private List<ConceptType> getConceptTypeQuestion (List<Concept> conceptLst) {
		List<ConceptType> lstConceptType = new ArrayList<ConceptType>();
			for (Concept concept : conceptLst) {
					ConceptType conceptType = new ConceptType();
					conceptType.setId(concept.getId());
					conceptType.setName(concept.getName());
					lstConceptType.add(conceptType);
			}
		
			return lstConceptType;
		
	}
	
	
	private List<TopicType> getTopicTypeQuestion (List<Topic> topicLst) {
		List<TopicType> lstTopicType = new ArrayList<TopicType>();
			for (Topic topic : topicLst) {
					TopicType topicType = new TopicType();
					topicType.setId(topic.getId());
					topicType.setName(topic.getName());
					topicType.setCode(topic.getCode());
					lstTopicType.add(topicType);
			}
		
			return lstTopicType;
		
	}

	@GET
	@Path("/getquizeResultData/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListQuizeResultType getQuizzeResult(@PathParam("studentId") Integer studentId) {
		try {
			ut.begin();
			List<StudentQuizActivity> studentActity = quizService.getStudentCompletedQuizActivity(studentId);
			ListQuizeResultType listQuizeResult = getQuizeResultType(studentActity);
			ut.commit();
			return listQuizeResult;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private ListQuizeResultType getQuizeResultType(List<StudentQuizActivity> studentQuizeActity) {
		
		ListQuizeResultType listQuizeResult = new ListQuizeResultType();
			for (StudentQuizActivity activity : studentQuizeActity) {
					QuizeResultType quizeResultType = new QuizeResultType();
					quizeResultType.setQuizId(activity.getQuize().getId());
					quizeResultType.setStudentId(activity.getStudentUser().getId());
					quizeResultType.setResultArray(activity.getResultArray());
					quizeResultType.setAnswerArray(activity.getAnswerArray());
					quizeResultType.setResultQuestionObject(activity.getResultQuestionObject());
					quizeResultType.setTotalQuestions(activity.getTotalNumberQuestionIssued());
					quizeResultType.setCorrectAnswers(activity.getNumQuestionAnsweredCorrect());
					quizeResultType.setPercentage(activity.getPercentage());
					listQuizeResult.addQuizeResultType(quizeResultType);
			}
		return listQuizeResult;
	}

	@POST
	@Path("/putSubmitedQuizData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseVo saveQuiz(StudentQuizeResultVo studentQuizResultVo) {
		ResponseVo response = new ResponseVo();
		StudentQuizActivity studnetQuizActivity = quizService
				.findStudentQuizActitiy(studentQuizResultVo.getStudentId(),
						studentQuizResultVo.getQuizId());

		if (studnetQuizActivity != null) {

			studnetQuizActivity.setResultArray(studentQuizResultVo
					.getResultArray());
			studnetQuizActivity.setAnswerArray(studentQuizResultVo
					.getAnswerArray());
			studnetQuizActivity.setResultQuestionObject(studentQuizResultVo
					.getResultQuestionObject());
			studnetQuizActivity
					.setTotalNumberQuestionIssued(studentQuizResultVo
							.getTotalQuestions());
			studnetQuizActivity
					.setNumQuestionAnsweredCorrect(studentQuizResultVo
							.getCorrectAnswers());
			studnetQuizActivity.setPercentage(studentQuizResultVo
					.getPercentage());
			studnetQuizActivity.setStatus(0);
			try {
				ut.begin();
				em.merge(studnetQuizActivity);
				ut.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}

			response.setMessage("SUCESSS");
			// studnetQuizActivity.setCorrectAnswers(studentQuizResultVo.getCorrectAnswers());
		} else {
			response.setMessage("FAILURE");
		}

		return response;

	}
	
	

	@GET
	@Path("/getQuizeReport/{studentIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public LstQuizReportType getStudentQuizeReport(@PathParam("studentIds")String studentId)  {
		try {
			
			String [] studentIds = studentId.split(",");
			LstQuizReportType lstquizReportType = new LstQuizReportType();
			ut.begin();
			for (String studentUserId : studentIds) {
				List<StudentQuizActivity> studentActity = quizService.getStudentCompletedQuizActivity(Integer.valueOf(studentUserId));
				QuizReportType quizeReportType = new QuizReportType();
				quizeReportType.setStudentId(Integer.valueOf(studentUserId));
				quizeReportType.addLstquizTypes(getQuizeTypeLst(studentActity));
				quizeReportType.addListQuizeResultType(getQuizeResultType(studentActity));
				lstquizReportType.addQuizReportType(quizeReportType);
			}
			ut.commit();
			return lstquizReportType;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
