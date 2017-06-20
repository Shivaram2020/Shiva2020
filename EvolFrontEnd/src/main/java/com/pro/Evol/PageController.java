package com.pro.Evol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping("/signin")
	public ModelAndView signin(
			@RequestParam(value = "signin", required = false) String a) {
		
		ModelAndView signin = new ModelAndView("signinpage");
		return signin;
}
	@RequestMapping("/signup")
	public ModelAndView signup(
			@RequestParam(value = "signup", required = false) String a) {
		
		ModelAndView signin = new ModelAndView("signuppage");
		return signin;
}

}
