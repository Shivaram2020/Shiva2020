package com.pro.Evol;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pro.Evol.dao.CategoryDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.dao.SupplierDAO;
import com.pro.Evol.model.Category;
import com.pro.Evol.model.Product;
import com.pro.Evol.model.Supplier;

@Controller
public class ProductControl 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/Product")
	public String showProduct(Model m)
	{
		
		
		Product product=new Product();
		
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("supplist",this.getSuppList());
		m.addAttribute("product",product);
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,Model m)
	{
		System.out.println("---Product Inserted---");
		productDAO.insertUpdateProduct(product);	
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "Product";
	}
	
	@RequestMapping(value="/updateProduct/{prodid}")
	public String updateProduct(@PathVariable("prodid")int prodid,Model m)
	{
		
		Product product=productDAO.getProduct(prodid);
		m.addAttribute("product",product);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("supplist",this.getSuppList());
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "Product";
	}

	
	@RequestMapping(value="/deleteProduct/{prodid}")
	public String deleteProduct(@PathVariable("prodid")int prodid,Model m)
	{
		
		Product product=productDAO.getProduct(prodid);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("supplist",this.getSuppList());
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "redirect:/Product";
	}
	
	public LinkedHashMap<Integer,String> getCatList()
	{
		List<Category> list=categoryDAO.getCategoryDetails();
		
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		
		for(Category cat:list)
		{
			catlist.put(cat.getCatid(),cat.getCatname());
		}
		
		return catlist;
	}
	
	public LinkedHashMap<Integer,String> getSuppList()
	{
		List<Supplier> list=supplierDAO.getSupplierDetails();
		
		LinkedHashMap<Integer,String> supplist=new LinkedHashMap<Integer,String>();
		
		for(Supplier supp:list)
		{
			supplist.put(supp.getSuppid(),supp.getSuppname());
		}
		
		return supplist;
	}
	
	
	
}

