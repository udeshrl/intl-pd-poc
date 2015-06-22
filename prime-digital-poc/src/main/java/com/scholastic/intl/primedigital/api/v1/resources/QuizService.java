package com.scholastic.intl.primedigital.api.v1.resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.scholastic.intl.api.primedigital.constants.PrimeDigitalConstants;
import com.scholastic.primedigital.data.model.StudentQuizActivity;
import com.scholastic.primedigital.data.model.User;

@Named
public class QuizService {
	
	@Inject
	EntityManager entityManager;
	public void getStudentData(){
		System.out.println("getStudentData");	
		User user = entityManager.find( User.class, 1);
		if(user != null){
			System.out.println("***************************************"+user.getFirst_name());
		}
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
