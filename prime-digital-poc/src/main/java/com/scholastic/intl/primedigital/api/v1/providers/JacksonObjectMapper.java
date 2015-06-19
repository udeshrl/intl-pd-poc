package com.scholastic.intl.primedigital.api.v1.providers;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;


/**
 * @author dora.babu
 *
 */
public class JacksonObjectMapper extends ObjectMapper {

	public static JacksonObjectMapper get() {

		JacksonObjectMapper mapper = new JacksonObjectMapper();

		mapper.setSerializer(new CustomSerializerFactory()).includeDefaults(false);

		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		JacksonAnnotationIntrospector jacksonAnnotationIntrospector = new JacksonAnnotationIntrospector();
		mapper.setDeserializationConfig(
				mapper.getDeserializationConfig().withAnnotationIntrospector(jacksonAnnotationIntrospector));
		mapper.setSerializationConfig(
				mapper.getSerializationConfig().withAnnotationIntrospector(jacksonAnnotationIntrospector));

		return mapper;
	}


	protected JacksonObjectMapper setSerializer(CustomSerializerFactory ser) {
		setSerializerFactory(ser);
		return this;
	}

	protected JacksonObjectMapper includeDefaults(boolean include) {
		getSerializationConfig().setSerializationInclusion(
				include ? JsonSerialize.Inclusion.ALWAYS : JsonSerialize.Inclusion.NON_DEFAULT);
		return this;
	}

}
