package com.pro.Evol;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.Evol.config.DBConfig;
import com.pro.Evol.dao.CartDAO;
import com.pro.Evol.dao.OrdersDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.dao.UserDAO;
import com.pro.Evol.mail.OrderService;
import com.pro.Evol.model.Cart;
import com.pro.Evol.model.Orders;
import com.pro.Evol.model.UserDetails;


@Controller
public class OrderControl {
	@Autowired
	OrdersDAO ordersDAO;
	 
	@Autowired
	static
	OrdersDAO ordersDAO1;
	
	@Autowired
	JavaMailSender mailSender;

	@Autowired
	static
	UserDetails userDetails;
	
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	static
	UserDAO userDAO1;
	
	
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
		
		UserDetails user=userDAO.getUser(username);
		order.setTotal(grand);
		order.setPaymode(paymode);
		order.setShipmentaddress(shipping);
		order.setUsername(username);
		order.setStatus("N");
		order.setEmail(user.getEmail());
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
	

	
	
	@RequestMapping(value="/deleteorders/{orderid}")
	public String deleteCart(@PathVariable("orderid") int orderid,Model m)
	{
		

		

		
		Orders order=(Orders)ordersDAO.getOrders(orderid); 
		
		ordersDAO.deleteOrders(order);
		
	
		
		return "redirect:/pay";
		
	}




@RequestMapping("/confirm")
public static String main(String[] args,HttpSession session) {
	
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	String username=(String) session.getAttribute("username");
	
	String email=null;
	String paymode=null;
	int Total=0;
	String address=null;
	int id=0;
	 
	OrdersDAO ordersDAO=(OrdersDAO)context.getBean("ordersDAO");
	
	List<Orders> list=ordersDAO.getOrdersDetails(username);
	
			for(Orders orders:list)
			{
				String mail=(String)orders.getEmail();
				String mode=(String)orders.getPaymode();
				Integer tot=(Integer)orders.getTotal();
				String addr=(String)orders.getShipmentaddress();
				Integer oid=(Integer)orders.getOrderid();
				email=mail;
				paymode=mode;
				Total=tot;
				address=addr;
				id=oid;
			
			}
			System.out.println(email+paymode+Total+address+"--------------------------------------------------");
			
	Orders order1 = new Orders();
		order1.setOrderid(id);
		order1.setUsername(username);
		
		order1.setEmail(email);
		order1.setPaymode(paymode);
		order1.setShipmentaddress(address);
		order1.setTotal(Total);
		
	OrderService orderService = (OrderService) context.getBean("mailControl1");
	orderService.sendOrderConfirmation1(order1);
	

	((AbstractApplicationContext) context).close();
	
	

	return "redirect:/Thank";
}
@RequestMapping("/Thank")
public String thank(HttpSession session)
{
	
	String username=(String) session.getAttribute("username");
	
	List<Orders> list11=ordersDAO.getOrdersDetails(username);
	for(Orders orders:list11)
	{
		Orders orders1=ordersDAO.getOrders(orders.getOrderid());
		orders1.setStatus("Y");
		ordersDAO.insertUpdateOrders(orders1);
		
	}
	return "ThankPage";
}

	
}








