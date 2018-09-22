package com.mainproject.backend01.daos;

import com.mainproject.backend01.models.Cart;

public interface CartDAO {
	
	boolean addCart(Cart cart);
	Cart getCartByCustomer(String customerId);
	boolean deleteCart(int cartId);

}
