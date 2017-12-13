package uk.ac.belfastmet.springukcharts.domain;

public class Song {
	private int rank;
	private String songName;
	private String artist;
	private String youtubeLink;
	private String image;
	
	public Song(int rank, String songName, String artist, String youtubeLink, String image) {
		super();
		this.rank = rank;
		this.songName = songName;
		this.artist = artist;
		this.youtubeLink = youtubeLink;
		this.image = image;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getYoutubeLink() {
		return youtubeLink;
	}
	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
