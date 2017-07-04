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

import com.pro.Evol.dao.UserDAO;
import com.pro.Evol.model.UserDetails;

@Controller
public class UserControl {
	
	@Autowired
	UserDAO userDAO;
	@RequestMapping("/UserHome")
	public String Login(Model m)
	{
		
		List<UserDetails> list=userDAO.getUserDetails();
		m.addAttribute("userdetails",list);
		
		return "UserHome";
	}
	
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
    public String addUser(@RequestParam("username") String username , @RequestParam("password") String password)
    {
    System.out.println("add user to db");
    System.out.println(username+";;;"+password);
    UserDetails user=new UserDetails();
    user.setUsername(username);
    user.setPassword(password);
    
    userDAO.insertUpdateUser(user);
    System.out.println("UserAdded");
   return "signuppage";
   
    }
	
	
	@RequestMapping("/login_success")
	public String loginsuccess(HttpSession session)
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
	return "UserHome";
	}
	}

   
			
   return "page";
	}
	
	
	

}
