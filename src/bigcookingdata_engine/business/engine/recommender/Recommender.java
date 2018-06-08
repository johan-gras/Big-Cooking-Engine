package bigcookingdata_engine.business.engine.recommender;

import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

import java.util.*;

public class Recommender {
    private ArrayList<Recipe> recipes_perso = null;
    private ArrayList<RecommenderCell> cells = new ArrayList<>();

    public Recommender(){
        cells.add(new RecommenderByCluster());
        cells.add(new RecommenderByIngred());
    }

    public ArrayList<Recipe> getRecipes_recommended() {
        if (recipes_perso == null)
            recommend();
        return recipes_perso;
    }

    public void recommend(){
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
        recipes_perso = Neo4J.getRecipes(id_recipes.stream().mapToInt(i -> i).toArray());
    }

    public static void main(String[] args){
        Session.getInstance().connection("aa@aa.aa", "a");
        Recommender reco = new Recommender();
        reco.recommend();
        ArrayList<Recipe> li = new ArrayList<>();
        li = reco.getRecipes_recommended();
        System.out.println("NBRECETTES RECO::QND@"+li.size());
    }
}
