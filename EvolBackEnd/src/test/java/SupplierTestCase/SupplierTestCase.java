package SupplierTestCase;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.Evol.dao.SupplierDAO;
import com.pro.Evol.model.Supplier;

public class SupplierTestCase {
	public static void main(String arg[])
	{
	AnnotationConfigApplicationContext context2=new AnnotationConfigApplicationContext();
	
	context2.scan("com.pro.Evol");
	
	context2.refresh();
	
	// Inserting a Category Object.
	SupplierDAO supplierDAO=(SupplierDAO)context2.getBean("supplierDAO");
	
	//Insertion TestCase
	
	/*Supplier supplier=new Supplier();
	
	supplier.setSuppname("WIFIMobile");
	supplier.setAddress("This Mobile is WIFI Enabled. You can Enjoy");

	supplierDAO.insertUpdateSupplier(supplier);		
	System.out.println("supplier Inserted");*/
	
	//Retrieval TestCase
	
	/*Supplier supplier=supplierDAO.getSupplier(3);
	System.out.println("Category Name:"+supplier.getSuppname());
	System.out.println("Category Address:"+supplier.getAddress());*/
	
	//Deletion TestCase
	/*Supplier supplier=supplierDAO.getSupplier(3);
	supplierDAO.deleteSupplier(supplier);
	System.out.println("The Supplier Deleted");*/
	
	//Retrieving the Data
	
	/*List<Supplier> list=supplierDAO.getSupplierDetails();
	
	for(Supplier supplier:list)
	{
		System.out.println(supplier.getSuppid()+":"+supplier.getSuppname()+":"+supplier.getAddress());
	}*/
	
	//Update the Category
	/*Supplier supplier=supplierDAO.getSupplier(3);
	supplier.setSuppname("WifiEnMobile");
	supplierDAO.insertUpdateSupplier(supplier);
	System.out.println("The supplier Updated");*/
	
}

}
