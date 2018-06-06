package bigcookingdata_engine.database;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InterruptedNamingException;

import org.json.JSONException;
import org.json.JSONObject;
import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.data.recipe.Step;
import bigcookingdata_engine.business.data.recipe.Utensil;
import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.database.*;


/**
 * Classe pour différente methodes pour le moteur de recherche
 * 
 * @author sofiane-hamiti
 *
 */
public class SerchEngin {

	public ArrayList<Recipe> getRecipe(String keyWord) {
		java.sql.Connection conn = null;
		ArrayList<Recipe> result = new ArrayList<>();

		// connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// la requête
		String req = "MATCH (r:Recipe) where r.title CONTAINS '" + keyWord + "' return r limit 100";
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

				stepList = n.getSteps(json.getInt("idRecipe"));
				utensilList = n.getUtensil(json.getInt("idRecipe"));
				ingList = n.getIngreds(json.getInt("idRecipe"))	;
				
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
				recipe.setIdRecipe(json.getInt("idRecipe"));
				recipe.setSteps(stepList);
				recipe.setUtensils(utensilList);
				recipe.setIngredients(ingList);
				result.add(recipe);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

//	public static void main(String[] args) {
//		ArrayList<Ingredient> li = new ArrayList<>();
//		Neo4J n = new Neo4J();
//		try {
//			li = n.getIngreds(45);
//			System.out.println("Size of ing" + li.size());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
