package uk.ac.belfastmet.springdwarvesdwarfs.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import uk.ac.belfastmet.springdwarvesdwarfs.domain.Dwarf;

@Service
public class DwarfService {
	
	private ArrayList<Dwarf> disneyDwarfs;
	private ArrayList<Dwarf> tolkienDwarfs;
	
	public DwarfService() {
		super();
	}
	
	public ArrayList<Dwarf> getTolkienDwarfs(){
		ArrayList<Dwarf> Dwarfs = new ArrayList<Dwarf>();
		Dwarf Thorin = new Dwarf("Thorin", "LOTR", "Thorin.png");
		Dwarfs.add(Thorin);
		Dwarf Fili = new Dwarf("Fili", "LOTR", "Fili.png");
		Dwarfs.add(Fili);
		Dwarf Kili = new Dwarf("Kili", "LOTR", "Kili.png");
		Dwarfs.add(Kili);
		Dwarf Oin = new Dwarf("Oin", "LOTR", "Oin.png");
		Dwarfs.add(Oin);
		Dwarf Gloin = new Dwarf("Gloin", "LOTR", "Gloin.png");
		Dwarfs.add(Gloin);
		Dwarf Balin = new Dwarf("Balin", "LOTR", "Balin.png");
		Dwarfs.add(Balin);
		Dwarf Dwalin = new Dwarf("Dwalin", "LOTR", "Dwalin.png");
		Dwarfs.add(Dwalin);
		Dwarf Ori = new Dwarf("Ori", "LOTR", "Ori.png");
		Dwarfs.add(Ori);
		Dwarf Dori = new Dwarf("Dori", "LOTR", "Dori.png");
		Dwarfs.add(Dori);
		Dwarf Nori = new Dwarf("Nori", "LOTR", "Nori.png");
		Dwarfs.add(Nori);
		Dwarf Bifur = new Dwarf("Bifur", "LOTR", "Bifur.png");
		Dwarfs.add(Bifur);
		Dwarf Bofur = new Dwarf("Bofur", "LOTR", "Bofur.png");
		Dwarfs.add(Bofur);
		Dwarf Bombur = new Dwarf("Bombur", "LOTR", "Bombur.png");
		Dwarfs.add(Bombur);
		return Dwarfs;
	}
	
	public ArrayList<Dwarf> getDisneyDwarfs(){
		ArrayList<Dwarf> Dwarfs = new ArrayList<Dwarf>();
		Dwarf Dopey = new Dwarf("Dopey", "Disney", "Dopey.png");
		Dwarfs.add(Dopey);
		Dwarf Doc = new Dwarf("Doc", "Disney", "Doc.png");
		Dwarfs.add(Doc);
		Dwarf Grumpy = new Dwarf("Grumpy", "Disney", "Grumpy.png");
		Dwarfs.add(Grumpy);
		Dwarf Bashful = new Dwarf("Bashful", "Disney", "Bashful.png");
		Dwarfs.add(Bashful);
		Dwarf Sneezy = new Dwarf("Sneezy", "Disney", "Sneezy.png");
		Dwarfs.add(Sneezy);
		Dwarf Sleepy = new Dwarf("Sleepy", "Disney", "Sleepy.png");
		Dwarfs.add(Sleepy);
		Dwarf Happy = new Dwarf("Happy", "Disney", "Happy.png");
		Dwarfs.add(Happy);
		return Dwarfs;
	}

}
