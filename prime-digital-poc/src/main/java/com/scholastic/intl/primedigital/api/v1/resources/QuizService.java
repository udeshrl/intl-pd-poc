package com.scholastic.intl.primedigital.api.v1.resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;

import com.scholastic.intl.api.primedigital.constants.PrimeDigitalConstants;
import com.scholastic.primedigital.data.model.PDClass;
import com.scholastic.primedigital.data.model.QuizeQuestion;
import com.scholastic.primedigital.data.model.StudentQuizActivity;

@Named
public class QuizService {
	
	@Inject
	EntityManager entityManager;
	
	

	public List<PDClass> getTeacherClass(Integer teacherId) {
		
		TypedQuery<PDClass> query = entityManager.createNamedQuery(PDClass.QUERY_ALL, PDClass.class);
		query.setParameter("teacherId", teacherId);
		List<PDClass> teacherClasses = query.getResultList();
		return teacherClasses;
		
	}
	
	
	public List<StudentQuizActivity> getStudentQuizActitiy(Integer studentId)  {
		try{
			TypedQuery<StudentQuizActivity> query = entityManager.createNamedQuery(StudentQuizActivity.QUERY_ALL,
					StudentQuizActivity.class);
			query.setParameter("studentId", studentId);
			List<StudentQuizActivity> activities = query.getResultList();
			return activities;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	public List<StudentQuizActivity> getStudentCompletedQuizActivity(Integer studentId)  {
		try{
			TypedQuery<StudentQuizActivity> query = entityManager.createNamedQuery(StudentQuizActivity.QUERY_COMPLETED_ACTIVITY,
					StudentQuizActivity.class);
			query.setParameter("studentId", studentId);
			query.setParameter("status", PrimeDigitalConstants.COMPLETED_QUIZ_ACTIVITY);
			List<StudentQuizActivity> activities = query.getResultList();
			for (StudentQuizActivity question : activities) {
				for (QuizeQuestion quest: question.getQuize().getQuestions()) {
					Hibernate.initialize(quest.getBookQuestion());
					Hibernate.initialize(quest.getChapterQuestion());
					Hibernate.initialize(quest.getConceptQuestion());
					Hibernate.initialize(quest.getTopicQuestion());
				}
				
			}
			return activities;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	
	}
	
	

	
	
	public StudentQuizActivity findStudentQuizActitiy(Integer studentId, Integer quizeId) {
		
		TypedQuery<StudentQuizActivity> query = entityManager.createNamedQuery(StudentQuizActivity.QUERY_FIND_ACTIVITY,
				StudentQuizActivity.class);
		query.setParameter("studentId", studentId);
		query.setParameter("quizeId", quizeId);
		
		return query.getSingleResult();
	}

}
