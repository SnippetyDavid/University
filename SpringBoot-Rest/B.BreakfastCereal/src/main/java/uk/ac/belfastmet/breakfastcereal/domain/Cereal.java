package uk.ac.belfastmet.breakfastcereal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cereal {
	
	@Id
	@GeneratedValue
	private Integer cerealId;
	@NotEmpty
	private String manufacturer;
	@NotEmpty
	private String cerealName;
	private int energy;
	private int calories;
//	@Min((long) 0.01)
	private double protein;
	private double carbohydrate;
	private double sugars;
	private double fat;
	private double saturates;
	private double fibre;
	private String sodium;
	private String salt;
	private String iron;
	
	public Cereal() {
		
	}
	
	public Cereal(Integer cerealId, String manufacturer, String cerealName, int energy, int calories, double protein,
			double carbohydrate, double sugars, double fat, double saturates, double fibre, String sodium, String salt,
			String iron) {
		super();
		this.cerealId = cerealId;
		this.manufacturer = manufacturer;
		this.cerealName = cerealName;
		this.energy = energy;
		this.calories = calories;
		this.protein = protein;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fat = fat;
		this.saturates = saturates;
		this.fibre = fibre;
		this.sodium = sodium;
		this.salt = salt;
		this.iron = iron;
	}

	public Integer getCerealId() {
		return cerealId;
	}

	public void setCerealId(Integer cerealId) {
		this.cerealId = cerealId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCerealName() {
		return cerealName;
	}

	public void setCerealName(String cerealName) {
		this.cerealName = cerealName;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public double getSugars() {
		return sugars;
	}

	public void setSugars(double sugars) {
		this.sugars = sugars;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getSaturates() {
		return saturates;
	}

	public void setSaturates(double saturates) {
		this.saturates = saturates;
	}

	public double getFibre() {
		return fibre;
	}

	public void setFibre(double fibre) {
		this.fibre = fibre;
	}

	public String getSodium() {
		return sodium;
	}

	public void setSodium(String sodium) {
		this.sodium = sodium;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getIron() {
		return iron;
	}

	public void setIron(String iron) {
		this.iron = iron;
	}
	
	
	

}
