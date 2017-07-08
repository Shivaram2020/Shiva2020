package com.pro.Evol;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.Evol.dao.CartDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.model.Cart;


@Controller
public class OrderControl {
	
	

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping("/CheckOut")
	public String Cartpage(Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
		m.addAttribute("cartlist",cartlist);
		
		return "/CheckOut";
	}
	
	@RequestMapping("/pay")
	public String Confirmation(Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");
		
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		for(Cart cart:cartlist)
		{
			Cart cart1=cartDAO.getCart(cart.getCartitemid());
			cart1.setStatus("y");
			cartDAO.insertUpdateCart(cart1);
			
		}
		
		
		return "ThankPage";
	}

}
