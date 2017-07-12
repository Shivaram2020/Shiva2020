package com.pro.Evol;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pro.Evol.dao.CategoryDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.model.Category;
import com.pro.Evol.model.Product;


@Controller
public class PageController {
	
	@Autowired
		CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	
	
	@RequestMapping("/Login")
	public String Login()
	{
		
		
		return "Login";
}
	
	@RequestMapping("/AboutUs")
	public String AboutUs()
	{
		
		
		return "AboutUs";
}
	@RequestMapping("/ContactUs")
	public String ContactUs()
	{
		
		
		return "ContactUs";
}
	
	
	
	@RequestMapping("/LoginError")
	public String LoginError()
	{
		
		
		return "LoginError";
}
	@RequestMapping("/signup")
	public String signup()
	{
		
		
		return "signuppage";
	}
	
	
	@RequestMapping("/Warning")
	public String warning()
	{
		
		
		return "Warning";
}
	
	
	@RequestMapping("/Book")
	public String Book(Model m)
	{
		

		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Book";
	}
	
	@RequestMapping("/Music")
	public String category(Model m)
	{
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Music";
	}
	
	
	@RequestMapping("/Painting")
	public String Painting(Model m)
	{
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Painting";
	}
	
	
	@RequestMapping("/Photography")
	public String Photography(Model m)
	{
		

		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Photography";
	}
	
	
	
	@RequestMapping("/Game")
	public String Game(Model m)
	{
		

		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "Game";
	}
	
	
	
	
	
	
    }


