package com.EvolJob.pro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.EvolJob.pro.dao.FriendDao;
import com.EvolJob.pro.dao.UserDao;
import com.EvolJob.pro.model.User;
import com.EvolJob.pro.model.BlogPost;
import com.EvolJob.pro.model.Error;
import com.EvolJob.pro.model.Friend;




@Controller
public class FriendController {
	
@Autowired
private FriendDao friendDao;



@Autowired
private UserDao userdao;

	
@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
public ResponseEntity<?> getAllUsers(HttpSession session){
	
	
	
	if(session.getAttribute("username")==null){
		Error error=new Error(1,"Unauthroized user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	
	String username=(String)session.getAttribute("username");
	List<User> users=friendDao.getSuggestedUsers(username);
	return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	
}
	
@RequestMapping(value="/friendRequest/{to}",method=RequestMethod.PUT)
public ResponseEntity<?> friendRequest(@PathVariable String to,HttpSession session){
		
	
		if(session.getAttribute("username")==null){
			Error error=new Error(1,"Unauthroized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		String username=(String)session.getAttribute("username");
		
		/*Friend friend=new Friend();
		friend.setFrom(username);
		friend.setTo(to);
		friend.setStatus('P');*/
		
		friendDao.friendRequest(username,to);
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
}
	
@RequestMapping(value="/pendingRequests",method=RequestMethod.GET)
public ResponseEntity<?> pendingRequests(HttpSession session){

	
		
		if(session.getAttribute("username")==null){
			Error error=new Error(1,"Unauthroized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		String username=(String)session.getAttribute("username");
		List<Friend> pendingRequests= friendDao.pendingRequests(username);
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
		
}
	
@RequestMapping(value="/updatependingrequest/{from}/{status}",method=RequestMethod.PUT)
public ResponseEntity<?> updatePendingRequest(
		@PathVariable String from , @PathVariable char status,HttpSession session){

	
		if(session.getAttribute("username")==null){
			Error error=new Error(1,"Unauthroized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		String username=(String)session.getAttribute("username");
		friendDao.updatePendingRequest(from,username,status);
		return new ResponseEntity<Void>(HttpStatus.OK);
}
	
@RequestMapping(value="/friendslist",method=RequestMethod.GET)
public ResponseEntity<?> getAllFriends(HttpSession session){

		
		if(session.getAttribute("username")==null){
			Error error=new Error(1,"Unauthroized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		List<Friend> friends=friendDao.listOfFriends(username);
		return new ResponseEntity<List<Friend>>(friends,HttpStatus.OK);
}


@RequestMapping(value="/blockRequests",method=RequestMethod.GET)
public ResponseEntity<?> blockRequests(HttpSession session){

	
		
		if(session.getAttribute("username")==null){
			Error error=new Error(1,"Unauthroized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		String username=(String)session.getAttribute("username");
		List<Friend> blockRequests= friendDao.blockRequests(username);
		return new ResponseEntity<List<Friend>>(blockRequests,HttpStatus.OK);
		
}

@RequestMapping(value="/deleteFriend/{id}",method=RequestMethod.DELETE)
public ResponseEntity<?> deleteFriendRequest(@PathVariable int id,HttpSession session){
	if(session.getAttribute("username")==null){
		Error error=new Error(5,"UnAuthorized User");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401 - 2nd call back func will be executed
	}
	Friend friend=friendDao.getFriendById(id);
	System.out.println(friend.getFrom());
	friendDao.deleteFriendRequest(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);
}

@RequestMapping(value="/following",method=RequestMethod.GET)
public ResponseEntity<?> following(HttpSession session){

	
		
		if(session.getAttribute("username")==null){
			Error error=new Error(1,"Unauthroized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		String username=(String)session.getAttribute("username");
		List<Friend> following= friendDao.following(username);
		return new ResponseEntity<List<Friend>>(following,HttpStatus.OK);
		
}
	
	
}

