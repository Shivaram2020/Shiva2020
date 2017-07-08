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
		String str="Book";

		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("catlist1",this. getCateList1());
		m.addAttribute("Book",str);
		return "Book";
	}
	
	@RequestMapping("/Music")
	public String category(Model m)
	{
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("catlist1",this. getCateList1());
	
		return "Music";
	}
	
	
	@RequestMapping("/Painting")
	public String Painting(Model m)
	{
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("catlist1",this. getCateList1());
		
		return "Painting";
	}
	
	
	@RequestMapping("/Photography")
	public String Photography(Model m)
	{
		

		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("catlist1",this. getCateList1());
	
		return "Photography";
	}
	
	
	
	@RequestMapping("/Game")
	public String Game(Model m)
	{
		

		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("catlist1",this. getCateList1());
	
		return "Game";
	}
	
	
	
	
	
	public LinkedHashSet<Integer> getCatList()
	{
		List<Category> list=categoryDAO.getCategoryDetails();
		
		LinkedHashSet<Integer> catlist=new LinkedHashSet<Integer>();
		
		for(Category cat:list)
		{
			catlist.add(cat.getCatid());
		}
		
		return catlist;
	}
	public LinkedHashSet<String> getCateList1()
	{
		List<Category> list=categoryDAO.getCategoryDetails();
		
		LinkedHashSet<String> catlist1=new LinkedHashSet<String>();
		
		for(Category cat:list)
		{
			catlist1.add(cat.getCatname());
		}
		
		return catlist1;
	}
    }


