package com.scholastic.intl.primedigital.api.v1.resources;


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

import com.scholastic.intl.primedigital.api.v1.representations.ListQuizeType;
import com.scholastic.intl.primedigital.api.v1.representations.ListUserType;
import com.scholastic.intl.primedigital.api.v1.representations.QuizQuestionsType;
import com.scholastic.intl.primedigital.api.v1.representations.QuizType;
import com.scholastic.intl.primedigital.api.v1.representations.UserType;
import com.scholastic.intl.primedigital.api.v1.vo.ResponseVo;
import com.scholastic.intl.primedigital.api.v1.vo.StudentQuizeResultVo;
import com.scholastic.primedigital.data.model.StudentQuizActivity;
import com.scholastic.primedigital.data.model.StudentQuizActivityQuestions;


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
	@Path("/student")
	@Produces(MediaType.APPLICATION_JSON)
	public ListUserType getQuizzes() {
		ListUserType listUserType = new ListUserType();
		UserType userType = new UserType();
		userType.setFirst_name("dorababu");
		userType.setLast_name("gedde");
		userType.setId(100);
		userType.setRole("student");
		
		UserType userType1 = new UserType();
		userType1.setFirst_name("srinu");
		userType1.setLast_name("murthy");
		userType1.setId(200);
		userType1.setRole("student");
		listUserType.addUserType(userType);
		listUserType.addUserType(userType1);
		
		
		quizService.getStudentData();
		return listUserType;
		
	}
	
	@GET
	@Path("/getquizeData/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListQuizeType getQuizzesData(@PathParam("studentId")Integer studentId) {

		ListQuizeType listquizetype = new ListQuizeType();
		List<StudentQuizActivity> studentActity = quizService.getStudentQuizActitiy(studentId);
		for (StudentQuizActivity activity : studentActity) {
				QuizType quizType = new QuizType();
				quizType.setQuizId(activity.getId());
				quizType.setQuizName(activity.getQuize().getName());
				for (StudentQuizActivityQuestions question : activity.getQuestion() ) {
						QuizQuestionsType questionsType = new QuizQuestionsType();
						questionsType.setQuestionId(question.getId());
						questionsType.setSequence(question.getSequence());
						questionsType.setFilePath(question.getQuizQuestions().getFilePath());
						questionsType.setJsonData(question.getQuizQuestions().getData());
						questionsType.setComponets(question.getQuizQuestions().getComponets());
						questionsType.setBookId(question.getQuizQuestions().getBookId());
						questionsType.setChapterId(question.getQuizQuestions().getChapterId());
						questionsType.setConceptId(question.getQuizQuestions().getConceptId());
						questionsType.setCategoreyId(question.getQuizQuestions().getCategoreyId());
						quizType.addquestionType(questionsType);
				}
				listquizetype.addQuizType(quizType);
		}
		
		
		
		return listquizetype;
		
	}
	
	@POST
	@Path("/putSubmitedQuizData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseVo saveQuiz(StudentQuizeResultVo studentQuizResultVo) {
		ResponseVo response = new ResponseVo();
		StudentQuizActivity studnetQuizActivity = 
				quizService.findStudentQuizActitiy(studentQuizResultVo.getStudentId(), studentQuizResultVo.getQuizId());
		
		if (studnetQuizActivity != null) {
			
			studnetQuizActivity.setResultArray(studentQuizResultVo.getResultArray());
			studnetQuizActivity.setAnswerArray(studentQuizResultVo.getAnswerArray());
			studnetQuizActivity.setResultQuestionObject(studentQuizResultVo.getResultQuestionObject());
			studnetQuizActivity.setTotalNumberQuestionIssued(studentQuizResultVo.getTotalQuestions());
			studnetQuizActivity.setNumQuestionAnsweredCorrect(studentQuizResultVo.getCorrectAnswers());
			studnetQuizActivity.setPercentage(studentQuizResultVo.getPercentage());
			try {
				ut.begin();
				em.merge(studnetQuizActivity);
				ut.commit();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			response.setMessage("SUCESSS");
			//studnetQuizActivity.setCorrectAnswers(studentQuizResultVo.getCorrectAnswers());
		} else {
			response.setMessage("FAILURE");
		}
		
		
		return response;
		
	}

}

