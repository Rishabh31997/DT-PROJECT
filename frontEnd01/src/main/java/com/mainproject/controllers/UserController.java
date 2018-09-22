package com.mainproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mainproject.backend01.daos.UserDAO;
import com.mainproject.backend01.models.Product;
import com.mainproject.backend01.models.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userdao;
	
	
	@RequestMapping(value="signIn",method=RequestMethod.GET)
	public String addUser(ModelMap map){
		map.addAttribute("userForm",new User());
		return "SignInForm";
		
	}
	
	@RequestMapping(value="submitUser")
	public String submitUser(@ModelAttribute("userForm") User user,ModelMap map){
		

		
		user.setEnabled(true);
		user.setRole("user");
		
		boolean user1=userdao.addUser(user);
		if(user1==true){
			map.addAttribute("msg", "User Added SuccessFully");
			return "redirect:home";
			
		}
		else{
			map.addAttribute("msg", "User Not Added Succesfully....Try Again");
			return"SignInForm";
		}
		
		
	}
	
}
