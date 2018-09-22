package com.mainproject.controllers;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mainproject.backend01.daos.*;
import com.mainproject.backend01.models.*;



@Controller
public class CartController {

	
	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	AddressDAO addressDao;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	CartDAO cartDao;
	
	@Autowired
	ItemsDAO itemDao;
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	ProductDAO productDao;
	
	@RequestMapping(value="/addToCart/{productId}",method=RequestMethod.GET)
	public String addToCart(@PathVariable("productId")int productId)
	{
		Principal principal = request.getUserPrincipal();
		String userEmail=principal.getName();
		
		System.out.println("User Email = "+userEmail);
		
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		
		if(cartObj==null){
			
			System.out.println("Cart is null");
			Cart cart=new Cart();
			
			System.out.println("I m here 1");
			cart.setCustomerId(userEmail);
			//cart.setUser(userDao.userGetByEmail(userEmail));
			System.out.println("I m here 2");
			//cart.setUser(userDao.userGetByEmail(userEmail));
			
			
			System.out.println("I m here 3");
		
			
			cartDao.addCart(cart);
			
			System.out.println("I m Here 4");
			
			Items item=new Items();
			item.setCart(cartDao.getCartByCustomer(userEmail));
			item.setCutomerId(userEmail);
			item.setPrice(productDao.getProduct(productId).getPrice());
			item.setProduct(productDao.getProduct(productId));
			item.setQuantity(1);
			
			ArrayList<Items> al=new ArrayList<>();
			al.add(item);
			cart.setItems(al);
			
			itemDao.addItem(item);
			System.out.println("Cart Created Succesfully");
			
		}
		else {
			
			System.out.println("Cart is available");
			Product pro=productDao.getProduct(productId);
			
			Items itemObj=itemDao.getItemByProductIdAndCustomerId(productId, userEmail);
			if(itemObj==null){
				System.out.println("New Item");
				Items item=new Items();
				item.setCart(cartObj);
				item.setCutomerId(userEmail);
				item.setPrice(pro.getPrice());
				item.setProduct(pro);
				item.setQuantity(1);
				
				itemDao.addItem(item);
				System.out.println("Item Object added into existing cart");
				
			}
			else {
				itemDao.increaseQuantity(itemObj.getItemId());
			}
			
		}
		return "redirect:viewCart?uEmail="+userEmail;
	}
	
	
	@RequestMapping(value="/addToCart/viewCart",method=RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("uEmail")String uEmail)
	{
		System.out.println("uEmail = "+uEmail);
		ModelAndView mv=new ModelAndView("ViewCart");
		Cart cartObj=cartDao.getCartByCustomer(uEmail);
		System.out.println("Cart Obj : "+cartObj );
		List<Items> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		for(Items i:items){
			if(i.getQuantity()==0){
				itemDao.deleteItem(i.getItemId());
				items=itemDao.getItemsListByCart(cartObj.getCartId());
			}
		}
		
		mv.addObject("itemsList",items);
		return mv;
	}
	
	@RequestMapping(value="/addToCart/deleteItem/{iId}",method=RequestMethod.GET)
	public ModelAndView deleteFromCart(@PathVariable("iId")int itemId){
		
		itemDao.deleteItem(itemId);
		
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Items> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("ViewCart");
		mv.addObject("itemsList",items);
		mv.addObject("msg","Item deleted");
		return mv;
	}
	
	
	@RequestMapping(value="/addToCart/increaseQuantity/{iId}",method=RequestMethod.GET)
	public ModelAndView increaseQuantity(@PathVariable("iId")int itemId){
		
		itemDao.increaseQuantity(itemId);
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Items> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("ViewCart");
		mv.addObject("itemsList",items);
		mv.addObject("msg","Quantity Increased");
		return mv;
	}
	
	
	@RequestMapping(value="/addToCart/decreaseQuantity/{iId}",method=RequestMethod.GET)
	public ModelAndView decreaseQuantity(@PathVariable("iId")int itemId){
		
		itemDao.decreaseQuantity(itemId);
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Items> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("ViewCart");
		mv.addObject("itemsList",items);
		mv.addObject("msg","Quantity decreased");
		return mv;
	}
	
	@RequestMapping(value="/addToCart/makePayment",method=RequestMethod.GET)
	public ModelAndView addressForm(){
		
		String id=request.getUserPrincipal().getName();
		System.out.println("Id = "+id);
		User user=userDao.userGetByEmail(id);
		System.out.println("User ="+user);
		
		
		Set<Address> addresses=user.getAddress();
		
		
		
		if(addresses.isEmpty()){
			ModelAndView mv=new ModelAndView("AddressForm");
			mv.addObject("addressObj",new Address());
			return mv;
		}
		else {
		ModelAndView mv=new ModelAndView("ViewAddress");
		mv.addObject("addressList",addresses);
		return mv;
		}
	}
	
	@RequestMapping(value="/addToCart/addAddress",method=RequestMethod.POST)
	public ModelAndView addAddress(@ModelAttribute("addressObj")Address addrObj){
		
		String id=request.getUserPrincipal().getName();
		User user=userDao.userGetByEmail(id);
	
		addrObj.setUser(userDao.userGetByEmail(id));
		
		addressDao.insertAddress(addrObj);
		
		Set<Address> addresses=user.getAddress();
		
		
		ModelAndView mv=new ModelAndView("ViewAddress");
		mv.addObject("addressList",addresses);
		return mv;
		
	}
	
	@RequestMapping(value="/addToCart/placeOrder",method=RequestMethod.GET)
	public ModelAndView makePayment(){
		
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Items> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Items item:items){
			sum=sum+item.getPrice();
		}
		
		ModelAndView mv=new ModelAndView("OrderConfirmation");
		mv.addObject("itemsList",items);
		mv.addObject("totalAmountToPay",sum);
		
		return mv;
	}

	@RequestMapping(value="/addToCart/confirmOrder",method=RequestMethod.GET)
	public ModelAndView confirmOrder(){
		Principal p=request.getUserPrincipal();
		Cart cartObj=cartDao.getCartByCustomer(p.getName());
		List<Items> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Items item:items){
			sum=sum+item.getPrice();
		}
	
		ModelAndView mv=new ModelAndView("PaymentForm");
		mv.addObject("itemsList",items);
		mv.addObject("totalAmountToPay",sum);
		
		Order o=new Order();
		o.setTotalPrice(sum);
		
		List<Address> addrList=new ArrayList<>(userDao.userGetByEmail(p.getName()).getAddress());
		o.setAddress(addrList.get(0));
		
		o.setUser(userDao.userGetByEmail(p.getName()));
		System.out.println("I m here  in before PRocess Order "+userDao.userGetByEmail(p.getName())+" "+addrList.get(0));
		System.out.println("I m here  in before PRocess Order "+o.getAddress()+" "+o.getUser());
		
		mv.addObject("orderObj",o);
		return mv;
	}

	@RequestMapping(value="/addToCart/processOrder",method=RequestMethod.POST)
	public ModelAndView processOrder(@ModelAttribute("orderObj")Order orderObj){
		
		System.out.println("I m here 1 in PRocess Order");
		String email=request.getUserPrincipal().getName();
	
		Cart cartObj=cartDao.getCartByCustomer(email);
		List<Items> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Items item:items){
			sum=sum+item.getPrice();
		}
		
		List<Address> addrList=new ArrayList<>(userDao.userGetByEmail(email).getAddress());
		orderObj.setAddress(addrList.get(0));
		
		orderObj.setUser(userDao.userGetByEmail(email));
		
		System.out.println("I m here 2 in PRocess Order "+orderObj.getAddress()+" "+orderObj.getUser());
		orderDao.makeOrder(orderObj);
		cartDao.deleteCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("PaymentSuccess");
		mv.addObject("totalAmountToPay",sum);
		return mv;
	}
	
}






