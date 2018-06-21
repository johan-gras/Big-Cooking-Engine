package bigcookingdata_engine.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

@WebServlet("/CreatUser")
public class CreatUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreatUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("CreateUser.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("first_name");
		String prenom = request.getParameter("last_name");
		String user_name = request.getParameter("user_name");
		String pass = request.getParameter("user_password");
		String poids = request.getParameter("poid");
		String email = request.getParameter("email");
		
		try {
			Neo4J.createUser(user_name, email, pass, poids);
			System.out.println("user created !!");
			Session.getInstance().connection( email,pass );
			request.getRequestDispatcher("/ServeltRateIngred").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name + prenom + user_name + pass + poids + email );
		//request.getRequestDispatcher("SuggestionIng.jsp").forward(request, response);

	}

}
