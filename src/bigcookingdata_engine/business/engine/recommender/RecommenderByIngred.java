package bigcookingdata_engine.business.engine.recommender;

import bigcookingdata_engine.database.Neo4J;

import java.util.HashMap;
import java.util.Map;

public class RecommenderByIngred extends RecommenderCell {
    @Override
    HashMap<Integer, Integer> scoring() {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(Map.Entry<Integer, Integer> e : getRatingIngred().entrySet()){
            for (int id : getIdRecipesByIngred(e.getKey())){
                if (map.containsKey(id))
                    map.replace(id, map.get(id) + e.getValue());
                else
                    map.put(id, e.getValue());
            }
        }
        return map;
    }

    // Fake db
    private HashMap<Integer, Integer> getRatingIngred() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 10);
        map.put(4, 10);
        return map;
    }

    private int[] getIdRecipesByIngred(int id_ingred){
        return new int[] {id_ingred*4, 2+id_ingred*4, 3+id_ingred*4, 1+id_ingred*4};
    }
}
