package uk.ac.belfastmet.springbuildings.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import uk.ac.belfastmet.springbuildings.domain.BuildingFloorArea;
import uk.ac.belfastmet.springbuildings.domain.BuildingFootprint;
import uk.ac.belfastmet.springbuildings.domain.BuildingVolume;

@Service
public class BuildingService {
	

	public ArrayList<BuildingFloorArea> getBuildingFloorArea(){
		ArrayList<BuildingFloorArea> BFA = new ArrayList<BuildingFloorArea>();
		BuildingFloorArea NCGC = new BuildingFloorArea(1,	"New Century Global Center",	 "China",	"Chengdu",	1760000 );
		BFA.add(NCGC);
		BuildingFloorArea DIAT = new BuildingFloorArea(2,	"Dubai International Airport Terminal 3",	 "United Arab Emirates",	"Dubai",	1713000 );
		BFA.add(DIAT);
		BuildingFloorArea AABE = new BuildingFloorArea(3,	"Abraj Al-Bait Endowment",	 "Saudi Arabia",	"Mecca",	1575815 );
		BFA.add(AABE);
		BuildingFloorArea CW = new BuildingFloorArea(4,	"CentralWorld",	 "Thailand",	"Bangkok",	1024000 );
		BFA.add(CW);
		BuildingFloorArea AFA = new BuildingFloorArea(5,	"Aalsmeer Flower Auction",	 "Netherlands",	"Aalsmeer",	990000 );
		BFA.add(AFA);
		BuildingFloorArea BCIAT = new BuildingFloorArea(6,	"Beijing Capital International Airport Terminal 3",	 "China",	"Beijing",	986000 );
		BFA.add(BCIAT);
		BuildingFloorArea TVN = new BuildingFloorArea(7,	"The Venetian Macao",	 "Macau",	"Macau",	980000 );
		BFA.add(TVN);
		BuildingFloorArea SCC = new BuildingFloorArea(8,	"Sands Cotai Central",	 "Macau",	"Macau",	890000 );
		BFA.add(SCC);
		BuildingFloorArea CWS = new BuildingFloorArea(9,	"Ciputra World Surabaya",	 "Indonesia",	"Surabaya",	750000 );
		BFA.add(CWS);
		BuildingFloorArea BTS = new BuildingFloorArea(10,	"Berjaya Times Square",	 "Malaysia",	"Kuala Lumpur",	700000 );
		BFA.add(BTS);
		return BFA;
	}

	public ArrayList<BuildingVolume> getBuildingVolume(){
		ArrayList<BuildingVolume> BV = new ArrayList<BuildingVolume>();
		BuildingVolume BEF = new BuildingVolume(1,	"Boeing Everett Factory",	 "United States",	"Everett, Washington",	39000,	13300000);
		BV.add(BEF);
		BuildingVolume GMM = new BuildingVolume(2,	"Great Mosque of Mecca",	 "Saudi Arabia",	"Hijaz-Saudi Arabia",	356000, 8000000);
		BV.add(GMM);
		BuildingVolume JLLA = new BuildingVolume(3,	"Jean-Luc Lagardère Plant",	 "France",	"Toulouse-Blagnac",	122500,	5600000);
		BV.add(JLLA);
		BuildingVolume BCWC = new BuildingVolume(4,	"Boeing Composite Wing Center",	 "United States",	"Everett, Washington",	111500,	3700000);
		BV.add(BCWC);
		BuildingVolume AER = new BuildingVolume(5,	"Aerium",	 "Germany",	"Halbe, Brandenburg",	70000,	5200000);
		BV.add(AER);
		BuildingVolume MWD = new BuildingVolume(6,	"Meyer Werft Dockhalle 2",	"Germany",	"Papenburg, Niedersachsen",	63000,	4720000);
		BV.add(MWD);
		BuildingVolume NVA = new BuildingVolume(7,	"NASA Vehicle Assembly Building",	 "United States",	"Brevard County, Florida",	32374,	3660000);
		BV.add(NVA);
		BuildingVolume TO2 = new BuildingVolume(8,	"The O2",	"United Kingdom",	"London",	104634,	2790000);
		BV.add(TO2);
		BuildingVolume TIDC = new BuildingVolume(9,	"Tesco Ireland Distribution Centre",	 "Ireland",	"Donabate, Fingal",	80194,	1550000);
		BV.add(TIDC);
		BuildingVolume TIW = new BuildingVolume(10,	"Target Import Warehouse",	 "United States",	"Savannah, Georgia",	187664,	1500000);
		BV.add(TIW);
		return BV;
	}

	public ArrayList<BuildingFootprint> getBuildingFootprint(){
		ArrayList<BuildingFootprint> BF = new ArrayList<BuildingFootprint>();
		BuildingFootprint BTS = new BuildingFootprint(1,	"Aalsmeer Flower Auction",	 "Netherlands",	"Aalsmeer",	518000 );
		BF.add(BTS);
		BuildingFootprint TF = new BuildingFootprint(2,	"Tesla Factory",	 "United States",	"Fremont, California",	427354 );
		BF.add(TF);
		BuildingFootprint BEF = new BuildingFootprint(3,	"Boeing Everett Factory",	 "United States",	"Everett, Washington",	398000 );
		BF.add(BEF);
		BuildingFootprint MDC = new BuildingFootprint(4,	"Michelin Distribution Center",	 "United States",	"Spartanburg, South Carolina",	371612 );
		BF.add(MDC);
		BuildingFootprint GMM = new BuildingFootprint(5,	"Great Mosque of Mecca",	 "Saudi Arabia",	"Hijaz-Saudi Arabia",	356000  );
		BF.add(GMM);
		BuildingFootprint NNALC = new BuildingFootprint(6,	"Nike - North America Logistics Center",	 "United States",	"Memphis, Tennessee",	260000 );
		BF.add(NNALC);
		BuildingFootprint JDNAPDC = new BuildingFootprint(7,	"John Deere North American Parts Distribution Center",	 "United States",	"Milan, Illinois",	246000 );
		BF.add(JDNAPDC);
		BuildingFootprint MD = new BuildingFootprint(8,	"Mall of Dubai",	 "United Arab Emirates",	"Dubai",	500000 );
		BF.add(MD);
		BuildingFootprint MMNA = new BuildingFootprint(9,	"Mitsubishi Motors North America",	 "United States",	"Normal, Illinois",	220000 );
		BF.add(MMNA);
		BuildingFootprint ICE = new BuildingFootprint(10,	"Indonesia Convention Exhibition",	 "Indonesia",	"Bumi Serpong Damai",	220000 );
		BF.add(ICE);
		return BF;
	}
}
