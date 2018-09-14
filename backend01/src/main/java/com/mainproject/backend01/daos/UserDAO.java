package com.mainproject.backend01.daos;

import java.util.*;

import com.mainproject.backend01.models.Address;
import com.mainproject.backend01.models.User;

public interface UserDAO {

	public User userGetByEmail(String email);
	public User userGetUserById(int id);
	public  boolean addUser(User user);
	public  Address getAddress(int addId);
	public  boolean updateAddress(Address addr);
	public  Set<Address> address (int addId);
	public List<User> userAll();
	
	

}
