package com.scholastic.intl.primedigital.api.v1.resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.scholastic.primedigital.data.model.PDClass;

@Named
public class TeacherService {
	
	@Inject
	EntityManager entityManager;
	
	public List<PDClass> getTeacherClass(Integer teacherId) {
			
			TypedQuery<PDClass> query = entityManager.createNamedQuery(PDClass.QUERY_ALL, PDClass.class);
			query.setParameter("teacherId", teacherId);
			List<PDClass> teacherClasses = query.getResultList();
			return teacherClasses;
			
		}
	
	

}
