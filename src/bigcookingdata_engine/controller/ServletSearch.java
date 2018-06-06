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
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//cr�ation de l'objet recette
		int[] ing = new int[2];

		Recipe r = new Recipe( "timeTotal", "categorie", 7, 7, "timeCooking", 8,
                "timePrepa", "title", 7, 7,7, null,null, null );
		
		//Intialisation d'une array liste pour la récuprération des données
		ArrayList<Recipe> listRecipe = new ArrayList<>();
				
		SerchEngin se = new SerchEngin();
		
		//recupération des inforamtions de la bare de recheche
		String keyWord = request.getParameter("searchWord");
		listRecipe = se.getRecipe(keyWord);
		
		request.setAttribute("recettes", listRecipe);
		
		//envoie des informations  (in faut appuier sur recherche pour envoyer les infos)
		request.getRequestDispatcher("index.jsp").forward(request, response);


	}

}
