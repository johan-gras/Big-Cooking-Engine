package bigcookingdata_engine.database;

import java.util.ArrayList;

import org.json.JSONObject;
import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.data.recipe.Step;
import bigcookingdata_engine.business.data.recipe.Utensil;
import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.database.*;

import bigcookingdata_engine.business.data.recipe.Recipe;

/**
 * Classe pour différente methodes pour le moteur de recherche
 * 
 * @author sofiane-hamiti
 *
 */
public class SerchEngin {

	public  ArrayList<Recipe> getRecipe(String keyWord) {
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
//Ajouter un composant dans la classe Neo4J
//				Neo4J n = new Neo4J();

				// liste des steps
				ArrayList<Step> stepList = new ArrayList<>();

				// liste ustesil
				ArrayList<Utensil> utensilList = new ArrayList<>();

				//liste Ingerdient
				ArrayList<Ingredient> ingList = new ArrayList<>();
				
				// System.out.println(r);
				JSONObject json = new JSONObject(r);
				Recipe recipe = new Recipe();
				//.setCategorie((String) json.getString("categorie").replaceAll(",", "").replaceAll("[\\[\\]]", "")
					//	.replaceAll("'", ""));
				recipe.setLevel(json.getInt("level"));
				recipe.setNbOfPerson(json.getInt("number_of_person"));
				recipe.setTimeCooking(json.getString("timecooking"));
				//recipe.setRating((float) json.getDouble("rating"));
				recipe.setTimePrepa(json.getString("timeprepa"));
				recipe.setTitle(json.getString("title"));
				recipe.setIdRecipe(json.getInt("idRecipe"));
				recipe.setBudget(json.getInt("budget"));
				result.add(recipe);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
/*
	public static void main(String[] args) {
		ArrayList<Recipe> r = new ArrayList<>();
		r = getRecipe("fromage");
		for (int i = 0; i < r.size(); i++) {
			System.out.println(r.get(i).getTitle());

		}
		System.out.println(r.size());

	}
*/
}
