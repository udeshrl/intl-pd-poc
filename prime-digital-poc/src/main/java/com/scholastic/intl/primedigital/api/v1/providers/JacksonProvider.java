package com.scholastic.intl.primedigital.api.v1.providers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@Consumes({ MediaType.APPLICATION_JSON, "text/json" })
@Produces({ MediaType.APPLICATION_JSON, "text/json" })
public class JacksonProvider extends ResteasyJacksonProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(JacksonProvider.class);
	
	@Context
	private HttpServletRequest request;

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	public JacksonProvider() {
		super();
		LOGGER.info("loading jackson configurator provider");
		JacksonObjectMapper mapper = JacksonObjectMapper.get();
		setMapper(mapper);
	}
}
