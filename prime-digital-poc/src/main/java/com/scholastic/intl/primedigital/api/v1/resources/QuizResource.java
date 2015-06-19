package com.scholastic.intl.primedigital.api.v1.resources;


import java.util.List;

import javax.inject.Inject;
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

		
		List<StudentQuizActivity> studentActity = quizService.getStudentQuizActitiy(1);
		for (StudentQuizActivity activity : studentActity) {
			System.out.println("QuizId"+activity.getQuize().getName());
			System.out.println("activity" +activity.getId());
			for (StudentQuizActivityQuestions activtiyQuestions : activity.getQuestion() ) {
					System.out.println("QuestionID "+activtiyQuestions.getQuizQuestions().getId());
					System.out.println("FilePath "+activtiyQuestions.getQuizQuestions().getFilePath());
					System.out.println("Data "+activtiyQuestions.getQuizQuestions().getData());
					System.out.println("Componets "+activtiyQuestions.getQuizQuestions().getComponets());
			}
		}
		
		ListQuizeType listquizetype1 = new ListQuizeType();
		QuizType quiztype1 = new QuizType();
		
		QuizQuestionsType questions1 = new QuizQuestionsType();
		questions1.setQuestionId(1);
		questions1.setFilePath("/srini.html");
		questions1.setJsonData("JSONDAT");
		questions1.setSequence(1);
		QuizQuestionsType questions2 = new QuizQuestionsType();
		questions2.setQuestionId(2);
		questions2.setFilePath("/srini1.html");
		questions2.setJsonData("JSONDAT2");
		questions2.setSequence(2);
		
		quiztype1.setQuizId(11);
		quiztype1.addquestionType(questions1);
		quiztype1.addquestionType(questions2);
		
		
		
		
		
		QuizType quiztype2 = new QuizType();
		
		QuizQuestionsType questions3 = new QuizQuestionsType();
		questions3.setQuestionId(111);
		questions3.setFilePath("/srini.html");
		questions3.setJsonData("JSONDAT");
		questions3.setSequence(12);
		QuizQuestionsType questions24= new QuizQuestionsType();
		questions24.setQuestionId(222);
		questions24.setFilePath("/srini1.html");
		questions24.setJsonData("JSONDAT2");
		questions24.setSequence(23);
		
		quiztype2.setQuizId(12);
		quiztype2.addquestionType(questions3);
		quiztype2.addquestionType(questions24);
		
		
		listquizetype1.addQuizType(quiztype1);
		listquizetype1.addQuizType(quiztype2);
		
		return listquizetype1;
		
	}
	
	@POST
	@Path("/putSubmitedQuizData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseVo saveQuiz(StudentQuizeResultVo studentQuizResultVo) {
		ResponseVo response = new ResponseVo();
		System.out.println("testID"+studentQuizResultVo.getActivityId());
		System.out.println("testID"+studentQuizResultVo.getQuizId());
		System.out.println("studentID"+studentQuizResultVo.getStudentId());
		System.out.println("ansArr"+studentQuizResultVo.getAnswerArray());
		System.out.println("resultArr"+studentQuizResultVo.getResultArray());
		System.out.println("resultQuestionObj"+studentQuizResultVo.getResultQuestionObject());
		System.out.println("totalQuestion"+studentQuizResultVo.getTotalQuestions());
		System.out.println("resultQuestionObj"+studentQuizResultVo.getResultQuestionObject());
		System.out.println("correctAns"+studentQuizResultVo.getCorrectAnswers());
		System.out.println("resultPercentage"+studentQuizResultVo.getPercentage());
		response.setMessage("SUCESSS");
		return response;
		
	}

}

