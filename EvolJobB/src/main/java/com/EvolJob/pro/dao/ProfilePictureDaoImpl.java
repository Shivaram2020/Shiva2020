package com.EvolJob.pro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EvolJob.pro.model.CoverPicture;
import com.EvolJob.pro.model.ProfilePicture;



@Repository
public class ProfilePictureDaoImpl implements ProfilePictureDao{
	
	@Autowired
private SessionFactory sessionFactory;
	public void save(ProfilePicture profilePicture) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
		
	}
	
	public ProfilePicture getProfilePic(String username) {
		Session session=sessionFactory.openSession();
		ProfilePicture profilePic=(ProfilePicture)
		session.get(ProfilePicture.class, username);
		session.close();
		return profilePic;
	}

	@Override
	public void saveCover(CoverPicture profilePicture) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
		
		
	}

	@Override
	public CoverPicture getCoverPic(String username) {
		Session session=sessionFactory.openSession();
		CoverPicture profilePic=(CoverPicture)
		session.get(CoverPicture.class, username);
		session.close();
		return profilePic;
		
	}

}