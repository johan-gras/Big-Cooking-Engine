package bigcookingdata_engine.business.engine.recommender;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

import java.util.*;

public class Recommender {

    public Recommender(){

    }

    public ArrayList<Recipe> getRecoByCluster(){
        ArrayList<RecommenderCell> cells = new ArrayList<>();
        cells.add(new RecommenderByCluster());
        return recommend(cells);
    }

    public ArrayList<Recipe> getRecoByIngred(){
        ArrayList<RecommenderCell> cells = new ArrayList<>();
        cells.add(new RecommenderByIngred());
        return recommend(cells);
    }

    public ArrayList<Recipe> getRecoSuper(){
        ArrayList<RecommenderCell> cells = new ArrayList<>();
        cells.add(new RecommenderByCluster());
        cells.add(new RecommenderByIngred());
        return recommend(cells);
    }

    private ArrayList<Recipe> recommend(ArrayList<RecommenderCell> cells){
        // Weights
        HashMap<Integer, Integer> map = new HashMap<>();
        for (RecommenderCell cell : cells)
            for (Map.Entry<Integer, Integer> e : cell.scoring().entrySet())
                map.merge(e.getKey(), e.getValue(), (a, b) -> a+b);
        System.out.println(map);

        // Probability
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int sum = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            treeMap.put(sum += e.getValue(), e.getKey());
        System.out.printf("The generated is map %s%n", treeMap);

        // Generating
        Random generator = new Random();
        ArrayList<Integer> id_recipes = new ArrayList<>();
        while (id_recipes.size() < 3){
            int id = treeMap.get(treeMap.ceilingKey(generator.nextInt(sum + 1)));
            if (!id_recipes.contains(id))
                id_recipes.add(id);
        }
        System.out.println(id_recipes);
        return Neo4J.getRecipes(id_recipes.stream().mapToInt(i -> i).toArray());
    }

    public static void main(String[] args){
        Session.getInstance().connection("aa@aa.aa", "a");
        Recommender reco = new Recommender();
        System.out.println(reco.getRecoSuper());
    }
}
