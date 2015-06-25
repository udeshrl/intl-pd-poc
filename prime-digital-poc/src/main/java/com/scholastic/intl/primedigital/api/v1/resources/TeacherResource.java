package com.scholastic.intl.primedigital.api.v1.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.scholastic.intl.primedigital.api.v1.representations.ClassType;
import com.scholastic.intl.primedigital.api.v1.representations.ListCalssType;
import com.scholastic.intl.primedigital.api.v1.representations.UserType;
import com.scholastic.primedigital.data.model.PDClass;
import com.scholastic.primedigital.data.model.User;

@Path("/teacher")
public class TeacherResource {

	@Inject
	TeacherService teacherService;

	@GET
	@Path("/getteacherClasses/{teacherId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListCalssType getTeacherClassesData(@PathParam("teacherId") Integer teacherId) {
			ListCalssType listClassType = new ListCalssType();
			List<PDClass> tearcherclass = teacherService.getTeacherClass(teacherId);
			for (PDClass classes : tearcherclass) {
				ClassType classType = new ClassType();
				classType.setId(classes.getId());
				classType.setName(classes.getClassName());
				for (User studentUser : classes.getStudentUser()) {
					UserType userType = new UserType();
					userType.setId(studentUser.getId());
					userType.setFirst_name(studentUser.getFirst_name());
					userType.setLast_name(studentUser.getLast_name());
					userType.setRole(studentUser.getRole());
					classType.addUserType(userType);
				}
				listClassType.addClassType(classType);
			}
			return listClassType;
		}

}
