package com.mainproject.controllers;

import java.security.Principal;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value={"/","home"},method=RequestMethod.GET)
	public String getHomePage(){
		
		Principal principal=request.getUserPrincipal();
		System.out.println("I m Principal "+principal);
		
		if(principal!=null){
			String userEmail=principal.getName();
			System.out.println("User Email : "+userEmail);
			User user=userdao.userGetByEmail(userEmail);
			session.setAttribute("username", user.getFirstName()+" "+user.getLastName());
		}
		
		
		return "index";
	}
	
	
	@RequestMapping(value="admin/operations",method=RequestMethod.GET)
	public String getProductOperations(){
		System.out.println("I m here");
		return "PageOperations";	
	
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(name="logout",required=false)String logout){
		System.out.println("I m login page");
		ModelAndView mv=new ModelAndView("login");
		
		if(logout!=null){
			
			mv.addObject("message","logged out !!!");
		}
		
		return mv;
		
	
	}
	
	@RequestMapping(value="access-denied",method=RequestMethod.GET)
	public String getErrorPage(){
		
		return"Error_Page";

	}
	

	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String getLogout(HttpServletRequest request,HttpServletResponse response){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			
			new SecurityContextLogoutHandler().logout(request,response,auth);
			
		}
		return"redirect:/login?logout";

	}
	
	
	
}
