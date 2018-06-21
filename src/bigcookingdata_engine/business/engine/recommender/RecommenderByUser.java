package bigcookingdata_engine.business.engine.recommender;

import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

import java.util.ArrayList;
import java.util.HashMap;

public class RecommenderByUser extends RecommenderCell {

    @Override
    HashMap<Integer, Integer> scoring() {
        ArrayList<Integer> recipes = Neo4J.getBestRecipe(Session.getInstance().getUser().getMail());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int id : recipes)
            map.put(id, 10);

        return map;
    }
}
