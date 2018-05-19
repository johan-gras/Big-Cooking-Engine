package bigcookingdata_engine.business.data.recipe;

public class Recipe {
	
	public String timeTotal;
	public String[] categorie;
	public int level;
	public int nbOfPerson;
	public String timeCooking;
	public float rating;
	public String timePrepa;
	public String title;
	public int idRecipe;
	public int budget;
	
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

}
