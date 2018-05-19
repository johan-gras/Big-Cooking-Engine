package bigcookingdata_engine.db_connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.*;
import org.parboiled.common.ImmutableList;

import bigcookingdata_engine.business.data.recipe.*;;

public abstract class ConnNeo4jJDBC implements java.sql.Connection {

	private static java.sql.Connection conn = null;

	public static void main(String[] args) throws Exception {
		ArrayList<Recipe> al = new ArrayList<>();
		// ICI VOUS POUVEZ METTRE COMBIEN VOUS VOULEZ D INGREDIENT
		al = getRecipesByIngred("","tomates");
		System.out.println(al.size());
		// getStepByIdRecip(498);
		// for(int i=0; i<al.size();i++){
		// System.out.println(al.get(i).title);
		// }
		// createUser("sofiane","hami",70);
		// System.out.println("begin");
		// userDISLike("sofiane","hami","rhubarbes",6);
		// System.out.println("end");

		getUtensilByRecipId(10);
	}

	public static ArrayList<Recipe> getRecipesByIngred(String... ingred) throws SQLException, JSONException {
		List<String> ing = ImmutableList.of(ingred);

		ArrayList<Recipe> al = new ArrayList<>();

		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			String q1 = "MATCH (r:Recipe)-[:IS_COMPOSED_TO]->";
			String q4 = " RETURN r";

			String q2 = "";
			String q3 = "";

			if (ing.size() == 1)
				q2 = "(Ingredient{nameIngred : '" + ing + "'})";

			else if (ing.size() > 1) {
				for (String i : ing) {
					q3 += "(" + i.replaceAll(" ", "") + ":Ingredient{nameIngred : '" + i + "'}),";
				}
			}

			// System.out.println(q1+q2+q3.substring(0, q3.length() - 1)+q4);

			java.sql.ResultSet rs = stmt.executeQuery(q1 + q2 + q3.substring(0, q3.length() - 1) + q4);
			while (rs.next()) {
				String result = rs.getString(1);
				// System.out.println(result);
				JSONObject json = new JSONObject(result);
				Recipe recipe = new Recipe();
				recipe.setTimeTotal(json.getString("timetotal"));
				recipe.setCategorie((json.getString("categorie").split(",")));
				recipe.setLevel(json.getInt("level"));
				recipe.setNbOfPerson(json.getInt("number_of_person"));
				recipe.setTimeCooking(json.getString("timecooking"));
				recipe.setRating((float) json.getDouble("rating"));
				recipe.setTimePrepa(json.getString("timeprepa"));
				recipe.setTitle(json.getString("title"));
				recipe.setIdRecipe(json.getInt("idRecipe"));
				recipe.setBudget(json.getInt("budget"));
				al.add(recipe);

			}
		}
		return al;
	}

	public static ArrayList<Step> getStepByIdRecip(int idRecip) throws SQLException, JSONException {
		ArrayList<Step> al = new ArrayList<>();
		Step step = new Step();
		// Connect
		java.sql.Connection con = DriverManager
				.getConnection("jdbc:neo4j:http://localhost:7474/?user=neo4j,password=password");

		// Querying
		try (java.sql.Statement stmt = con.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery("MATCH (r:Recipe{idRecipe:'" + idRecip
					+ "'})-[:HAS_STEP]->(s:Step) RETURN distinct s.numberStep,s.descStep order by toInt(s.numberStep)");
			while (rs.next()) {
				step.setNumberStep(rs.getInt(1));
				step.setDescStep(rs.getString(2));
				System.out.println(rs.getString(2));
				al.add(step);
			}
		}
		return al;

	}

	public static ArrayList<Utensil> getUtensilByRecipId(int idRecip) throws SQLException, JSONException {

		ArrayList<Utensil> al = new ArrayList<>();
		Utensil utensil = new Utensil();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt
					.executeQuery("match (r:Recipe{idRecipe:'" + idRecip + "'})-[:USE]->(u:Utensil)" + "return u");
			while (rs.next()) {
				String result = rs.getString(1);
				JSONObject json = new JSONObject(result);
				System.out.println(json.getString("nameUtensil"));
				al.add(utensil);
			}
		}
		return al;

	}

	public static void createUser(String name, String surname, int weight) throws SQLException {
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {

			java.sql.ResultSet rs = stmt.executeQuery(
					"CREATE (n:User { nameUser: '" + name + "', surname: '" + surname + "',weight:'" + weight + "' })");

		}
	}

	public static void userLike(String name, String surname, String ingredient, int score) throws SQLException {
		String query = "MATCH (a:User),(b:Ingredient{nameIngred:'" + ingredient + "'})" + "WHERE a.nameUser = '" + name
				+ "' AND a.surname='" + surname + "'" + "CREATE (a)-[r:LIKE{score:'" + score + "'}]->(b);";
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {

			java.sql.ResultSet rs = stmt.executeQuery(query);

		}
	}

}