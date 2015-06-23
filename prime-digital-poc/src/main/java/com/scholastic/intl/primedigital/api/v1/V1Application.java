package com.scholastic.intl.primedigital.api.v1;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.scholastic.intl.primedigital.api.v1.providers.JacksonProvider;
import com.scholastic.intl.primedigital.api.v1.resources.QuizResource;
import com.scholastic.intl.primedigital.api.v1.resources.TeacherResource;


/**
 * @author dora.babu
 *
 */
@ApplicationPath("/api/v1")
public class V1Application extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(QuizResource.class);
		classes.add(TeacherResource.class);
		
		// Providers
		//classes.add(JacksonProvider.class);
		return classes;
	}
}
