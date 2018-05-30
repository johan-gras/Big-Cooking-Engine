package bigcookingdata_engine.database;

import java.util.ArrayList;

import org.json.JSONObject;

import bigcookingdata_engine.business.data.recipe.Recipe;

/**
 * Classe pour différente methodes pour le moteur de recherche
 * 
 * @author sofiane-hamiti
 *
 */
public class SerchEngin {

	private static java.sql.Connection conn = null;

	public  ArrayList<Recipe> getRecipe(String keyWord){
		
		ArrayList<Recipe> result = new ArrayList<>();
		
		//connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		
		//la requête
		String req = "MATCH (r:Recipe) where r.title CONTAINS '"+keyWord+"' return r";
		try {
			java.sql.Statement stmt = conn.createStatement(); 
			java.sql.ResultSet rs  = stmt.executeQuery(req);
			while(rs.next()) {
				String r = rs.getString(1);
				//System.out.println(r);
				JSONObject json = new JSONObject(r);
				Recipe recipe = new Recipe();
				recipe.setCategorie((String) json.getString("categorie").replaceAll(",","" ).replaceAll("[\\[\\]]", "").replaceAll("'", ""));
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
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

//public static void main(String[] args) {
//	ArrayList<Recipe> r = new ArrayList<>();
//	r= getRecipe("fromage");
//	System.out.println(r.size());
//	
//}
	
}
