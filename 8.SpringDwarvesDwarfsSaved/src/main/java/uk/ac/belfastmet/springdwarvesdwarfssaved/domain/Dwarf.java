package uk.ac.belfastmet.springdwarvesdwarfssaved.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dwarf {
	
	@Id
	@GeneratedValue
	private Integer dwarfId;
	private String name;
	private String author;
	private String image;
	
	public Dwarf() {
		
	}

	public Dwarf (String name, String author, String image){
		this.name = name;
		this.author = author;
		this.image = image;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	
}
