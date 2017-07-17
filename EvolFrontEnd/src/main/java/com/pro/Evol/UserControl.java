package com.pro.Evol;

import java.util.Collection;
import java.util.List;

import javax.persistence.metamodel.Metamodel;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pro.Evol.dao.CartDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.dao.UserDAO;
import com.pro.Evol.model.Cart;
import com.pro.Evol.model.Product;
import com.pro.Evol.model.UserDetails;

@Controller
public class UserControl {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
    public String addUser(@RequestParam("username") String username , @RequestParam("password") String password,@RequestParam("email") String email,@RequestParam("phonenumber") Integer mobileno ,@RequestParam("address") String address)
    {
    System.out.println("add user to db");
    System.out.println(username+";;;"+password);
    UserDetails user=new UserDetails();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setMobileno(mobileno);
    user.setRole("ROLE_USER");
    user.setEnabled(true);
    user.setAddress(address);
    userDAO.insertUpdateUser(user);
    System.out.println("UserAdded");
   return "redirect:/UserHome1";
   
    }
	
	
	@RequestMapping("/login_success")
	public String loginsuccess(HttpSession session,Model m)
	{
		System.out.println("loded successfully");
		
String page=null;

boolean loggedIn=true;
   String username= SecurityContextHolder.getContext().getAuthentication().getName();

   session.setAttribute("username",username);
   session.setAttribute("loggedIn",loggedIn);

	@SuppressWarnings("unchecked")
	Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
  for(GrantedAuthority role:authorities)
	{
	  System.out.println("Role:"+role.getAuthority()+"username"+username);
		
	  
	if(role.getAuthority().equals("admin"))
	{
		
	return "AdminHome";
	}
	else
	{
		
		Product<MultipartFile> product=new Product<MultipartFile>();
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		
		
		
	
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
		
		
		
	return "UserHome";
	}
	}

   
			
   return "page";
	}
	
	
	
	@RequestMapping("/UserHome1")
	public String UserHome(Model m,HttpSession session)
	{
		String username=(String) session.getAttribute("username");
	List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
		
		

		Product<MultipartFile> product=new Product<MultipartFile>();
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
	return "User";
	}

}
