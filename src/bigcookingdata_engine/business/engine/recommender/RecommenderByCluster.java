package bigcookingdata_engine.business.engine.recommender;

import java.util.HashMap;

public class RecommenderByCluster extends RecommenderCell {
    @Override
    public HashMap<Integer, Integer> scoring() {
        int[] clustersRating = getRatingClusters();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int cluster = 0 ; cluster<clustersRating.length ; cluster++){
            if (clustersRating[cluster] != 0)
                for (int id : getIdRecipesByCluster(cluster))
                    map.put(id, clustersRating[cluster]);
        }
        return map;
    }


    // Fake db
    private int[] getRatingClusters(){
        return new int[] {50, 30, 20, 0, 0, 0, 0, 0, 0, 0};
    }
    private int[] getIdRecipesByCluster(int cluster){
        return new int[] {cluster*4, 2+cluster*4, 3+cluster*4, 1+cluster*4};
    }
}
