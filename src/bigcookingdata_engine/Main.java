package bigcookingdata_engine;

import java.util.ArrayList;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.engine.SearchEngine;

/*
 * Main class 
 * @author sofiane-hamiti
 *
 */
public class Main {

	/*
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SearchEngine se = new SearchEngine();
		ArrayList<Recipe> list = new ArrayList<>();
		list = se.searcherEngine("pizza");
		System.out.println(list.get(6));

	}

}
