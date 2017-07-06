package com.pro.Evol;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.Evol.dao.CartDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.model.Cart;
import com.pro.Evol.model.Product;

@Controller
public class CartControl {
	

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping(value="/CartPage")
	public String Cartpage(Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");

		
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		m.addAttribute("cartlist",cartlist);
		
		return "CartPage";
	}
	
	
	@RequestMapping(value="/AddCart/{prodid}")
	public String AddCart(@PathVariable("prodid") int prodid,@RequestParam("quantity") int quantity,HttpSession session,Model m)
	{
		Cart cart=new Cart();
		
		String username=(String) session.getAttribute("username");
		
		cart.setCartid(1001);
		cart.setQuantity(quantity);
		cart.setStatus("N");
		cart.setUsername(username);
		cart.setProdid(prodid);
		
		
	
		
		Product product=productDAO.getProduct(prodid);
		cart.setProductname(product.getProdname());
		cart.setPrice(product.getPrice());
		cart.setCatid(product.getCatid());
		cartDAO.insertUpdateCart(cart);	
		if(quantity<=product.getQuantity())
		{
			
			List<Cart> cartlist=cartDAO.getCartDetails(username);
			m.addAttribute("cartlist",cartlist);
		return "CartPage";
		}
		else
			
		{
		return "WarningPage";	
		}

	


}
	


@RequestMapping(value="/update/{citemid}")
public String updateCart(@PathVariable("citemid") int citemid,@RequestParam("quantity") int quantity,HttpSession session,Model m)
{
	

	

	
	Cart cart=(Cart)cartDAO.getCart(citemid);
	cart.setQuantity(quantity);
	cartDAO.insertUpdateCart(cart);
	
String username=(String) session.getAttribute("username");
	
	List<Cart> cartlist=cartDAO.getCartDetails(username);
	m.addAttribute("cartlist",cartlist);
	
	
	
	return "CartPage";
	
}



@RequestMapping(value="/delete/{citemid}")
public String deleteCart(@PathVariable("citemid") int citemid,HttpSession session,Model m)
{
	

	

	
	Cart cart=(Cart)cartDAO.getCart(citemid);
	
	cartDAO.deleteCart(cart);
	
String username=(String) session.getAttribute("username");
	
	List<Cart> cartlist=cartDAO.getCartDetails(username);
	m.addAttribute("cartlist",cartlist);
	
	
	
	return "CartPage";
	
}



}
