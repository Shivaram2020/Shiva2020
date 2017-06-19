package CategoryTestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.Evol.dao.CategoryDAO;
import com.pro.Evol.model.Category;

public class CategoryTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext();
		
		context1.scan("com.pro.Evol");
		
		context1.refresh();
		
		// Inserting a Category Object.
		CategoryDAO categoryDAO=(CategoryDAO)context1.getBean("categoryDAO");
		
		//Insertion TestCase
		
		/*Category category=new Category();
		
		category.setCatname("WIFIMobile");
		category.setCatdesc("This Mobile is WIFI Enabled. You can Enjoy");

		categoryDAO.insertUpdateCategory(category);		
		System.out.println("Category Inserted");*/
		
		//Retrieval TestCase
		
		/*Category category=categoryDAO.getCategory(2);
		System.out.println("Category Name:"+category.getCatname());
		System.out.println("Category Description:"+category.getCatdesc());*/
		
		//Deletion TestCase
		/*Category category=categoryDAO.getCategory(1);
		categoryDAO.deleteCategory(category);
		System.out.println("The Category Deleted");*/
		
		//Retrieving the Data
		
		/*List<Category> list=categoryDAO.getCategoryDetails();
		
		for(Category category:list)
		{
			System.out.println(category.getCatid()+":"+category.getCatname()+":"+category.getCatdesc());
		}*/
		
		//Update the Category
		/*Category category=categoryDAO.getCategory(3);
		category.setCatname("WifiEnMobile");
		categoryDAO.insertUpdateCategory(category);
		System.out.println("The Category Updated");*/
		
	}
}


