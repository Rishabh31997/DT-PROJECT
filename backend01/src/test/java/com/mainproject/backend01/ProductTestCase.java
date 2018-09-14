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
	private Category cat;
	
	@BeforeClass
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.mainproject.backend01");
		app.refresh();
		categoryObj=app.getBean("categoryDAOimpl",CategoryDAO.class);
		proObj=app.getBean("productDAOimpl",ProductDAO.class);
	}
	
	@Test
	@Ignore
	public void addProduct(){
		Product pro=new Product();
		pro.setProductName("SurfExcel");
		pro.setDescription("Dag ache hai");
		pro.setPrice(150);
		pro.setQuantity(10000);
		

		Product pro1=new Product();
		pro1.setProductName("Nirma");
		pro1.setDescription("Doodh si saffedi Nirma se ayye rangin kapda bhi khil khil jaye");
		pro1.setPrice(125);
		pro1.setQuantity(10000);
		

		Product pro2=new Product();
		pro2.setProductName("Colgate");
		pro2.setDescription("Kya apke toothpaste mein namak hain");
		pro2.setPrice(150);
		pro2.setQuantity(10000);
		
		pro1.setCat(cat);
			
		assertTrue("Category Added Succesfully",proObj.addProduct(pro));
		assertTrue("Category Added Succesfully",proObj.addProduct(pro));
		assertTrue("Category Added Succesfully",proObj.addProduct(pro));
		
		
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
	

