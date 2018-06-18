package bigcookingdata_engine.business.data.recipe;

public class Ingredient {
    private int id;
    private String complement = null;
    private String prefix = null;
    private String name = null;
    private int quantity = -1;
    private String photo = null;
    

    public Ingredient(){

    }

    public Ingredient(int id, String complement, String prefix, String name, int quantity) {
        this.id = id;
        this.complement = complement;
        this.prefix = prefix;
        this.name = name;
        this.quantity = quantity;
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
    
}