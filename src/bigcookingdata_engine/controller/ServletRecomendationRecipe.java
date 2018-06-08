package bigcookingdata_engine.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.business.engine.recommender.Recommender;
import bigcookingdata_engine.database.Neo4J;

/**
 * Servlet implementation class ServletRecomendationRecipe
 */
@WebServlet("/ServletRecomendationRecipe")
public class ServletRecomendationRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRecomendationRecipe() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	    try {
			Neo4J.createUser("aa@aa.aa", "a", "a");
			Neo4J.ratingIngred("aa@aa.aa", 2, 10);
	        Neo4J.ratingIngred("aa@aa.aa", 3, 10);
	        Neo4J.ratingIngred("aa@aa.aa", 4, 10);
	        Neo4J.ratingCluster("aa@aa.aa", 1, 70);
	        Neo4J.ratingCluster("aa@aa.aa", 2, 30);
	        Neo4J.ratingCluster("aa@aa.aa", 3, 20);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

		Session.getInstance().connection("aa@aa.aa", "a");

		Recommender reco = new Recommender();
		
		reco.recommend();
		
		ArrayList<Recipe> li = new ArrayList<>();
		
		li = reco.getRecipes_recommended();

		System.out.println("nb Recettes recommendé " + li.size());
		
		
		request.setAttribute("rec", li);

		request.getRequestDispatcher("RecommendedRcipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("RecommendedRcipe.jsp").forward(request, response);
		doGet(request, response);
	}

}
