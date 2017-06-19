package ProductTestCase;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.model.Product;

public class ProductTestCase {
	public static void main(String arg[])
	{
		
	
AnnotationConfigApplicationContext context3=new AnnotationConfigApplicationContext();
	
context3.scan("com.pro.Evol");

context3.refresh();
      


	
	// Inserting a Category Object.
	ProductDAO productDAO=(ProductDAO)context3.getBean("productDAO");
	
	//Insertion TestCase
	
	/*Product product=new Product();
	
	product.setProdname("WIFIMobile");
	product.setCatid(12);
       product.setSuppid(10);
       product.setQuantity(11);
       product.setPrice(10000);
        product.setProddesc("execellent 2020 Crownyear");

	productDAO.insertUpdateProduct(product);		
	System.out.println("Product Inserted");*/
	
	//Retrieval TestCase
	
	/*Product product=productDAO.getProduct(1);
	System.out.println("Category Name:"+product.getProdname());
	System.out.println("Category 2020:"+product.getProddesc());*/
	
	//Deletion TestCase
	/*Product product=productDAO.getProduct(1);
	productDAO.deleteProduct(product);
	System.out.println("The Product Deleted");*/
	
	//Retrieving the Data
	
	/*List<Product> list=productDAO.getProductDetails();
	
	for(Product product:list)
	{
		System.out.println(product.getSuppid()+":"+product.getProdname()+":"+product.getCatid());
	}
	*/
	//Update the Category
	/*Product product=productDAO.getProduct(1);
	product.setProdname("SwS");
	productDAO.insertUpdateProduct(product);
	System.out.println("The Product Updated");*/
	
}

}




