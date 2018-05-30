package bigcookingdata_engine.business.engine;

import bigcookingdata_engine.business.data.recipe.Recipe;

import java.util.ArrayList;

public class Recommender {
    private ArrayList<Recipe> recipes_perso;

    public Recommender() {
        recipes_perso = fake_reco();
    }

    private ArrayList<Recipe> fake_reco(){
        ArrayList<Recipe> fake = new ArrayList<>();
        for (int i=0 ; i<=2 ; i++){
            fake.add(new Recipe());
        }
        return fake;
    }

    public ArrayList<Recipe> getRecipes_perso() {
        return recipes_perso;
    }
}
