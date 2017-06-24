package com.pro.Evol;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pro.Evol.dao.CategoryDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.model.Category;
import com.pro.Evol.model.Product;

@Controller
public class ProductControl {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/product",method = RequestMethod.GET)
	public String showProductPage(Model m)
	{
		List<Category> list=categoryDAO.getCategoryDetails();
		
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		System.out.println("working 1");
		for(Category cate:list)
		{
			catlist.put(cate.getCatid(),cate.getCatname());
		}
		Product product=new Product();
		m.addAttribute("product", product);
		m.addAttribute("catlist", catlist);
		System.out.println("working");
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertproduct(@ModelAttribute("product") Product product)
	{
		System.out.println("---product inserted----");
		productDAO.insertUpdateProduct(product);
		return "Product";
		
}
}