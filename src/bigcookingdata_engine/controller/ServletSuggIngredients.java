package bigcookingdata_engine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.engine.recommender.Recommender;

/**
 * Servlet implementation class ServletSuggIngredients
 */
@WebServlet("/ServletSuggIngredients")
public class ServletSuggIngredients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSuggIngredients() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <Recipe> listRec = new ArrayList<>();
		
		Recommender r = new Recommender();
		
		listRec = r.getRecipes_recommended();
		
		request.setAttribute("rec", listRec);
		
		request.getRequestDispatcher("SuggestionIng.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("SuggestionIng.jsp");
		doGet(request, response);
	}

}
