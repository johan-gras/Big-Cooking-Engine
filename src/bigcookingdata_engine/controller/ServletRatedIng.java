package bigcookingdata_engine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

/**
 * Servlet implementation class ServletRatedIng
 */
@WebServlet("/ServletRatedIng")
public class ServletRatedIng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Ingredient> listIng = new ArrayList<>();
		String nameSession = Session.getInstance().getUser().getName();
		try {
			System.out.println("Session name: "+ nameSession);
			listIng = Neo4J.getRatingIngred2(nameSession);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = Session.getInstance().getUser().getName();
		request.setAttribute("username", name);
		System.out.println("size preferd ing : "+listIng.size());
		request.setAttribute("ing", listIng);
		request.getRequestDispatcher("prefIngred.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
