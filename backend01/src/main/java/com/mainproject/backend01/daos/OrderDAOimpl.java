package com.mainproject.backend01.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainproject.backend01.models.Order;

@Repository
@Transactional
public class OrderDAOimpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session
	getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int makeOrder(Order order) {
		return (int) getSession().save(order);
		
	}

}
