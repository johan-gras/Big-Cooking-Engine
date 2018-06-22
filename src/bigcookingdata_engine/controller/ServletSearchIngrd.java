package bigcookingdata_engine.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

/**
 * Servlet implementation class ServletSearchIngrd
 */
@WebServlet("/ServletSearchIngrd")
public class ServletSearchIngrd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("ServletFrigo").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ingrdKey = request.getParameter("ingrdKey");
		int idRecip = Neo4J.getIngeByName(ingrdKey);
		try {
			Neo4J.addIngredientToFrigo(Integer.toString(idRecip), Session.getInstance().getUser().getMail());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ServletFrigo");
		
	}
	

}
