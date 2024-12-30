package studentapp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentapp.model.DAOService;
import studentapp.model.DAOServiceImpl;


@WebServlet("/delete")
public class DeleteReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteReg() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			
			DAOService daoService = new DAOServiceImpl();
			daoService.connectToDB();
			daoService.deleteReg(email);
			
			ResultSet result = daoService.getAllReg();
			
			request.setAttribute("result", result);
			request.setAttribute("msg", "registration deleted of email : "+email);
			
			RequestDispatcher rd = request.getRequestDispatcher("listall.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
