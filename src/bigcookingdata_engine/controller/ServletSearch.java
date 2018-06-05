package bigcookingdata_engine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.database.SerchEngin;;

/**
 * Servlet implementation class ServletSearch
 */
@WebServlet("/ServletSearch")
public class ServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public ServletSearch() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SerchEngin se = new SerchEngin();
		ArrayList<Recipe> recipeliste = new ArrayList<>();
		Recipe r = new Recipe( "timeTotal", "categorie", 7, 7, "timeCooking", 8,
                "timePrepa", "title", 7, 7 ,7, null, null, null );
		recipeliste.add(r);
		recipeliste = se.getRecipe("fromage");
		System.out.println("nb recettes :"+recipeliste.size());
		request.setAttribute("recettes", recipeliste);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//création de l'objet recette
		int[] ing = new int[2];

		Recipe r = new Recipe( "timeTotal", "categorie", 7, 7, "timeCooking", 8,
                "timePrepa", "title", 7, 7,7, null,null, null );
		
		//on affécte l'objet pour le requete
		request.setAttribute("recette", r);
		//envoie des informations  (in faut appuier sur recherche pour envoyer les infos)
		
		request.getRequestDispatcher("index.jsp").forward(request, response);


	}

}
