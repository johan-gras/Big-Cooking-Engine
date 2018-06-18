package bigcookingdata_engine.business.data.recipe;

public class TopIngred {

	private String namIng=null;
	private String rating;
	public TopIngred(String namIng, String rating) {
		super();
		this.namIng = namIng;
		this.rating = rating;
	}
	public TopIngred() {
		super();
	}
	public String getNamIng() {
		return namIng;
	}
	public void setNamIng(String namIng) {
		this.namIng = namIng;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "TopIngred [namIng=" + namIng + ", rating=" + rating + "]";
	}
	
	
	
}
