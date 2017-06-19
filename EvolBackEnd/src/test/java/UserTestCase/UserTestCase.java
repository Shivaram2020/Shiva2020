package UserTestCase;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.Evol.dao.UserDAO;
import com.pro.Evol.model.UserDetails;

public class UserTestCase {
	public static void main(String arg[])
	{
	AnnotationConfigApplicationContext context3=new AnnotationConfigApplicationContext();
	
	context3.scan("com.pro.Evol");
	
	context3.refresh();
	
	// Inserting a Category Object.
	UserDAO userDAO=(UserDAO)context3.getBean("userDAO");
	
	//Insertion TestCase
	
	/*UserDetails userdetails=new UserDetails();
	
	userdetails.setUsername("Shivaram");
	userdetails.setPassword("SwS-2020");
	userdetails.setEmail("sajdk");
	userdetails.setRole("king");
	userdetails.setMobileno("973294923");
	userdetails.setAddress("This Mobile is WIFI Enabled. You can Enjoy");
	userDAO.insertUpdateUser(userdetails);		
	System.out.println("userdetails Inserted");*/
	
	//Retrieval TestCase
	
	/*UserDetails userdetails=userDAO.getUser("Shivaram");
	System.out.println("Category password:"+userdetails.getPassword());
	System.out.println("Category Role:"+userdetails.getRole());*/
	
	//Deletion TestCase
	/*UserDetails userdetails=userDAO.getUser("Shivaram");
	userDAO.deleteUser(userdetails);
	System.out.println("The user  Deleted");*/
	
	//Retrieving the Data
	
	/*List<UserDetails> list=userDAO.getUserDetails();
	
	for(UserDetails user:list)
	{
		System.out.println(user.getUsername()+":"+user.getMobileno()+":"+user.getAddress()+":"+user.getEmail());
	}*/
	
	//Update the Category
	/*UserDetails user=userDAO.getUser("Shivaram");
	user.setEmail("Shivar.vijay.07@gmail.com");
	userDAO.insertUpdateUser(user);
	System.out.println("The user Updated");*/
	
}


}
