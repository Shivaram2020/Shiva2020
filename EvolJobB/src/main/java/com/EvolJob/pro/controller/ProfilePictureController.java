package com.EvolJob.pro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.EvolJob.pro.model.ProfilePicture;
import com.EvolJob.pro.model.User;
import com.EvolJob.pro.dao.ProfilePictureDao;
import com.EvolJob.pro.model.Error;
@Controller
public class ProfilePictureController {
	@Autowired
private ProfilePictureDao profilePictureDao;
	@RequestMapping(value="/uploadprofilepic",method=RequestMethod.POST)
public ResponseEntity<?> uploadProfilePicture(@RequestParam CommonsMultipartFile image,HttpSession session){
		if(session.getAttribute("username")==null)		{
		    Error error=new Error(3,"UnAuthorized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	} 
		String username=(String)session.getAttribute("username");
	ProfilePicture profilePicture=new ProfilePicture();
	profilePicture.setUsername(username);
	profilePicture.setImage(image.getBytes());
	try
	{
	profilePictureDao.save(profilePicture);
	return new ResponseEntity<ProfilePicture>(profilePicture,HttpStatus.OK);
	}
	
	catch(Exception e)
	{
		Error error=new Error(7,"Unable to insert job details " + e.getMessage());
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}
	
	//http://localhost:8080/backend_project2/getimage/admin
	@RequestMapping(value="/getimage/{username}", method=RequestMethod.GET)
	public @ResponseBody byte[] getProfilePic(@PathVariable String username){
		
		
		
			ProfilePicture profilePic=profilePictureDao.getProfilePic(username);
			if(profilePic==null)
				return null;
			
		
				return profilePic.getImage();
		
		
}
}


