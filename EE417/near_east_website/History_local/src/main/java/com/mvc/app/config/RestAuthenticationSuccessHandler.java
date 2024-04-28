package com.mvc.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.mvc.app.entity.UserEntity;
import com.mvc.app.model.UserModel;
import com.mvc.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private final ObjectMapper objectMapper;
	
	public RestAuthenticationSuccessHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
    	UserEntity user = userService.findByLogin(authentication.getName());
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(user));
        response.setStatus(HttpServletResponse.SC_OK);
        writer.flush();
        writer.close();
       
    }

}
