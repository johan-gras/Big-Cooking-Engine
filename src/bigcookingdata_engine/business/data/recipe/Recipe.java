package bigcookingdata_engine.business.data.recipe;

public class Recipe {
	
	private String timeTotal;
	private String[] categorie;
	private int level;
	private int nbOfPerson;
	private String timeCooking;
	private float rating;
	private String timePrepa;
	private String title;
    private int idRecipe;
	private int budget;
    private int[] ingredients_id;
    private int cluster;

    public Recipe() {
    }

    public Recipe(String timeTotal, String[] categorie, int level, int nbOfPerson, String timeCooking, float rating,
                  String timePrepa, String title, int idRecipe, int budget, int[] ingredients_id, int cluster) {
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
        this.ingredients_id = ingredients_id;
        this.cluster = cluster;
    }

    public String getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(String timeTotal) {
        this.timeTotal = timeTotal;
    }

    public String[] getCategorie() {
        return categorie;
    }

    public void setCategorie(String[] categorie) {
        this.categorie = categorie;
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

    public int[] getIngredients_id() {
        return ingredients_id;
    }

    public void setIngredients_id(int[] ingredients_id) {
        this.ingredients_id = ingredients_id;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }
}
