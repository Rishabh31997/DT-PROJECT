package com.mainproject.backend01.daos;

import java.util.List;





import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainproject.backend01.models.Cart;



@Repository
@Transactional
public class CartDAOimpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	@Override
	public boolean addCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		try{
			//System.out.println(cart.getCustomerId()+" "+cart.getUser().getEmail());
			session.save(cart);
			System.out.println("Cart Object saved");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Cart getCartByCustomer(String customerId) {
		Session session=sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("From Cart  where customerId = :CI");
			query.setParameter("CI", customerId);
			List<Cart> cartList = query.list();
			if(cartList.isEmpty()){
				return null;
			}
			else {
			return cartList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public boolean deleteCart(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		Cart cObj=(Cart)session.get(Cart.class, cartId);
		try{
		session.delete(cObj);
		return true;
		}
		catch(Exception e){
		e.printStackTrace();
		return false;
		}
	}
}

