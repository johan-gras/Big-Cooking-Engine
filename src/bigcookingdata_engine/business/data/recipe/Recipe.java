package bigcookingdata_engine.business.data.recipe;

/**
 * 
 * @author sofiane-hamiti
 *
 */
public class Recipe {

	/**
	 * precipe fields
	 */
	
	private int id;
	private int level;
	private String numberOfPersons;
	private String rating;
	private String timeTotal;
	private String timePreatation;
	private String timeCooking;
	private String title;
	
	
	public Recipe() {
		super();
	}


	public Recipe(int id, int level, String numberOfPersons, String rating, String timeTotal, String timePreatation,
			String timeCooking, String title) {
		super();
		this.id = id;
		this.level = level;
		this.numberOfPersons = numberOfPersons;
		this.rating = rating;
		this.timeTotal = timeTotal;
		this.timePreatation = timePreatation;
		this.timeCooking = timeCooking;
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public String getNumberOfPersons() {
		return numberOfPersons;
	}


	public void setNumberOfPersons(String numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getTimeTotal() {
		return timeTotal;
	}


	public void setTimeTotal(String timeTotal) {
		this.timeTotal = timeTotal;
	}


	public String getTimePreatation() {
		return timePreatation;
	}


	public void setTimePreatation(String timePreatation) {
		this.timePreatation = timePreatation;
	}


	public String getTimeCooking() {
		return timeCooking;
	}


	public void setTimeCooking(String timeCooking) {
		this.timeCooking = timeCooking;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "Recipe [id=" + id + ", level=" + level + ", numberOfPersons=" + numberOfPersons + ", rating=" + rating
				+ ", timeTotal=" + timeTotal + ", timePreatation=" + timePreatation + ", timeCooking=" + timeCooking
				+ ", title=" + title + "]";
	}
	
	
	
	
	
}
