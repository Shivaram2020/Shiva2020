package com.pro.Evol;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControl {
	@RequestMapping("/login")
	public String Login()
	{
		return "UserHome";
	}
	
	@RequestMapping("/login-success")
	public String loginsuccess(HttpSession session)
	{
		System.out.println("loded successfully");
		

   String username= SecurityContextHolder.getContext().getAuthentication().getName();

   session.setAttribute("username",username);
   

	@SuppressWarnings("unchecked")
	Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
  for(GrantedAuthority role:authorities)
	{
	  System.out.println("Role:"+role.getAuthority()+"username"+username);
		
	  
	if(role.equals("ROLE_ADMIN"))
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
