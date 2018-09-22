package com.mainproject.backend01.daos;

import java.util.List;

import com.mainproject.backend01.models.Items;

public interface ItemsDAO {

	boolean addItem(Items item);
	boolean updateItem(Items item);
	Items getItemByProductIdAndCustomerId(int productId,String customerId);
	List<Items> getItemsListByCart(int cartId);
	boolean increaseQuantity(int itemId);
	boolean decreaseQuantity(int itemId);
	boolean deleteItem(int itemId);
}
