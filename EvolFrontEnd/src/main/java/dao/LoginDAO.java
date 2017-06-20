package dao;


import model.*;

import java.sql.*;
public class LoginDAO 
{
	Connection conn;
	public LoginDAO()throws Exception
	{
		Class.forName("org.h2.Driver");
		conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","shiva","143");
	}
	
	public boolean isValid(Login loginobj)throws Exception
	{
		PreparedStatement psmt=conn.prepareStatement("select * from UserDetails where username=? and password=?");
		
		psmt.setString(1,loginobj.getLogin().trim());
		psmt.setString(2, loginobj.getPassword().trim());
		
		ResultSet rs=psmt.executeQuery();
		
		if(rs.next())
			return true;
		else
			return false;
	}
}

