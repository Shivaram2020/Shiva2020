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
import com.pro.Evol.dao.OrdersDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.model.Cart;
import com.pro.Evol.model.Orders;


@Controller
public class OrderControl {
	@Autowired
	OrdersDAO ordersDAO;
	

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
		List<Orders> orderlist=ordersDAO.getOrdersDetails(username);
		
		m.addAttribute("orderlist",orderlist);
		
		
		return "Confirm";
	}
	
	
	@RequestMapping("/payment")
	public String payment(@RequestParam("paymode") String paymode,@RequestParam("shipping") String shipping,Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");
		Orders order=new Orders();
		Integer grand=0;
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		for(Cart cart:cartlist)
		{
			grand=grand+(cart.getQuantity()*cart.getPrice());
			
			
		}
		
		
		order.setTotal(grand);
		order.setPaymode(paymode);
		order.setShipmentaddress(shipping);
		order.setUsername(username);
		order.setStatus("N");
		
		ordersDAO.insertUpdateOrders(order);	
		
		List<Cart> cartlist1=cartDAO.getCartDetails(username);
		for(Cart cart:cartlist1)
		{
			
			
			Cart cart1=cartDAO.getCart(cart.getCartitemid());
			cart1.setStatus("y");
			cartDAO.insertUpdateCart(cart1);
			
		}
		
		
		return "redirect:/pay";
		
	}
	

	@RequestMapping("/confirm")
	public String confirm(HttpSession session)

	{
		String username=(String) session.getAttribute("username");
		
		
		List<Orders> list=ordersDAO.getOrdersDetails(username);
		for(Orders orders:list)
		{
			Orders orders1=ordersDAO.getOrders(orders.getOrderid());
			orders1.setStatus("Y");
			ordersDAO.insertUpdateOrders(orders1);
			
		}
		
		
		return "ThankPage";
	}
	
	@RequestMapping(value="/deleteorders/{orderid}")
	public String deleteCart(@PathVariable("orderid") int orderid,Model m)
	{
		

		

		
		Orders order=(Orders)ordersDAO.getOrders(orderid); 
		
		ordersDAO.deleteOrders(order);
		
	
		
		return "redirect:/pay";
		
	}

	
	
	
}
