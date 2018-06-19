package bigcookingdata_engine.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.database.Neo4J;

/**
 * Servlet implementation class ServeltRateIngred
 */
@WebServlet("/ServeltRateIngred")
public class ServeltRateIngred extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rate = request.getParameter("param");
		System.out.println(rate);
		Ingredient i = new Ingredient();
//		if (rate=="null"||rate == null) {
//		//int r = Integer.parseInt(rate);
//		System.out.println("premier rate "+r);
//		}
		try {

			i = Neo4J.getRandomIngred();
			System.out.println(i.getName());
			System.out.println(i.getPhoto());
			request.setAttribute("ingred", i);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//	Neo4J.ratingIngred("aa@aa.aa", i.getId(), r);
		request.getRequestDispatcher("SuggestionIng.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rate = request.getParameter("param");
		System.out.println(rate);
		request.getRequestDispatcher("SuggestionIng.jsp").forward(request, response);

	}

}
