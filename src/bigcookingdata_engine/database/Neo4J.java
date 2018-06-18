package bigcookingdata_engine.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bigcookingdata_engine.business.data.user.User;
import org.json.*;
import org.parboiled.common.ImmutableList;

import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.data.recipe.Step;
import bigcookingdata_engine.business.data.recipe.TopIngred;
import bigcookingdata_engine.business.data.recipe.Utensil;

public abstract class Neo4J implements java.sql.Connection {

	private static java.sql.Connection conn = null;

	public static void main(String[] args) throws Exception {
		ArrayList<Recipe> al = new ArrayList<>();
		ArrayList<Utensil> sl = new ArrayList<>();
		//System.out.println("TOP3" + Neo4J.getIngredByTop3("aa@aa.aa"));

		// ICI VOUS POUVEZ METTRE COMBIEN VOUS VOULEZ D INGREDIENT
		// getRecipesByIngred("pommes","bananes");
		// getSteps(10); ok
		// getUtensil(5); ok
		// createUser("sofiane","hami","70"); ok
		// userLike("sofiane","hami","rhubarbes",6); ok
		// getRecipes(i); ok mais il manque les cat�gories
		// getRecipesByIngred(i); ok mais il manque les cat�gories
		// getRecipesByCluster(5); ok mais il manque les cat�gories
		// getIngreds(i); ok
		// ratingIngred("sofiane", 2, 8); ok
		// getRatingIngred("sofiane"); //ok
		// ratingCluster(String name, int id_cluster, int value) : ok
		// getRatingClusters("sofiane"); //: ok

		// getUtensilByRecipId(10);
		// getStepByIdRecip(498);
		// for(int i=0; i<al.size();i++){
		// System.out.println(al.get(i).title);
		// }
		// System.out.println(sl);

		int[] i = { 1 };
		// createUser("aa@aa.aa", "", "a");
		// System.out.println(connection("a", "a"));
		//getSteps(22);
		// createUser("aissam", "aissam@a.com", "aaa");
		// createUser("maxence", "maxence@a.com", "aaa");
		// userLike("aissam", "aissam@a.com", "carottes", 6);
		// createUser("aissam", "aissam@a.com", "aaa");
		// createUser("maxence", "maxence@a.com", "aaa");
		// userLike("aissam", "aissam@a.com", "carottes", 6);
		// System.out.println(connection("a", "a"));
		// getSteps(22);
		// createUser("aa@aa.aa", "", "a");
		// System.out.println(connection("a", "a"));
		getRandomIngred();
	}

	public static ArrayList<Recipe> getRecipesByIngred(String... ingred) throws SQLException, JSONException {
		List<String> ing = ImmutableList.of(ingred);

		ArrayList<Recipe> al = new ArrayList<>();

		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			String match = "MATCH ";
			String q1 = "(r:Recipe)-[:IS_COMPOSED_TO]->";
			String returne = " RETURN r";

			String q2 = "";
			String q3 = "";

			if (ing.size() == 1)
				q2 = "(Ingredient{nameIngred : '" + ing + "'})";

			else if (ing.size() > 1) {
				for (String i : ing) {
					q3 += q1 + "(" + i.replaceAll(" ", "") + ":Ingredient{nameIngred : '" + i + "'}),";
				}
			}

			System.out.println(match + q2 + q3.substring(0, q3.length() - 1) + returne);
			java.sql.ResultSet rs = stmt.executeQuery(match + q2 + q3.substring(0, q3.length() - 1) + returne);
			while (rs.next()) {
				String result = rs.getString(1);
				System.out.println(result);
				JSONObject json = new JSONObject(result);
				Recipe recipe = new Recipe();
				recipe.setTimeTotal(json.getString("timetotal"));
				// erreur ici recipe.setCategorie((String)
				// json.getString("categorie").replaceAll(",",""
				// ).replaceAll("[\\[\\]]", "").replaceAll("'", ""));
				recipe.setLevel(json.getInt("level"));
				recipe.setNbOfPerson(json.getInt("number_of_person"));
				recipe.setTimeCooking(json.getString("timecooking"));
				// recipe.setRating((float) json.getDouble("rating"));
				recipe.setTimePrepa(json.getString("timeprepa"));
				recipe.setTitle(json.getString("title"));
				recipe.setIdRecipe(json.getInt("idRecipe"));
				recipe.setBudget(json.getInt("budget"));
				al.add(recipe);

			}
		}
		return al;
	}

	public static ArrayList<Step> getSteps(int idRecip) throws SQLException, JSONException {
		ArrayList<Step> stepList = new ArrayList<>();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "match (s:Step)-[:IS_STEP]->(:Recipe{idRecipe:'" + idRecip + "'}) return s";
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			// System.out.println(query);
			while (rs.next()) {
				Step step = new Step();
				String result = rs.getString(1);
				JSONObject json = new JSONObject(result);
				step.setIdStep(json.getInt("idStep"));
				step.setNumberStep(json.getInt("numberStep"));
				step.setDescStep(json.getString("detailStep"));
				stepList.add(step);
				// System.out.println(json.getString("detailStep"));
			}
		}
		return stepList;
	}

	/**
	 * récupération des ingrédiant By Id Recette
	 * 
	 * @paraescStepm idRecip
	 * @return
	 * @throws SQLException
	 * @throws JSONException
	 */
	public static ArrayList<Ingredient> getIngredientByIdRecipe(int idRecip) throws SQLException, JSONException {
		ArrayList<Ingredient> listIng = new ArrayList<>();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (r:Recipe{idRecipe:'" + idRecip + "'})-[:IS_COMPOSED_TO]->(i:Ingredient) return i";
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Ingredient ing = new Ingredient();
				String result = rs.getString(1);
				JSONObject json = new JSONObject(result);
				ing.setId(json.getInt("idIngred"));
				ing.setName(json.getString("nameIngred"));
				listIng.add(ing);
			}
		}
		return listIng;
	}

	public static ArrayList<Utensil> getUtensil(int idRecip) throws SQLException, JSONException {

		ArrayList<Utensil> utensilList = new ArrayList<>();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "match (r:Recipe{idRecipe:'" + idRecip + "'})-[:USE]->(u:Utensil) return u";
		System.out.println(query);
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String result = rs.getString(1);
				Utensil utensil = new Utensil();
				JSONObject json = new JSONObject(result);
				utensil.setIdUtensil(Integer.parseInt(json.getString("idUtensil")));
				utensil.setNameUtensil(json.getString("nameUtensil"));
				utensilList.add(utensil);
			}
		}
		return utensilList;

	}

	public static void createUser(String name, String mail, String password) throws SQLException {
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		// int keyId;
		// keyId+1;
		String query = "CREATE (n:User { nameUser: '" + name + "', mail: '" + mail + "',password: '" + password + "'})";
		System.out.println(query);
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {

			java.sql.ResultSet rs = stmt.executeQuery(query);

		}
	}

	public static User connection(String name, String pwd) {
		User user = new User();
		String query = "MATCH (u:User {nameUser:'" + name + "', password:'" + pwd + "'}) return u";
		System.out.println(query);

		// Connect
		conn = SingletonConnectionNeo4j.getDbConnection().conn;

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			if (!rs.next())
				return null;

			String r = rs.getString(1);
			JSONObject json = new JSONObject(r);
			user.setName(json.getString("nameUser"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static void userLike(String name, String mail, String ingredient, int score) throws SQLException {
		String query = "MATCH (a:User),(b:Ingredient{nameIngred:'" + ingredient + "'})" + "WHERE a.nameUser = '" + name
				+ "' AND a.mail='" + mail + "'" + "CREATE (a)-[r:LIKE{score:'" + score + "'}]->(b);";
		System.out.println(query);
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {

			java.sql.ResultSet rs = stmt.executeQuery(query);

		}
	}

	public static ArrayList<Recipe> getRecipes(int[] idRecipe) {

		ArrayList<Recipe> al = new ArrayList<>();

		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		try (java.sql.Statement stmt = conn.createStatement()) {
			for (int i = 0; i < idRecipe.length; i++) {
				String query = "MATCH (r:Recipe{idRecipe:'" + idRecipe[i] + "'}) RETURN r";
				java.sql.ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String result = rs.getString(1);
					// System.out.println(result);
					ArrayList<Step> listStep = new ArrayList<>();
					ArrayList<Utensil> listUtensil = new ArrayList<>();
					ArrayList<Ingredient> inggr = new ArrayList<>();
					inggr = Neo4J.getIngredientByIdRecipe(idRecipe[i]);
					listStep = Neo4J.getSteps(idRecipe[i]);
					listUtensil = Neo4J.getUtensil(idRecipe[i]);
					JSONObject json = new JSONObject(result);
					Recipe recipe = new Recipe();
					String title = json.getString("title");
					String timetotal = json.getString("timetotal");
					String timeprepa = json.getString("timeprepa");
					String timecooking = json.getString("timecooking");
					int level = json.getInt("level");
					int number_of_person = json.getInt("number_of_person");
					int budget = json.getInt("budget");

					recipe.setIdRecipe(json.getInt("idRecipe"));
					recipe.setTitle(title);
					recipe.setTimeTotal(timetotal);
					recipe.setTimePrepa(timeprepa);
					recipe.setTimeCooking(timecooking);
					recipe.setLevel(level);
					recipe.setNbOfPerson(number_of_person);
					recipe.setBudget(budget);
					recipe.setSteps(listStep);
					recipe.setUtensils(listUtensil);
					recipe.setIngredients(inggr);
					if (json.has("rating")) {
						double rating = json.getDouble("rating");
						recipe.setRating((float) rating);
					} else {
						double rating;
						rating = 0;
					}

					if (json.has("categorie")) {
						String categorie = json.getString("categorie");
						recipe.setCategorie(
								categorie.replaceAll(",", "").replaceAll("[\\[\\]]", "").replaceAll("'", ""));
					} else {
						String categorie;
						categorie = "None";
					}
					al.add(recipe);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return al;
	}

	public static int[] getRecipesByIngred(int[] idIngred) {

		int[] recipes_id = {};
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "";
		if (idIngred.length == 1)
			query = "MATCH (r:Recipe)-[:IS_COMPOSED_TO]->(i:Ingredient{idIngred : '" + idIngred[0] + "'}) RETURN r";
		else {
			// Querying

			String match = "MATCH ";
			String q1 = "(r:Recipe)-[:IS_COMPOSED_TO]->";
			String returne = " RETURN r";

			String q2 = "";
			String q3 = "";
			for (int i = 0; i < idIngred.length; i++) {
				if (idIngred.length == 1)
					q2 = q1 + "(Ingredient{idIngred : '" + idIngred[i] + "'})";

				else if (idIngred.length > 1) {

					q3 += q1 + "(i" + i + ":Ingredient{idIngred : '" + idIngred[i] + "'}),";
				}
			}
			query = match + q2 + q3.substring(0, q3.length() - 1) + returne;

		}
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String result = rs.getString(1);
				// System.out.println(result);
				JSONObject json = new JSONObject(result);
				int id = json.getInt("idRecipe");
				recipes_id = Arrays.copyOf(recipes_id, recipes_id.length + 1);
				recipes_id[recipes_id.length - 1] = id;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return recipes_id;
	}

	public static int[] getRecipesByCluster(int cluster) {

		int[] recipes_id = {};
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (r:Recipe{label:'" + cluster + "'}) return r";
		// System.out.println(query);
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String result = rs.getString(1);
				// System.out.println(result);
				JSONObject json = new JSONObject(result);
				int id = json.getInt("idRecipe");
				recipes_id = Arrays.copyOf(recipes_id, recipes_id.length + 1);
				recipes_id[recipes_id.length - 1] = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return recipes_id;
	}

	public static ArrayList<Ingredient> getIngreds(int[] idIngred) throws SQLException, JSONException {

		ArrayList<Ingredient> ingredList = new ArrayList<>();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			for (int j = 0; j < idIngred.length; j++) {
				String query = "match (i:Ingredient{idIngred:'" + idIngred[j] + "'}) return i";
				System.out.println(query);
				java.sql.ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					Ingredient ing = new Ingredient();
					String result = rs.getString(1);
					System.out.println(result);
					JSONObject json = new JSONObject(result);
					ing.setId(json.getInt("idIngred"));
					ing.setName(json.getString("nameIngred"));

					if (json.has("quantity")) {
						int quantity = json.getInt("quantity");
						ing.setQuantity(quantity);
					} else {
						int quantity;
						quantity = 0;
					}

					if (json.has("prefix")) {
						String prefix = json.getString("prefix");
						ing.setPrefix(prefix);
					} else {
						String prefix;
						prefix = "None";
					}
					ingredList.add(ing);
				}
			}
			return ingredList;

		}
	}

	public static void ratingIngred(String name, int id_ingr, int value) {
		// Connection
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (user:User{nameUser:'" + name + "'}), (ingred:Ingredient{idIngred:'" + id_ingr
				+ "'}) CREATE (user)-[:LIKE{rateIngred:" + value + "}]->(ingred)";
		System.out.println(query);

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static HashMap<Integer, Integer> getRatingIngred(String name) {

		HashMap<Integer, Integer> map = new HashMap<>();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (user:User{nameUser:'" + name
				+ "'})-[lri:LIKE]->(ingred:Ingredient) with ingred, lri.rateIngred as rateIngred\n"
				+ "return ingred.idIngred,rateIngred";

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			if (rs == null)
				System.out.println("RS NULL");
			while (rs.next()) {
				String idIngred = rs.getString(1);
				String score = rs.getString(2);
				map.put(Integer.parseInt(idIngred), Integer.parseInt(score));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static ArrayList<TopIngred> getIngredByTop3(String name) {

		HashMap<String, Integer> map = new HashMap<>();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (user:User{nameUser:'" + name
				+ "'})-[lri:LIKE]->(ingred:Ingredient) with ingred, lri.rateIngred as rateIngred\n"
				+ "return DISTINCT ingred.nameIngred,rateIngred ORDER BY rateIngred limit 3";
		ArrayList<TopIngred> TopList = new ArrayList<>();
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			if (rs == null)
				System.out.println("RS NULL");
			while (rs.next()) {
				TopIngred top = new TopIngred();
				String nameIngred = rs.getString(1);
				String score = rs.getString(2);
				top.setNamIng(nameIngred);
				top.setRating(score);
				TopList.add(top);
				// map.put(nameIngred, Integer.parseInt(score));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return TopList;
	}

	public static void ratingCluster(String name, int id_cluster, int value) throws SQLException {
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (u:User{nameUser:'" + name + "'})\n" + "MATCH (c:Cluster{idCluster:'" + id_cluster
				+ "'})\n" + "CREATE (u)-[:LIKE{rateCluster:" + value + "}]->(c)\n" + "";
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
		}
	}

	public static ArrayList<Integer> getRatingClusters(String name) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (user:User{nameUser:'" + name
				+ "'})-[lri:LIKE]->(cluster:Cluster) with cluster, lri.rateCluster as rateCluster\n"
				+ "return cluster.idCluster,rateCluster";
		// System.out.println(query);
		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String idCluster = rs.getString(1);
				String score = rs.getString(2);
				map.put(Integer.parseInt(idCluster), Integer.parseInt(score));
			}
			// System.out.println(map.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 30; i++) {
			if (map.containsKey(i))
				list.add(map.get(i));
			else
				list.add(0);
		}

		return list;
	}

	public void calculEuclideanDistance(int id_user) throws SQLException {

		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (u1:User)-[x:LIKE]->(i:Ingredient)," + "(u2:User)-[y:LIKE]->(i)" + "WHERE id(u1)<id(u2)"
				+ " WITH sqrt(sum((toInt(x.score)-toInt(y.score))^2)) AS euc , u1, u2"
				+ " MERGE (u1)-[d:DISTANCE]->(u2)" + "SET d.euclidean=euc;";

		// Querying
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
		}
	}

	public HashMap<Integer, Integer> getSimilarUser(int id_user) {
		return null;

	}

	/**
	 * Methode pour la suggestion des recettes
	 * 
	 * @param name
	 * @return
	 */
	public static Ingredient getIngeByName(String name) {
		java.sql.Connection conn = null;
		String r = null;
		// connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		Ingredient i = new Ingredient();
		// requête
		String req = "match (i:Ingredient{nameIngred:'" + name + "'}) return i;";

		try {
			java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery(req);
			while (rs.next()) {
				r = rs.getString(1);
				JSONObject json = new JSONObject(r);
				i.setName(name);
				i.setId(json.getInt("idIngred"));
			}
		} catch (Exception e) {
		}

		return i;
	}

	public static Ingredient getRandomIngred() throws SQLException, JSONException {

		Ingredient i=new Ingredient();
		// Connect
		SingletonConnectionNeo4j sc = SingletonConnectionNeo4j.getDbConnection();
		conn = sc.conn;
		String query = "MATCH (i:Ingredient),(u:User)-[l:LIKE]-(i1:Ingredient)" + "WITH i,rand() AS rand, i1 "
				+ "ORDER BY rand WHERE i <> i1 AND NOT i.photoIngred CONTAINS 'unique' return i LIMIT 1";
		String r = null;
		try (java.sql.Statement stmt = conn.createStatement()) {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				r= rs.getString(1);
				JSONObject json = new JSONObject(r);
				i.setId(Integer.parseInt(json.getString("idIngred")));
				i.setName(json.getString("nameIngred"));
				i.setPhoto(json.getString("photoIngred"));
			}
			// System.out.println(map.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
		
	}

}
