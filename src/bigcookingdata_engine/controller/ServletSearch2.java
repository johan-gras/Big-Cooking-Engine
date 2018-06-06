package bigcookingdata_engine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.database.SingletonConnectionNeo4j;

/**
 * Servlet implementation class ServletSearch2
 */
@WebServlet("/ServletSearch2")
public class ServletSearch2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyWord = "fromage";

		java.sql.Connection conn = null;
		ArrayList<Recipe> result = new ArrayList<>();

		// connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// la requête
		String req = "MATCH (r:Recipe) where r.title CONTAINS '" + keyWord + "' return r";
		try {
			java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery(req);
			while (rs.next()) {
				String r = rs.getString(1);
				// System.out.println(r);
				JSONObject json = new JSONObject(r);
				Recipe recipe = new Recipe();
				recipe.setCategorie((String) json.getString("categorie").replaceAll(",", "").replaceAll("[\\[\\]]", "")
						.replaceAll("'", ""));
				recipe.setLevel(json.getInt("level"));
				recipe.setNbOfPerson(json.getInt("number_of_person"));
				recipe.setTimeCooking(json.getString("timecooking"));
				recipe.setRating((float) json.getDouble("rating"));
				recipe.setTimePrepa(json.getString("timeprepa"));
				recipe.setTitle(json.getString("title"));
				recipe.setIdRecipe(json.getInt("idRecipe"));
				recipe.setBudget(json.getInt("budget"));
				result.add(recipe);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("taille" + result.size());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyWord = "fromage";

		java.sql.Connection conn = null;
		ArrayList<Recipe> result = new ArrayList<>();

		// connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// la requête
		String req = "MATCH (r:Recipe) where r.title CONTAINS '" + keyWord + "' return r";
		try {
			java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery(req);
			while (rs.next()) {
				String r = rs.getString(1);
				// System.out.println(r);
				JSONObject json = new JSONObject(r);
				Recipe recipe = new Recipe();
				recipe.setCategorie((String) json.getString("categorie").replaceAll(",", "").replaceAll("[\\[\\]]", "")
						.replaceAll("'", ""));
				recipe.setLevel(json.getInt("level"));
				recipe.setNbOfPerson(json.getInt("number_of_person"));
				recipe.setTimeCooking(json.getString("timecooking"));
				recipe.setRating((float) json.getDouble("rating"));
				recipe.setTimePrepa(json.getString("timeprepa"));
				recipe.setTitle(json.getString("title"));
				recipe.setIdRecipe(json.getInt("idRecipe"));
				recipe.setBudget(json.getInt("budget"));
				result.add(recipe);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("taille" + result.size());
		doGet(request, response);
	}

}
