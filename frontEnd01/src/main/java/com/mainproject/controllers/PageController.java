package com.mainproject.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mainproject.backend01.daos.UserDAO;
import com.mainproject.backend01.models.User;


@Controller
public class PageController {

	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	UserDAO userdao;

	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getHomePage(){
		
		Principal principal=request.getUserPrincipal();
		
		if(principal!=null){
			String userEmail=principal.getName();
			User user=userdao.userGetByEmail(userEmail);
			session.setAttribute("username", user.getFirstName());
		}
		
		
		return "index";
	}
	
	
	@RequestMapping(value="admin/operations",method=RequestMethod.GET)
	public String getProductOperations(){
		
		return "PageOperations";	
	
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String getLoginPage(){
		System.out.println("I m login page");
		return "login";
		
	
	}
	
	@RequestMapping(value="access-denied",method=RequestMethod.GET)
	public String getErrorPage(){
		
		return"Error_Page";
		
		
	}
	
}
