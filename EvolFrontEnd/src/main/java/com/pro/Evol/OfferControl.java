package com.pro.Evol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.Evol.dao.OfferDAO;
import com.pro.Evol.model.Offer;

@Controller
public class OfferControl {
	
	@Autowired
	OfferDAO offerDAO;
	
	@RequestMapping("/Offer")
	public String showOfferPage(Model m)
	{
		System.out.println("---Offer Page Displaying-----");
		List<Offer> list=offerDAO.getOfferDetails();
		m.addAttribute("offdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	
		return "Offer";
	}
	
	@RequestMapping(value="/AddOffer",method=RequestMethod.POST)
	public String addOffer(@RequestParam("offname") String offname,@RequestParam("offdesc") String offdesc, Model m)
	{
		System.out.println("---Add Offer Starting-----");
		
		System.out.println(offname+":::"+offdesc);
		
		Offer offer=new Offer();
		offer.setOffname(offname);
		offer.setOffdesc(offdesc);
		
		offerDAO.insertUpdateOffer(offer);
		System.out.println("---Offer Added----");
		
		List<Offer> list=offerDAO.getOfferDetails();
		m.addAttribute("offdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---Offer Added----");
		
		return "Offer";
	}

	@RequestMapping(value="/deleteOffer/{offid}")
	public String deleteOffer(@PathVariable("offid") int offid,Model m)
	{
		System.out.println("---Offer Deleted----");
		Offer offer=offerDAO.getOffer(offid);
		offerDAO.deleteOffer(offer);
		
		System.out.println("---Offer Page Displaying-----");
		List<Offer> list=offerDAO.getOfferDetails();
		m.addAttribute("offdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	
		return "redirect:/Offer";
	}
	
	@RequestMapping(value="/updateOffer/deleteOffer/{offid}")
	public String deleteOffer1(@PathVariable("offid") int offid,Model m)
	{
		System.out.println("---Offer Deleted----");
		Offer offer=offerDAO.getOffer(offid);
		offerDAO.deleteOffer(offer);
		
		System.out.println("---Offer Page Displaying-----");
		List<Offer> list=offerDAO.getOfferDetails();
		m.addAttribute("offdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
	
		return "redirect:/Offer";
	}
	
	
	@RequestMapping(value="updateOffer/{offid}")
	public String getUpdateOffer(@PathVariable("offid") int offid,Model m)
	{
		System.out.println("--- Getting Offer Object to be Updated ---");
		
		Offer offer=offerDAO.getOffer(offid);
		m.addAttribute("offer",offer);
		
		List<Offer> list=offerDAO.getOfferDetails();
		m.addAttribute("offdetails",list);
		boolean flag=true;
		m.addAttribute("flag",flag);
	
		return "/Offer";
	}
	
	@RequestMapping(value="updateOffer/UpdateOffer",method=RequestMethod.POST)
	public String updateOffer(@RequestParam("offid") int offid,@RequestParam("offname") String offname,@RequestParam("offdesc") String offdesc,Model m)
	{
System.out.println("---Add Offer Starting-----");
		
		System.out.println(offname+":::"+offdesc);
		
		Offer offer=new Offer();
		offer.setOffid(offid);
		offer.setOffname(offname);
		offer.setOffdesc(offdesc);
		
		offerDAO.insertUpdateOffer(offer);
		System.out.println("---Offer Added----");
		
		List<Offer> list=offerDAO.getOfferDetails();
		m.addAttribute("offdetails",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---Offer Added----");
		
		return "redirect:/Offer";
}



}
