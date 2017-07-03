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
	public String signin()
	{
		
		
		return "signinpage";
}
	@RequestMapping("/signup")
	public String signup()
	{
		
		
		return "signuppage";
	}
	

	
    }


