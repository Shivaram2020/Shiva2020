package com.pro.Evol;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.Evol.model.UserDetails;

import dao.LoginDAO;
import model.Login;

@Controller
public class login {
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String addUser(@RequestParam("uname") String username , @RequestParam("passwd") String password) throws Exception
    {
		Login loginobj=new Login();
		loginobj.setLogin(username);
		loginobj.setPassword(password);
		
	
		
		LoginDAO loginDAO=new LoginDAO();
		
			
		if(loginDAO.isValid(loginobj))
		{
			return "UserHome";
		}
		else
		{
			return "Failure";
		}
		
		

   
    }

}
