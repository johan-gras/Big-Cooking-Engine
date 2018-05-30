package bigcookingdata_engine.business.data.user;

/**
 * class User
 * 
 * @author sofiane-hamiti
 *
 */
public class User {
	/**
	 * user fields
	 */
	private int id;

	private String name;
	private String surname;
	private String sexe;
	private double weight;

	/**
	 * Constructor without fields
	 */
	public User() {
		super();
	}

	public User(int id, String name, String surname, String sexe, double weight) {
		super();
		this.name = name;
		this.surname = surname;
		this.sexe = sexe;
		this.weight = weight;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", sexe=" + sexe + ", weight=" + weight + "]";
	}

}
