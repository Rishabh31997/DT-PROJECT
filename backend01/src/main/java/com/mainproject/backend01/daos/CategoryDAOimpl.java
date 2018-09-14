package com.mainproject.backend01.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Product;

@Repository
@Transactional
public class CategoryDAOimpl implements CategoryDAO{

	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category cat) {
		
		try {
			Session session=sessionFactory.getCurrentSession();
			session.persist(cat);
			System.out.println("Category added");
			return true;
			
		} catch (Exception e) {
			System.out.println("Category not added");
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category cat) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(cat);
			return true;
			
		} catch (Exception e) {
			return false;
			
		}	
		
	}

	@Override
	public void deletecategory(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		Category cat=(Category)session.get(Category.class, categoryId);
		if(cat==null){
			System.out.println("Record not found");
		}
		else{
			session.delete(categoryId);
			
		}
	}
	

	@Override
	public List<Category> category() {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Category.class);
		c.add(Restrictions.eq("category_isactive", "Active"));
		List<Category> catList=c.list();
		System.out.println("List = "+catList);
		return  catList;
	}

	@Override
	public Category getCategory(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		Category cat=(Category)session.get(Category.class,categoryId);
		return cat;
	}


	
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


