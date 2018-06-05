package bigcookingdata_engine.business.data.recipe;

import java.util.ArrayList;

public class Recipe {

	private String timeTotal;
	private String categorie;
	private int level;
	private int nbOfPerson;
	private String timeCooking;
	private float rating;
	private String timePrepa;
	private String title;
    private int idRecipe;
	private int budget;
    private int cluster;
    private ArrayList<Ingredient> ingredients = null;
    private ArrayList<Step> steps = null;
    private ArrayList<Utensil> utensils = null;

    public Recipe() {
    }

    public Recipe(String timeTotal, String categorie, int level, int nbOfPerson, String timeCooking, float rating,
                  String timePrepa, String title, int idRecipe, int budget, int cluster, ArrayList<Ingredient> ingredients,
                  ArrayList<Step> steps, ArrayList<Utensil> utensils) {
        this.timeTotal = timeTotal;
        this.categorie = categorie;
        this.level = level;
        this.nbOfPerson = nbOfPerson;
        this.timeCooking = timeCooking;
        this.rating = rating;
        this.timePrepa = timePrepa;
        this.title = title;
        this.idRecipe = idRecipe;
        this.budget = budget;
        this.cluster = cluster;
        this.ingredients = ingredients;
        this.steps = steps;
        this.utensils = utensils;
    }

    public String getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(String timeTotal) {
        this.timeTotal = timeTotal;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String string) {
        this.categorie = string;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNbOfPerson() {
        return nbOfPerson;
    }

    public void setNbOfPerson(int nbOfPerson) {
        this.nbOfPerson = nbOfPerson;
    }

    public String getTimeCooking() {
        return timeCooking;
    }

    public void setTimeCooking(String timeCooking) {
        this.timeCooking = timeCooking;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTimePrepa() {
        return timePrepa;
    }

    public void setTimePrepa(String timePrepa) {
        this.timePrepa = timePrepa;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public ArrayList<Utensil> getUtensils() {
        return utensils;
    }

    public void setUtensils(ArrayList<Utensil> utensils) {
        this.utensils = utensils;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "timeTotal='" + timeTotal + '\'' +
                ", categorie='" + categorie + '\'' +
                ", level=" + level +
                ", nbOfPerson=" + nbOfPerson +
                ", timeCooking='" + timeCooking + '\'' +
                ", rating=" + rating +
                ", timePrepa='" + timePrepa + '\'' +
                ", title='" + title + '\'' +
                ", idRecipe=" + idRecipe +
                ", budget=" + budget +
                ", cluster=" + cluster +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", utensils=" + utensils +
                '}';
    }
}
