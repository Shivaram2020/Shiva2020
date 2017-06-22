package com.pro.Evol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.Evol.dao.CategoryDAO;
import com.pro.Evol.model.Category;

@Controller
public class CategoryControl {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	public String showCategoryPage(Model m)
	{
		System.out.println("---Category Page Displaying-----");
		List<Category> list=categoryDAO.getCategoryDetails();
		m.addAttribute("catdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	
		return "Category";
	}
	
	@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc, Model m)
	{
		System.out.println("---Add Category Starting-----");
		
		System.out.println(catname+":::"+catdesc);
		
		Category category=new Category();
		category.setCatname(catname);
		category.setCatdesc(catdesc);
		
		categoryDAO.insertUpdateCategory(category);
		System.out.println("---Category Added----");
		
		List<Category> list=categoryDAO.getCategoryDetails();
		m.addAttribute("catdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---Category Added----");
		
		return "Category";
	}

	@RequestMapping(value="/deleteCategory/{catid}",method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("catid") int catid,Model m)
	{
		System.out.println("-----category deleted-----");
		Category category=(Category)categoryDAO.getCategory(catid);
		categoryDAO.deleteCategory(category);
		List<Category> list=categoryDAO.getCategoryDetails();
		m.addAttribute("catdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	     return "Category";
	}
	
	
	@RequestMapping(value="/updateCategory/{catid}",method=RequestMethod.GET)
	public String updateCategory(@PathVariable("catid") int catid,Model m)
	{
		System.out.println("-----category deleted-----");
		Category category=(Category)categoryDAO.getCategory(catid);
	    m.addAttribute("category" ,category);
		List<Category> list=categoryDAO.getCategoryDetails();
		m.addAttribute("catdetails",list);
		boolean flag=true;
		m.addAttribute("flag",flag);
	     return "Category";
	}
	
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catid") int catid,@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc,Model m)
	{
		System.out.println("-----category updated-----");
		Category category=new Category();
		category.setCatid(catid);
		category.setCatname(catname);
		category.setCatdesc(catdesc);
		categoryDAO.insertUpdateCategory(category);
		List<Category> list=categoryDAO.getCategoryDetails();
		m.addAttribute("catdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	     return "Category";
	}


}
