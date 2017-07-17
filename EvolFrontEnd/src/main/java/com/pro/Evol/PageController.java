package com.pro.Evol;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pro.Evol.dao.CartDAO;
import com.pro.Evol.dao.CategoryDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.model.Cart;
import com.pro.Evol.model.Product;


@Controller
public class PageController {
	
	@Autowired
		CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	
	@RequestMapping("/Login")
	public String Login()
	{
		
		
		return "Login";
}
	
	@RequestMapping("/AboutUs")
	public String AboutUs()
	{
		
		
		return "AboutUs";
}
	@RequestMapping("/ContactUs")
	public String ContactUs()
	{
		
		
		return "ContactUs";
}
	
	
	
	@RequestMapping("/LoginError")
	public String LoginError()
	{
		
		
		return "LoginError";
}
	@RequestMapping("/signup")
	public String signup()
	{
		
		
		return "signuppage";
	}
	
	
	@RequestMapping("/Warning")
	public String warning()
	{
		
		
		return "Warning";
}
	
	
	@RequestMapping("/Book")
	public String Book(Model m,HttpSession session)
	{
		String username=(String) session.getAttribute("username");
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
	

		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Book";
	}
	
	@RequestMapping("/Music")
	public String category(Model m,HttpSession session)
	{
		String username=(String) session.getAttribute("username");
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Music";
	}
	
	
	@RequestMapping("/Painting")
	public String Painting(Model m,HttpSession session)
	{
		
		
		String username=(String) session.getAttribute("username");
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
	
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Painting";
	}
	
	
	@RequestMapping("/Photography")
	public String Photography(Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	
		return "Photography";
	}
	
	
	
	@RequestMapping("/Game")
	public String Game(Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartlist)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
	
		Product<MultipartFile> product=new Product<MultipartFile>();
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "Game";
	}
	
	
	
	
	
	
    }


