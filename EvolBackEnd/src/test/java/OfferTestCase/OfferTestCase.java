package OfferTestCase;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.Evol.dao.OfferDAO;
import com.pro.Evol.model.Offer;

public class OfferTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext();
		
		
		context1.scan("com.pro.Evol");
		
		context1.refresh();
		
		// Inserting a Offer Object.
		OfferDAO offerDAO=(OfferDAO)context1.getBean("offerDAO");
		
		//Insertion TestCase
		
		/*Offer offer=new Offer();
		
		offer.setOffname("WIFIMobile");
		offer.setOffdesc("This Mobile is WIFI Enabled. You can Enjoy");

		offerDAO.insertUpdateOffer(offer);		
		System.out.println("Offer Inserted");*/
		
		//Retrieval TestCase
		
		/*Offer offer=offerDAO.getOffer(1);
		System.out.println("Offer Name:"+offer.getOffname());
		System.out.println("Offer Description:"+offer.getOffdesc());*/
		
		//Deletion TestCase
		/*Offer offer=offerDAO.getOffer(1);
		offerDAO.deleteOffer(offer);
		System.out.println("The Offer Deleted");*/
		
		//Retrieving the Data
		
		/*List<Offer> list=offerDAO.getOfferDetails();
		
		for(Offer offer:list)
		{
			System.out.println(offer.getOffid()+":"+offer.getOffname()+":"+offer.getOffdesc());
		}*/
		
		//Update the Offer
		/*Offer offer=offerDAO.getOffer(1);
		offer.setOffname("WifiEnMobile1");
		offerDAO.insertUpdateOffer(offer);
		System.out.println("The Offer Updated");*/
		
	}
}



