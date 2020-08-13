package uk.ac.belfastmet.springukcharts.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import uk.ac.belfastmet.springukcharts.domain.Song;

@Service
public class SongService {
	
	public SongService() {
		
	}
	
	public ArrayList<Song> getCharts(){
		ArrayList<Song> top10Charts = new ArrayList<Song>();
		Song havana = new Song(1,"Havana (feat. Young Thug", "Camila Cabello", "https://www.youtube.com/watch?v=BQ0mxQXmLsk", "1.jpg");
		top10Charts.add(havana);
		Song anywhere = new Song(2,"Anywhere", "Rita Ora", "https://www.youtube.com/watch?v=ksdAs4LBRq8", "2.jpg");
		top10Charts.add(anywhere);
		Song silence = new Song(3,"Silence (feat. Khalid)", "marshmello", "https://www.youtube.com/watch?v=tk36ovCMsU8", "3.jpg");
		top10Charts.add(silence);
		Song perfect = new Song(4,"Perfect", "Ed Sheeran", "https://www.youtube.com/watch?v=2Vv-BfVoq4g", "4.jpg");
		top10Charts.add(perfect);
		Song tooGoodAtGoodbyes = new Song(5,"Too Good At Goodbyes", "Sam Smith", "https://www.youtube.com/watch?v=J_ub7Etch2U", "5.jpg");
		top10Charts.add(tooGoodAtGoodbyes);
		Song mansNotHot = new Song(6,"Man's Not Hot", "Big Shaq", "https://www.youtube.com/watch?v=3M_5oYU-IsU", "6.jpg");
		top10Charts.add(mansNotHot);
		Song blindedByYourGrace = new Song(7,"Blinded By Your Grace, Pt. 2 (feat. MNEK)", "Stormzy", "https://www.youtube.com/watch?v=08wPCYCUuCQ", "7.jpg");
		top10Charts.add(blindedByYourGrace);
		Song rockstar = new Song(8,"rockstar (feat. 21 Savage)", "Post Malone", "https://www.youtube.com/watch?v=4GFAZBKZVJY", "8.jpg");
		top10Charts.add(rockstar);
		Song wolves = new Song(9,"Wolves", "Selena Gomez & marshmello", "https://www.youtube.com/watch?v=-grLLLTza6k", "9.jpg");
		top10Charts.add(wolves);
		Song duskTilDawn = new Song(10,"Dusk Till Dawn (feat. Sia)", "ZAYN", "https://www.youtube.com/watch?v=tt2k8PGm-TI", "10.jpg");
		top10Charts.add(duskTilDawn);
		return top10Charts;
	}

}
