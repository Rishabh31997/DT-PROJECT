package com.mainproject.backend01;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mainproject.backend01.daos.UserDAO;
import com.mainproject.backend01.daos.UserDAOimpl;
import com.mainproject.backend01.models.Address;
import com.mainproject.backend01.models.User;



public class UserTestCase {

	
	static UserDAO userDaoObj;
	
	@BeforeClass
	public static void init(){
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.mainproject.backend01");
		context.refresh();
		userDaoObj=context.getBean("userDAOimpl",UserDAO.class);

	}

	@Test
	@Ignore
	public void Adduser(){

	Address addr=new Address();
	addr.setCity("delhi");
	addr.setLocality("preet vihar");
	addr.setHouseNumber(123);
	addr.setBilling(true);
	addr.setPincode(110092);
	addr.setState("Delhi");
	
		
	Address addr2=new Address();
	addr2.setCity("delhi");
	addr2.setLocality("nirman vihar");
	addr2.setHouseNumber(456);
	addr2.setBilling(true);
	addr2.setPincode(110092);
	addr2.setState("Delhi");
		
	User user=new User();
	user.setFirstName("Rishabh");
	user.setLastName("Jain");
	user.setContactNumber(9910192734l);
	user.setPassword("rishabh3");
	user.setConfirmPassword("rishabh3");
	user.setEmail("rj72251@gmail.com");
	user.setEnabled(true);
	user.setRole("admin");
	
	user.getAddress().add(addr);
	user.getAddress().add(addr2);
	
	addr.setUser(user);
	addr2.setUser(user);
	
	User user1=new User();
	user1.setFirstName("Amarjeet");
	user1.setLastName("Singh");
	user1.setContactNumber(123456789);
	user1.setPassword("amar@123");
	user1.setConfirmPassword("amar@123");
	user1.setEmail("aj1998@gmail.com");
	user1.setEnabled(true);
	user1.setRole("user");
	
	User user2=new User();
	user2.setFirstName("sakshi");
	user2.setLastName("Rajput");
	user2.setContactNumber(598764310);
	user2.setPassword("shaktiman");
	user2.setConfirmPassword("shaktiman");
	user2.setEmail("shak@gmail.com");
	user2.setEnabled(true);
	user2.setRole("user");
	

	
	assertTrue("User Not Added Succesfully",userDaoObj.addUser(user));
	assertTrue("User Not Added Succesfully",userDaoObj.addUser(user1));
	assertTrue("User Not Added Succesfully",userDaoObj.addUser(user2));
	}
	
	@Test
	@Ignore
	public void getUserByIdTest(){
		
		User user=userDaoObj.userGetUserById(1);
	
		System.out.println(user.getFirstName()+" "+user.getLastName());
		
		
		assertNull("User Not Found",user);
		
	}
	
	@Test
	public void viewAll(){
		
		List<User> users=userDaoObj.userAll();
		
		for(User s:users){
		
			System.out.println(s.getFirstName()+""+s.getLastName()+""+s.getRole());
		}
		
		
		
	}

	

}
