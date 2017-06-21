package com.pro.Evol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.Evol.dao.UserDAO;
import com.pro.Evol.model.UserDetails;


@Controller
public class PageController {
	
	@Autowired
		UserDAO userDAO;
	
	
	
	@RequestMapping("/signin")
	public ModelAndView signin(
			@RequestParam(value = "signin", required = false) String a) {
		
		ModelAndView signin = new ModelAndView("signinpage");
		return signin;
}
	@RequestMapping("/signup")
	public ModelAndView signup(
			@RequestParam(value = "signup", required = false) String a) {
		
		ModelAndView signup = new ModelAndView("signuppage");
		return signup;
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
    }


