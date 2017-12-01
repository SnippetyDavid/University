package uk.ac.belfastmet.springbuildings.domain;

public class BuildingFootprint {

	private int rank;
	private String name;
	private String country;
	private String place;
	private int footprint;
	private String image;

	public BuildingFootprint(int rank, String name, String country, String place, int footprint, String image) {
		super();
		this.rank = rank;
		this.name = name;
		this.country = country;
		this.place = place;
		this.footprint = footprint;
		this.image = image;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getFootprint() {
		return footprint;
	}

	public void setFootprint(int footprint) {
		this.footprint = footprint;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
