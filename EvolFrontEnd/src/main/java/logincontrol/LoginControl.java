package logincontrol;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import model.Login;

/**
 * Servlet implementation class LoginControl
 */
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("uname");
		String password=request.getParameter("passwd");
		
		Login loginobj=new Login();
		loginobj.setLogin(username);
		loginobj.setPassword(password);
		
		try
		{
		
		LoginDAO loginDAO=new LoginDAO();
		
			
		if(loginDAO.isValid(loginobj))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("Success.jsp");
			dispatch.forward(request,response);
		}
		else
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("Failure.jsp");
			dispatch.forward(request,response);
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}


	}


