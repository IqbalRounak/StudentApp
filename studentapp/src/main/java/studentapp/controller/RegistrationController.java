package studentapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentapp.model.DAOService;
import studentapp.model.DAOServiceImpl;


@WebServlet("/reg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			DAOService daoService = new DAOServiceImpl();
			daoService.connectToDB();
			daoService.saveReg(name,city,email,mobile);
			
			request.setAttribute("msg", "registration saved");
			
			RequestDispatcher rd = request.getRequestDispatcher("new_reg.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
