package uk.ac.belfastmet.springbuildings.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import uk.ac.belfastmet.springbuildings.domain.BuildingFloorArea;
import uk.ac.belfastmet.springbuildings.domain.BuildingFootprint;
import uk.ac.belfastmet.springbuildings.domain.BuildingVolume;

@Service
public class BuildingService {
	
	public BuildingService() {
		
	}
	

	public ArrayList<BuildingFloorArea> getBuildingFloorArea(){
		ArrayList<BuildingFloorArea> BFA = new ArrayList<BuildingFloorArea>();
		BuildingFloorArea NCGC = new BuildingFloorArea(1,	"New Century Global Center",	 "China",	"Chengdu",	1760000, "lfa1.jpg" );
		BFA.add(NCGC);
		BuildingFloorArea DIAT = new BuildingFloorArea(2,	"Dubai International Airport Terminal 3",	 "United Arab Emirates",	"Dubai",	1713000, "lfa2.jpg" );
		BFA.add(DIAT);
		BuildingFloorArea AABE = new BuildingFloorArea(3,	"Abraj Al-Bait Endowment",	 "Saudi Arabia",	"Mecca",	1575815, "lfa3.jpg" );
		BFA.add(AABE);
		BuildingFloorArea CW = new BuildingFloorArea(4,	"CentralWorld",	 "Thailand",	"Bangkok",	1024000, "lfa4.jpg" );
		BFA.add(CW);
		BuildingFloorArea AFA = new BuildingFloorArea(5,	"Aalsmeer Flower Auction",	 "Netherlands",	"Aalsmeer",	990000, "lfa5.jpg" );
		BFA.add(AFA);
		BuildingFloorArea BCIAT = new BuildingFloorArea(6,	"Beijing Capital International Airport Terminal 3",	 "China",	"Beijing",	986000, "lfa6.jpg" );
		BFA.add(BCIAT);
		BuildingFloorArea TVN = new BuildingFloorArea(7,	"The Venetian Macao",	 "Macau",	"Macau",	980000, "lfa7.jpg" );
		BFA.add(TVN);
		BuildingFloorArea SCC = new BuildingFloorArea(8,	"Sands Cotai Central",	 "Macau",	"Macau",	890000, "lfa8.jpg" );
		BFA.add(SCC);
		BuildingFloorArea CWS = new BuildingFloorArea(9,	"Ciputra World Surabaya",	 "Indonesia",	"Surabaya",	750000, "lfa9.jpg" );
		BFA.add(CWS);
		BuildingFloorArea BTS = new BuildingFloorArea(10,	"Berjaya Times Square",	 "Malaysia",	"Kuala Lumpur",	700000, "lfa10.jpg" );
		BFA.add(BTS);
		return BFA;
	}

	public ArrayList<BuildingVolume> getBuildingVolume(){
		ArrayList<BuildingVolume> BV = new ArrayList<BuildingVolume>();
		BuildingVolume BEF = new BuildingVolume(1,	"Boeing Everett Factory",	 "United States",	"Everett, Washington",	39000,	13300000, "v1.jpg");
		BV.add(BEF);
		BuildingVolume GMM = new BuildingVolume(2,	"Great Mosque of Mecca",	 "Saudi Arabia",	"Hijaz-Saudi Arabia",	356000, 8000000, "v2.jpg");
		BV.add(GMM);
		BuildingVolume JLLA = new BuildingVolume(3,	"Jean-Luc Lagardère Plant",	 "France",	"Toulouse-Blagnac",	122500,	5600000, "v3.jpg");
		BV.add(JLLA);
		BuildingVolume BCWC = new BuildingVolume(4,	"Boeing Composite Wing Center",	 "United States",	"Everett, Washington",	111500,	3700000, "v4.jpg");
		BV.add(BCWC);
		BuildingVolume AER = new BuildingVolume(5,	"Aerium",	 "Germany",	"Halbe, Brandenburg",	70000,	5200000, "v5.jpg");
		BV.add(AER);
		BuildingVolume MWD = new BuildingVolume(6,	"Meyer Werft Dockhalle 2",	"Germany",	"Papenburg, Niedersachsen",	63000,	4720000, "v6.jpg");
		BV.add(MWD);
		BuildingVolume NVA = new BuildingVolume(7,	"NASA Vehicle Assembly Building",	 "United States",	"Brevard County, Florida",	32374,	3660000, "v7.jpg");
		BV.add(NVA);
		BuildingVolume TO2 = new BuildingVolume(8,	"The O2",	"United Kingdom",	"London",	104634,	2790000, "v8.jpg");
		BV.add(TO2);
		BuildingVolume TIDC = new BuildingVolume(9,	"Tesco Ireland Distribution Centre",	 "Ireland",	"Donabate, Fingal",	80194,	1550000, "v9.jpg");
		BV.add(TIDC);
		BuildingVolume TIW = new BuildingVolume(10,	"Target Import Warehouse",	 "United States",	"Savannah, Georgia",	187664,	1500000, "v10.jpg");
		BV.add(TIW);
		return BV;
	}

	public ArrayList<BuildingFootprint> getBuildingFootprint(){
		ArrayList<BuildingFootprint> BF = new ArrayList<BuildingFootprint>();
		BuildingFootprint BTS = new BuildingFootprint(1,	"Aalsmeer Flower Auction",	 "Netherlands",	"Aalsmeer",	518000, "f1.jpg" );
		BF.add(BTS);
		BuildingFootprint TF = new BuildingFootprint(2,	"Tesla Factory",	 "United States",	"Fremont, California",	427354, "f2.jpg" );
		BF.add(TF);
		BuildingFootprint BEF = new BuildingFootprint(3,	"Boeing Everett Factory",	 "United States",	"Everett, Washington",	398000, "f3.jpg" );
		BF.add(BEF);
		BuildingFootprint MDC = new BuildingFootprint(4,	"Michelin Distribution Center",	 "United States",	"Spartanburg, South Carolina",	371612, "f4.jpg" );
		BF.add(MDC);
		BuildingFootprint GMM = new BuildingFootprint(5,	"Great Mosque of Mecca",	 "Saudi Arabia",	"Hijaz-Saudi Arabia",	356000, "f5.jpg"  );
		BF.add(GMM);
		BuildingFootprint NNALC = new BuildingFootprint(6,	"Nike - North America Logistics Center",	 "United States",	"Memphis, Tennessee",	260000, "f6.jpg" );
		BF.add(NNALC);
		BuildingFootprint JDNAPDC = new BuildingFootprint(7,	"John Deere North American Parts Distribution Center",	 "United States",	"Milan, Illinois",	246000, "f7.jpg" );
		BF.add(JDNAPDC);
		BuildingFootprint MD = new BuildingFootprint(8,	"Mall of Dubai",	 "United Arab Emirates",	"Dubai",	500000, "f8.jpg" );
		BF.add(MD);
		BuildingFootprint MMNA = new BuildingFootprint(9,	"Mitsubishi Motors North America",	 "United States",	"Normal, Illinois",	220000, "f9.jpg" );
		BF.add(MMNA);
		BuildingFootprint ICE = new BuildingFootprint(10,	"Indonesia Convention Exhibition",	 "Indonesia",	"Bumi Serpong Damai",	220000, "f10.jpg" );
		BF.add(ICE);
		return BF;
	}
}
