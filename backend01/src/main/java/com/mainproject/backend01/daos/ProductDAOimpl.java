package com.mainproject.backend01.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
public class ProductDAOimpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addProduct(Product pro) {
		
		try {
			System.out.println("Session Factory = "+sessionFactory);
			Session session =sessionFactory.getCurrentSession();
			session.save(pro);
			System.out.println("Category Added successfully");
			return true;
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateProduct(Product pro) {
		try {
			
			Session session =sessionFactory.getCurrentSession();
			session.update(pro);
			System.out.println("Product Updated successfully");
			return true;
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public void deleteProduct(int productId){
		Session session=sessionFactory.getCurrentSession();
		Product pro=(Product)session.get(Product.class, productId);
		if(pro!=null){
			System.out.println("Record deleted");
			session.delete(pro);
			
		}
		else{
			System.out.println("Record not found");
		
		}
	}

	@Override
	public List<Product> listProducts() {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Product.class);
		c.add(Restrictions.eq("is_active", "Active"));
		List<Product> pros=c.list();
		return pros;
	}

	@Override
	public Product getProduct(int productId) {
		Session session=sessionFactory.getCurrentSession();
		Product pro=(Product)session.get(Product.class,productId);
		return pro;
		
	}

	@Override
	public Product getProByCat(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		Product pro3=(Product)session.get(Category.class, categoryId);
		return pro3;
		
	}

	


}
