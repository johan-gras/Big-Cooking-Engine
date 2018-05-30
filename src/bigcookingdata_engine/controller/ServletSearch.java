package bigcookingdata_engine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//création de l'objet recette
		Recipe r = new Recipe("12", "Vegan", 1, 1, "1h", 5, "10min", "boeuf", 2326, 12);
		//on affécte l'objet pour le requete
		request.setAttribute("recette", r);
		//envoie des informations  (in faut appuier sur recherche pour envoyer les infos)
		request.getRequestDispatcher("index.jsp").forward(request, response);


	}

}
