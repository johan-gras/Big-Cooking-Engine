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

import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.business.engine.recommender.Recommender;
import bigcookingdata_engine.database.Neo4J;

/**
 * Servlet implementation class RecommendationIndex
 */
@WebServlet("/RecommendationIndex")
public class RecommendationIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recommendation par contenu frigo
		ArrayList<Ingredient> ingreFrigo = new ArrayList<>();
		ArrayList<String> ingredFrigo_String = new ArrayList<>();
		ArrayList<Recipe> recipeFrigo = new ArrayList<>();
		ArrayList<Ingredient> listeIngredFrigo = new ArrayList<>();
		try {

			ingreFrigo = Neo4J.getIngreFromFridge(Session.getInstance().getUser().getMail());
			for (int i = 0; i < ingreFrigo.size(); i++) {
				ingredFrigo_String.add(ingreFrigo.get(i).getName());
			}
			recipeFrigo = Neo4J.getRecipeFromFrigo(ingredFrigo_String);
			for (int i = 0; i < recipeFrigo.size(); i++) {
				int idrecip = recipeFrigo.get(i).getIdRecipe();
				recipeFrigo.get(i).setIngredients(Neo4J.getIngredientByIdRecipe(idrecip));
				recipeFrigo.get(i).setSteps(Neo4J.getSteps(idrecip));
				recipeFrigo.get(i).setUtensils(Neo4J.getUtensil(idrecip));

			}
			ArrayList<Recipe> recipesIngred = new ArrayList<>();

			recipesIngred = Session.getInstance().getRecommender().getRecoByIngred();

			ArrayList<Recipe> recipesCluster = new ArrayList<>();
			recipesCluster = Session.getInstance().getRecommender().getRecoByCluster();


			ArrayList<Recipe> superRecipe = new ArrayList<>();
			
			superRecipe = Session.getInstance().getRecommender().getRecoSuper();
			
			ArrayList<Recipe> recipeUser = new ArrayList<>();
			recipeUser = Session.getInstance().getRecommender().getRecoByUser();
			System.out.println("ufcvghh"+recipeUser);
			
			
			request.setAttribute("ruser", recipeUser );
			request.setAttribute("listingredFrigo", listeIngredFrigo);
			request.setAttribute("rfrigo", recipeFrigo);
			request.setAttribute("rcluster", recipesCluster);
			request.setAttribute("ringred", recipesIngred);
			request.setAttribute("rsuper", superRecipe);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// les recettes:

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
