package com.scholastic.intl.primedigital.api.v1;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.scholastic.intl.primedigital.api.v1.resources.QuizResource;
import com.scholastic.intl.primedigital.api.v1.resources.TeacherResource;
import com.scholastic.intl.primedigital.api.v1.resources.UserLoginResource;

@ApplicationPath("/api/v1")
public class V1Application extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(QuizResource.class);
		classes.add(TeacherResource.class);
		classes.add(UserLoginResource.class);
		return classes;
	}
}
