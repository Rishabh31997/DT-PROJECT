package com.mainproject.backend01;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mainproject.backend01.daos.CategoryDAO;
import com.mainproject.backend01.daos.ProductDAO;
import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Product;
import com.mainproject.backend01.models.Supplier;

public class ProductTestCase {

	static CategoryDAO categoryObj;
	static ProductDAO proObj;
	
	
	@BeforeClass
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.mainproject.backend01");
		app.refresh();
		categoryObj=app.getBean("categoryDAOimpl",CategoryDAO.class);
		proObj=app.getBean("productDAOimpl",ProductDAO.class);
	}
	
	@Test
	
	public void addProduct(){
		Product pro=new Product();
		pro.setProductName("H&M shirt");
		pro.setDescription("Mens Black Shirt");
		pro.setPrice(1500);
		pro.setQuantity(25);
		

		Product pro1=new Product();
		pro1.setProductName("Denim Jeans");
		pro1.setDescription("U.S POLO DENIME BLACK JEANS");
		pro1.setPrice(1250);
		pro1.setQuantity(100);
		

		Product pro2=new Product();
		pro2.setProductName("White Blazer");
		pro2.setDescription("BlackBerry Mens Casual Blazer");
		pro2.setPrice(4999);
		pro2.setQuantity(60);
		
		Category cat=categoryObj.getCategory(17);
		
		pro.setCat(cat);
		pro1.setCat(cat);
		pro2.setCat(cat);
		
		assertTrue("Category Added Succesfully",proObj.addProduct(pro));
		assertTrue("Category Added Succesfully",proObj.addProduct(pro1));
		assertTrue("Category Added Succesfully",proObj.addProduct(pro2));
		
		
	}
	
	@Test
	@Ignore
	public void updateProductbyId(){
		 
		Product pro3=proObj.getProduct(7);
		
		pro3.setProductName("television");
		pro3.setDescription("Electronics");
		pro3.setPrice(15000);
		pro3.setQuantity(1500);
		
		Category cat=new Category();
		cat.setCategoryName("Electronics");
		cat.setCategoryDesc("HomeAppliances");
		
		Supplier supp=new Supplier();
		supp.setSupplierName("mohanji Electronics");
		supp.setSupplierAddress("jagatpuri");
		
		supp.getProduct().add(pro3);
		
		cat.getProduct().add(pro3);
		
		pro3.setCat(cat);
		pro3.setSupp(supp);
		
		assertTrue("Product Updated Succesfully",proObj.updateProduct(pro3));
		
		}
	
		@Test
		
		public void deleteProductById(){
			
			proObj.deleteProduct(1);
			
			Product product=proObj.getProduct(1);
			 
			assertNull("Product deleted", product);
			
			
		}
	
		@Test
		@Ignore
		public void getProductsList(){
			
		
			List<Product> pro=proObj.listProducts();
				
					
			for (Product s :pro){ 
				System.out.println(s.getProductId()+" "+s.getProductName());	
			}
			
			
				
			}
		
	}
	

