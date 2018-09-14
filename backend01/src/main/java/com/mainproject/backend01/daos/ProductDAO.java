package com.mainproject.backend01.daos;

import java.util.List;
import java.util.Set;





import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Product;

public interface ProductDAO {
	

	public boolean addProduct(Product pro);
	public boolean updateProduct(Product pro);
	public void deleteProduct(int productId);
	public Product getProduct(int productId);
	public List<Product> listProducts();
	public Product getProByCat(int categoryId);
}
