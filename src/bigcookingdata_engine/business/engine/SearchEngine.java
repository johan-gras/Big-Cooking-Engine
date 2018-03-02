package bigcookingdata_engine.business.engine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.db_connection.SingletonConnection;

/**
 * class implement methods for engine search
 * 
 * @author sofiane-hamiti
 *
 */
public class SearchEngine {

	/**
	 * parameters to connection on the data base
	 */
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	public static ResultSet rs = null;

	/**
	 * method to search by ID
	 * 
	 * @param id
	 *            ID of the recipe
	 */
	public Recipe getRecipeById(int id) {
		Recipe recipe = new Recipe();
		String query = "Select * from recipe where id=" + id;
		try {
			SingletonConnection sc = SingletonConnection.getDbConnection();
			conn = sc.conn;
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				recipe.setId(id);
				recipe.setLevel(rs.getInt("level"));
				recipe.setNumberOfPersons(rs.getString("number_of_person"));
				recipe.setRating(rs.getString("rating"));
				recipe.setTimeCooking(rs.getString(8));
				recipe.setTimePreatation(rs.getString(8));
				recipe.setTimeTotal(rs.getString(6));
				recipe.setTitle(rs.getString(2));
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();

		}
		return recipe;

	}

	/**
	 * Method use the full text searching on the database
	 * 
	 * @param key
	 *            the key word
	 * @return
	 */
	public ArrayList<Recipe> searcherEngine(String key) {
		ArrayList<Recipe> listRecipe = new ArrayList<>();
		String query = "SELECT *, MATCH(title) AGAINST('" + key + "') AS score FROM recipe WHERE MATCH(title) AGAINST('"
				+ key + "')  ORDER BY score DESC";
		try {
			SingletonConnection sc = SingletonConnection.getDbConnection();
			conn = sc.conn;
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(rs.getInt(1));
				recipe.setLevel(rs.getInt("level"));
				recipe.setNumberOfPersons(rs.getString("number_of_person"));
				recipe.setRating(rs.getString("rating"));
				recipe.setTimeCooking(rs.getString(8));
				recipe.setTimePreatation(rs.getString(8));
				recipe.setTimeTotal(rs.getString(6));
				recipe.setTitle(rs.getString(2));
				listRecipe.add(recipe);
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}

		return listRecipe;
	}

	/**
	 * search recipe by ingredients
	 * 
	 * @param keyWords
	 */
	public void getRecipeByIngredients(ArrayList<String> keyWords) {

	}

	/**
	 * search recipe on a interval of time
	 * 
	 * @param a
	 *            time a
	 * @param b
	 *            time b
	 */
	public void getRecipeByTimeInterval(String a, String b) {

	}

}
