package uk.ac.belfastmet.springdwarvesdwarfssaved.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.belfastmet.springdwarvesdwarfssaved.domain.Dwarf;
import uk.ac.belfastmet.springdwarvesdwarfssaved.repositories.DwarfRepository;


@Service
public class DataLoader {
	
	@Autowired
	private DwarfRepository dwarfRepository;
	
	public DataLoader(DwarfRepository dwarfRepository) {
		super();
		this.dwarfRepository = dwarfRepository;
	}

	//@PostConstruct
	public void loadData() {
		Dwarf Dopey = new Dwarf("Dopey", "Disney", "Dopey.png");
		dwarfRepository.save(Dopey);
		Dwarf Doc = new Dwarf("Doc", "Disney", "Doc.png");
		dwarfRepository.save(Doc);
		Dwarf Grumpy = new Dwarf("Grumpy", "Disney", "Grumpy.png");
		dwarfRepository.save(Grumpy);
		Dwarf Bashful = new Dwarf("Bashful", "Disney", "Bashful.png");
		dwarfRepository.save(Bashful);
		Dwarf Sneezy = new Dwarf("Sneezy", "Disney", "Sneezy.png");
		dwarfRepository.save(Sneezy);
		Dwarf Sleepy = new Dwarf("Sleepy", "Disney", "Sleepy.png");
		dwarfRepository.save(Sleepy);
		Dwarf Happy = new Dwarf("Happy", "Disney", "Happy.png");
		dwarfRepository.save(Happy);
		
		Dwarf Thorin = new Dwarf("Thorin", "LOTR", "Thorin.png");
		dwarfRepository.save(Thorin);
		Dwarf Fili = new Dwarf("Fili", "LOTR", "Fili.png");
		dwarfRepository.save(Fili);
		Dwarf Kili = new Dwarf("Kili", "LOTR", "Kili.png");
		dwarfRepository.save(Kili);
		Dwarf Oin = new Dwarf("Oin", "LOTR", "Oin.png");
		dwarfRepository.save(Oin);
		Dwarf Gloin = new Dwarf("Gloin", "LOTR", "Gloin.png");
		dwarfRepository.save(Gloin);
		Dwarf Balin = new Dwarf("Balin", "LOTR", "Balin.png");
		dwarfRepository.save(Balin);
		Dwarf Dwalin = new Dwarf("Dwalin", "LOTR", "Dwalin.png");
		dwarfRepository.save(Dwalin);
		Dwarf Ori = new Dwarf("Ori", "LOTR", "Ori.png");
		dwarfRepository.save(Ori);
		Dwarf Dori = new Dwarf("Dori", "LOTR", "Dori.png");
		dwarfRepository.save(Dori);
		Dwarf Nori = new Dwarf("Nori", "LOTR", "Nori.png");
		dwarfRepository.save(Nori);
		Dwarf Bifur = new Dwarf("Bifur", "LOTR", "Bifur.png");
		dwarfRepository.save(Bifur);
		Dwarf Bofur = new Dwarf("Bofur", "LOTR", "Bofur.png");
		dwarfRepository.save(Bofur);
		Dwarf Bombur = new Dwarf("Bombur", "LOTR", "Bombur.png");
		dwarfRepository.save(Bombur);
	}
}
