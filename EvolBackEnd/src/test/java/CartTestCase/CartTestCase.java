package CartTestCase;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.Evol.dao.CartDAO;
import com.pro.Evol.model.Cart;

public class CartTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext();
		
		context1.scan("com.pro.Evol");
		
		context1.refresh();
		
		// Inserting a Cart Object.
		CartDAO cartDAO=(CartDAO)context1.getBean("cartDAO");
		
		//Insertion TestCase
		
		/*Cart cart=new Cart();
		
		cart.setUsername("shiva");
		cart.setProductname("audi");
		cart.setStatus("N");
		cartDAO.insertUpdateCart(cart);		
		System.out.println("Cart Inserted");*/
		
		//Retrieval TestCase
		
		/*Cart Cart=cartDAO.getCart(1);
		System.out.println("Cart Name:"+Cart.getUsername());
		System.out.println("Cart Description:"+Cart.getProductname());*/
		
		//Deletion TestCase
		/*Cart Cart=CartDAO.getCart(1);
		CartDAO.deleteCart(Cart);
		System.out.println("The Cart Deleted");*/
		
		//Retrieving the Data
		
		/*List<Cart> list=cartDAO.getCartDetails("shiva");
		
		for(Cart cart:list)
		{
			System.out.println(cart.getCartitemid()+":"+cart.getUsername());
		}*/
		
		//Update the Cart
		/*Cart cart=cartDAO.getCart(2);
		cart.setCartid(1001);
		cartDAO.insertUpdateCart(cart);
		System.out.println("The Cart Updated");*/
		
	}
}


