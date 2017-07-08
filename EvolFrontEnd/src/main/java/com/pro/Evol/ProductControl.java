package com.pro.Evol;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	//show page
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
	
	
	//insert page
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product, Model m,@RequestParam("pimage") MultipartFile filedet,BindingResult result)
	{
		System.out.println("---Product Inserted---");
		productDAO.insertUpdateProduct(product);	
		
		
		System.out.println("image starting upload");
		
		
		String path="E:\\EVOL\\EvolFrontEnd\\src\\main\\webapp\\resources\\images\\";
		String fileinfo=path+product.getProdid()+".jpg";
		
		File f=new File(fileinfo);
		if(!filedet.isEmpty())
		{
			try {
				byte buff[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bss=new BufferedOutputStream(fos);
				bss.write(buff);
				
			} 
			
			catch (IOException e) {
				System.out.println("uploding problem"+e);		
				
			}
		}
		else
		{
			System.out.println("uploading problem");
		}
		
		
		
		
		System.out.println("image stored");
		
		
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
	      return "redirect:/Product";
	}
	
	
	//pass the respective id
	
	@RequestMapping(value="/updateProduct/{prodid}")
	public String updateProduct(@PathVariable("prodid")int prodid,Model m)
	{
		
		Product product=productDAO.getProduct(prodid);
		m.addAttribute("product",product);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("supplist",this.getSuppList());
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		boolean flag=true;
		m.addAttribute("flag",flag);
	
		return "Product";
	}
	
	
	
	//update the respective id
	@RequestMapping(value="/updateProduct/InsertProduct",method=RequestMethod.POST)
	public String updateProductred(@ModelAttribute("product") Product product, Model m,@RequestParam("pimage") MultipartFile filedet,BindingResult result)
	{
		System.out.println("---Product Inserted---");
		productDAO.insertUpdateProduct(product);	
		
	
		System.out.println("image starting upload");
		
		
		String path="E:\\EVOL\\EvolFrontEnd\\src\\main\\webapp\\resources\\images\\";
		String fileinfo=path+product.getProdid()+".jpg";
		
		File f=new File(fileinfo);
		if(!filedet.isEmpty())
		{
			try {
				byte buff[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bss=new BufferedOutputStream(fos);
				bss.write(buff);
				
			} 
			
			catch (IOException e) {
				System.out.println("uploding problem"+e);		
				
			}
		}
		else
		{
			System.out.println("uploading problem");
		}
		
		
		
		
		System.out.println("image stored");
		
		
	
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "redirect:/Product";
	}

	//delete 
	@RequestMapping(value="/updateProduct/deleteProduct/{prodid}")
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
	
	
	// update and try to delete 
		@RequestMapping(value="/deleteProduct/{prodid}")
		public String deleteProductup(@PathVariable("prodid")int prodid,Model m)
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
	
	
	// category collection
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
	
	
	//supplier collection
	
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
	
	
	
	@RequestMapping(value="/ProductDescription/{prodid}")
	public String showProductDescription(@PathVariable("prodid") int prodid,Model m)
	{
		Product product=productDAO.getProduct(prodid);
		m.addAttribute("prodinfo",product);
		
		return "ProductDescription";
	}
	
}

