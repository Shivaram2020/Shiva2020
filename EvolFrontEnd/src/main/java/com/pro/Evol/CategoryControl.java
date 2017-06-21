package com.pro.Evol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String showCategoryPage()
	{
		System.out.println("---Category Page Displaying-----");
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
		
		System.out.println("---Category Added----");
		
		return "Category";
	}

	

}
