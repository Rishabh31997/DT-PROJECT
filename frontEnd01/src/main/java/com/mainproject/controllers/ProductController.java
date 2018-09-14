package com.mainproject.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mainproject.backend01.daos.CategoryDAO;
import com.mainproject.backend01.daos.ProductDAO;
import com.mainproject.backend01.daos.ProductDAOimpl;
import com.mainproject.backend01.daos.SupplierDAO;
import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Product;
import com.mainproject.backend01.models.Supplier;



@Controller
public class ProductController {

	@Autowired
	ProductDAO pro;
	
	@Autowired
	CategoryDAO cat;
	
	@Autowired
	SupplierDAO supp;
	
	
	Product product=new Product();
	
	
	@RequestMapping(value="admin/productpage",method=RequestMethod.GET)
	public String getProductPage(){
		return "ProductOpp";
	}
	
	
	
	
	@RequestMapping(value="admin/addupdateproduct",method=RequestMethod.GET)
	public String AddProduct(ModelMap map){
		map.addAttribute("proForm",new Product());
		
		List<Category> category=cat.category();
		List<Supplier> supplier=supp.supplier();
		
		map.addAttribute("categoryList", category);
		map.addAttribute("supplierList", supplier);
		
		return"ProductForm";
			
	}


	/*@RequestMapping(value="submitproduct",method=RequestMethod.POST)
	public String SubmitAddProduct(@ModelAttribute("proForm")Product proForm,ModelMap map){

		map.addAttribute("proObj",proForm);
		proForm.setIs_active("ACTIVE");
		
		boolean pro1=pro.addProduct(proForm);
		if(pro1==true){
			return "Sucess";
		}
		else{
			return"Failure";
		}
	
	}
*/	
	@RequestMapping(value="admin/viewAllProducts",method=RequestMethod.GET)
	public String listProducts(ModelMap map){
		List<Product> pros=pro.listProducts(); 
		map.addAttribute("productList", pros);
		return "ViewALL";
	}

	/*@RequestMapping(value="deleteproduct",method=RequestMethod.GET)
	public String deleteProduct(ModelMap map){
		return "delete";
		}*/
		
	
	@RequestMapping(value="admin/deleteproduct/{productId}",method=RequestMethod.GET)
	public String SubmitdeleteProduct(@PathVariable("productId")int pId,ModelMap map){
	
		System.out.println("PRODUCT ID ------>"+pId);
		//pro.deleteProduct(proId);
		Product rishabh=pro.getProduct(pId);
		rishabh.setIs_active("NOT ACTIVE");
		
		boolean r=pro.updateProduct(rishabh);
		
		List<Product> pros=pro.listProducts(); 
		map.addAttribute("productList", pros);
				
		if(r==true){
		
			map.addAttribute("msg","Product Deleted Succesfully");
			return "ViewALL";
		}
		else{
			
			map.addAttribute("msg","Product Not Deleted ");
			return "Failure";
		}	
		  }
		
/*
	@RequestMapping(value="updateProduct",method=RequestMethod.GET)
	public String updateProduct(ModelMap map){
		map.addAttribute("updateProduct",new Product());
		return"update";
		
		}*/

	@RequestMapping(value="admin/submitproduct",method=RequestMethod.POST)
	public String SubmitUpdateProduct(HttpServletRequest request,ModelMap map,
										@RequestParam("file")MultipartFile file ){

	Product p=new Product();
	p.setProductName(request.getParameter("productName"));
	p.setPrice(Float.parseFloat(request.getParameter("price")));
	p.setDescription(request.getParameter("description"));
	p.setQuantity (Integer.parseInt(request.getParameter("quantity")));
	
	Category catObj=cat.getCategory(Integer.parseInt(request.getParameter("category")));
	
	p.setCategory(catObj);
	p.setIs_active("Active");
	
	p.setSupplier(supp.getSupplier(Integer.parseInt(request.getParameter("supplier"))));
	
	String filePath=request.getSession().getServletContext().getRealPath("/");
	String fileName=file.getOriginalFilename();

	p.setImgName(fileName);
	

	boolean r=pro.addProduct(p);
	
	try{
		
	byte[] imageBytes=file.getBytes();
	BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filePath+"/resources/images/"+fileName));
	bos.write(imageBytes);
	bos.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	
	if(true){
		System.out.println("product added sucessfully");
		return"index";
	}
	else{
		System.out.println("Product not added sucessfully");
		return"ProductForm";
	}
	
	
	}
			
		}
	
	


	











