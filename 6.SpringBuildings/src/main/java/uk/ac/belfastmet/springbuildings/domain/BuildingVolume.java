package uk.ac.belfastmet.springbuildings.domain;

public class BuildingVolume {

	private int rank;
	private String name;
	private String country;
	private String place;
	private int floorArea;
	private int volume;
	private String image;

	public BuildingVolume(int rank, String name, String country, String place, int floorArea, int volume, String image) {
		super();
		this.rank = rank;
		this.name = name;
		this.country = country;
		this.place = place;
		this.floorArea = floorArea;
		this.volume = volume;
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

	public int getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
