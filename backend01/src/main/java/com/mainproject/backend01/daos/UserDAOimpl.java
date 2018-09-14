package com.mainproject.backend01.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainproject.backend01.models.Address;
import com.mainproject.backend01.models.User;

@Repository
@Transactional
public class UserDAOimpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User userGetByEmail(String email) {
		Session session=sessionFactory.getCurrentSession();
		User bymail= (User)session.get(User.class, email);
		return bymail;
	}

	@Override
	public User userGetUserById(int id) {
		try{
		Session session=sessionFactory.getCurrentSession();
		User byid= (User) session.get(User.class, id);
		System.out.println(byid);
		return byid;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean addUser(User user) {
		try{
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		System.out.println("User Added..");
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Address getAddress(int addId) {
		Session session=sessionFactory.getCurrentSession();
		Address byadd= (Address)session.get(User.class, addId);
		return byadd;

	}

	@Override
	public boolean updateAddress(Address addr) {
		try{
		Session session=sessionFactory.getCurrentSession();
		session.update(addr);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Set<Address> address(int addId) {
		return null;
	}

	@Override
	public List<User> userAll() {

		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(User.class);
		List<User> users=c.list();
		return users;
	}

}
