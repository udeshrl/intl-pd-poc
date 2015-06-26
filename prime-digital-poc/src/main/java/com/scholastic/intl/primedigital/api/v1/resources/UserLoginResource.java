package com.scholastic.intl.primedigital.api.v1.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.scholastic.intl.primedigital.api.v1.vo.UserVo;
import com.scholastic.primedigital.data.model.User;

@Path("/userLogin")
public class UserLoginResource {
	
	@Inject
	UserLoginService userLoginService;

	@POST
	@Path("/userAuthentication")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  UserVo userAuthentication (UserVo userVo) {
		UserVo usrVo = new UserVo();	
		try {
			User user = userLoginService.findUser(usrVo.getUserName());
			if (user != null) {
				usrVo.setUserName(user.getUserName());
				//usrVo.setPassword(user.getPassword());
				usrVo.setFristName(user.getFirst_name());
				usrVo.setLastName(user.getLast_name());
				usrVo.setEmail(user.getEmail());
				usrVo.setRole(user.getRole());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usrVo;
	}
	

}
