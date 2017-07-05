package com.pro.Evol;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String signin()
	{
		
		
		return "Login";
}
	@RequestMapping("/signup")
	public String signup()
	{
		
		
		return "signuppage";
	}
	
	@RequestMapping("/Book")
	public String Book(Model m)
	{
		String str="Book";
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
		String str="Book";
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("catlist1",this. getCateList1());
		m.addAttribute("Book",str);
		return "Music";
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


