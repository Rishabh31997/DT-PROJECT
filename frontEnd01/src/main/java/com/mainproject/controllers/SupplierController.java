package com.mainproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mainproject.backend01.daos.CategoryDAO;
import com.mainproject.backend01.daos.ProductDAO;
import com.mainproject.backend01.daos.ProductDAOimpl;
import com.mainproject.backend01.daos.SupplierDAO;
import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Product;
import com.mainproject.backend01.models.Supplier;



@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO suppObj;
	
	Product product=new Product();
	
	
	
	@RequestMapping(value="admin/supplieropp",method=RequestMethod.GET)
	public String getProductPage(){
		return "SupplierOpp";
	}
	
	/*
	@RequestMapping(value="addcategory",method=RequestMethod.GET)
	public String (ModelMap map){
		return "AddCategory";
		}*/	
	
	@RequestMapping(value="admin/addsupplier",method=RequestMethod.GET)
	public String AddProduct(ModelMap map){
		
		return"AddSupplier";
			
	}


	@RequestMapping(value="admin/submitsupplier",method=RequestMethod.POST)
	public String SubmitAddProduct(@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddress")String supplierAddress,ModelMap map){

		Supplier supp=new Supplier();
		supp.setSupplierName(supplierName);
		supp.setSupplierAddress(supplierAddress);
		supp.setIs_active("Active");
		
		System.out.println("Supplier Added Succefully");
		
		boolean supp1=suppObj.addSupplier(supp);
		if(supp1==true){
			return "Sucess";
		}
		else{
			return"Failure";
		}
		
		
	
	}
	
	@RequestMapping(value="admin/viewAllSupplier",method=RequestMethod.GET)
	public String listSuppliers(ModelMap map){
		List<Supplier> suppliers=suppObj.supplier(); 
		map.addAttribute("suppList", suppliers);
		return "ViewAllSuppliers";
	}

	
	/*@RequestMapping(value="deletecategory/{categoryId}",method=RequestMethod.GET)
	public String SubmitdeleteProduct(@PathVariable("categoryId")int catId,ModelMap map){
	
		System.out.println("CATEGORY ID ------>"+catId);
		
		Category rishabh=catObj.getCategory(catId);
		rishabh.setCategory_isactive("NOT ACTIVE");
		boolean r=catObj.updateCategory(rishabh);
		
		
		List<Category> categories=catObj.category(); 
		map.addAttribute("catList", categories);
		
		
		if(r==true){
			map.addAttribute("msg","Category Deleted Succesfully");
			return "ViewAllCategories";
		}
		else{
			map.addAttribute("msg","Category Not Deleted Succesfully");
			return "Failure";
		}	
		  }*/
		


	
	}
			
	
	
	


	











