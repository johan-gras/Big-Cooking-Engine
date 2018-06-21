package bigcookingdata_engine.business.engine.recommender;

import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

import java.util.ArrayList;
import java.util.HashMap;

public class RecommenderByCluster extends RecommenderCell {
    @Override
    public HashMap<Integer, Integer> scoring() {
        ArrayList<Integer> clustersRating = Neo4J.getRatingClusters(Session.getInstance().getUser().getName());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int cluster = 0 ; cluster<clustersRating.size() ; cluster++){
            if (clustersRating.get(cluster) != 0)
                for (int id : Neo4J.getRecipesByCluster(cluster))
                    map.put(id, clustersRating.get(cluster));
        }
        return map;
    }
}
