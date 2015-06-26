package com.scholastic.intl.primedigital.api.v1.resources;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.scholastic.primedigital.data.model.User;



public class UserLoginService {
	
	
	@Inject
	EntityManager entityManager;
	
	
	public User findUser(String userName) {
		TypedQuery<User> query = entityManager.createNamedQuery(User.QUERY_FIND_USER, User.class);
		query.setParameter("userName", userName);
		User user = query.getSingleResult();	
		return user;
		
	}

	
}
