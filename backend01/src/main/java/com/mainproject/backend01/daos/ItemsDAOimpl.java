package com.mainproject.backend01.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainproject.backend01.models.Items;

@Repository
@Transactional
public class ItemsDAOimpl implements ItemsDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addItem(Items item) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.persist(item);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItem(Items item) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.update(item);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Items getItemByProductIdAndCustomerId(int productId,
			String customerId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery
			("from com.mainproject.backend01.models.Items where product.productId=:pid and customerId=:cId");
			query.setParameter("pid",productId);
			query.setParameter("cId","customerId");
			List<Items> items=query.list();
			return items.get(0);
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public List<Items> getItemsListByCart(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		try{
			
			Query query = session.createQuery("From com.mainproject.backend01.models.Items where cart.cartId = :cartId");
			query.setParameter("cartId", cartId);
			List<Items> results = (List<Items>)query.list();
			return results;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean increaseQuantity(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Items item = (Items)session.get(Items.class, itemId);
			item.setQuantity(item.getQuantity()+1);
			session.update(item);
			return true;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean decreaseQuantity(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Items item = (Items)session.get(Items.class, itemId);
			item.setQuantity(item.getQuantity()-1);
			session.update(item);
			return true;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItem(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Items item = (Items)session.get(Items.class, itemId);
			
			session.delete(item);
			return true;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

}
