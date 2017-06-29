package com.pro.Evol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.Evol.dao.SupplierDAO;
import com.pro.Evol.model.Supplier;

@Controller
public class SupplierControl {
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/Supplier")
	public String showCategoryPage(Model m)
	{
		System.out.println("---Category Page Displaying-----");
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	
		return "Supplier";
	}
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String addCategory(@RequestParam("suppname") String suppname,@RequestParam("address") String address, Model m)
	{
		System.out.println("---Add Supplier Starting-----");
		
		System.out.println(suppname+":::"+address);
		
		Supplier supplier=new Supplier();
		supplier.setSuppname(suppname);
		supplier.setAddress(address);
		
		supplierDAO.insertUpdateSupplier(supplier);
		System.out.println("---Supplier Added----");
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---Supplier Added----");
		
		return "Supplier";
	}

	@RequestMapping(value="/deleteSupplier/{suppid}")
	public String deleteCategory(@PathVariable("suppid") int suppid,Model m)
	{
		System.out.println("---Supplier Deleted----");
		Supplier supplier=supplierDAO.getSupplier(suppid);
		supplierDAO.deleteSupplier(supplier);
		
		System.out.println("---Category Page Displaying-----");
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	
		return "redirect:/Supplier";
	}
	
	@RequestMapping(value="updateSupplier/deleteSupplier/{suppid}")
	public String deleteCategory1(@PathVariable("suppid") int suppid,Model m)
	{
		System.out.println("---Supplier Deleted----");
		Supplier supplier=supplierDAO.getSupplier(suppid);
		supplierDAO.deleteSupplier(supplier);
		
		System.out.println("---Category Page Displaying-----");
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	
		return "redirect:/Supplier";
	}
	
	
	@RequestMapping(value="updateSupplier/{suppid}")
	public String getUpdateCategory(@PathVariable("suppid") int suppid,Model m)
	{
		System.out.println("--- Getting Supplier Object to be Updated ---");
		
		Supplier supplier=supplierDAO.getSupplier(suppid);
		m.addAttribute("category",supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetails",list);
		boolean flag=true;
		m.addAttribute("flag",flag);
	
		return "Supplier";
	}
	
	@RequestMapping(value="updateSupplier/UpdateSupplier",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("suppid") int suppid,@RequestParam("suppname") String suppname,@RequestParam("address") String address,Model m)
	{
System.out.println("---Add Supplier Starting-----");
		
		System.out.println(suppname+":::"+address);
		
		Supplier supplier=new Supplier();
		supplier.setSuppid(suppid);
		supplier.setSuppname(suppname);
		supplier.setAddress(address);
		
		supplierDAO.insertUpdateSupplier(supplier);
		System.out.println("---Category Added----");
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---Supplier Added----");
		
		return "redirect:/Supplier";
}





}
