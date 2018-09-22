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
public class CategoryController {
	
	@Autowired
	CategoryDAO catObj;
	
	Product product=new Product();
	
	
	
	@RequestMapping(value="admin/categoryopp",method=RequestMethod.GET)
	public String getProductPage(){
		return "CategoryOpp";
	}
	
	/*
	@RequestMapping(value="addcategory",method=RequestMethod.GET)
	public String (ModelMap map){
		return "AddCategory";
		}*/	
	
	@RequestMapping(value="admin/addcategory",method=RequestMethod.GET)
	public String AddProduct(ModelMap map){
		
		return"AddCategory";
			
	}


	@RequestMapping(value="admin/submitcategory",method=RequestMethod.POST)
	public String SubmitAddProduct(@RequestParam("categoryName")String categoryName,ModelMap map){

		Category cat=new Category();
		cat.setCategoryName(categoryName);
		cat.setCategory_isactive("Active");
		
		System.out.println("Category Added Succefully");
		
		boolean cat1=catObj.addCategory(cat);
		if(cat1==true){
			map.addAttribute("msg","Category Added Succesfully");
			return "redirect:/admin/viewAllCategory";
		}
		else{
			return"Failure";
		}
		
		
	
	}
	
	@RequestMapping(value="admin/viewAllCategory",method=RequestMethod.GET)
	public String listCategories(ModelMap map){
		List<Category> categories=catObj.category(); 
		map.addAttribute("catList", categories);
		return "ViewAllCategories";
	}

	
	@RequestMapping(value="admin/deletecategory/{categoryId}",method=RequestMethod.GET)
	public String SubmitdeleteCategory(@PathVariable("categoryId")int catId,ModelMap map){
	
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
		  }
		


	
	}
			
	
	
	


	











