package bigcookingdata_engine.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.data.recipe.Step;
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
		
	    
		//Session.getInstance().connection("aa@aa.aa", "a");
		System.out.println("ma session "+Session.getInstance().getUser().getName());
		Recommender reco = new Recommender();
		ArrayList<Recipe> li = new ArrayList<>();
		li = reco.getRecoSuper();
		
		
		
		System.out.println("nb recette recommendé"+li.size());
		String nameuser=Session.getInstance().getUser().getName();
		
		String name = Session.getInstance().getUser().getName();
		request.setAttribute("username", name);
		request.setAttribute("User", nameuser);
		request.setAttribute("rec", li);
		request.getRequestDispatcher("RecommendedRcipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("index.jsp").forward(request, response);
		doGet(request, response);
	}

}
