package com.qa.dvdLibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dvd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DVD_ID")
	private int dvdID;
	
	@Column(name = "Film_Title")
	private String title;
	
	@Column(name = "Genre")
	private String genre;
	
	@Column(name = "Release_Date")
	private int releaseDate;
	
	@Column(name = "Running_Time")
	private int runningTime;
	
	@Column(name = "BBFC_Rating")
	private String bbfcRating;
	
	@Column(name = "Main_Actress")
	private String leadingLady;
	
	@Column(name = "Main_Actor")
	private String leadingActor;
	
	
	public Dvd() {}


	public Dvd(String title, String genre, int releaseDate, int runningTime, String bbfcRating,
			String leadingLady, String leadingActor) {
		super();
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.bbfcRating = bbfcRating;
		this.leadingLady = leadingLady;
		this.leadingActor = leadingActor;
	}
	
	public Dvd(int dvdID, String title, String genre, int releaseDate, int runningTime, String bbfcRating,
			String leadingLady, String leadingActor) {
		super();
		this.dvdID = dvdID;
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.bbfcRating = bbfcRating;
		this.leadingLady = leadingLady;
		this.leadingActor = leadingActor;
	}

	public int getDvdID() {
		return dvdID;
	}


	public void setDvdID(int dvdID) {
		this.dvdID = dvdID;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}


	public int getRunningTime() {
		return runningTime;
	}


	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}


	public String getBbfcRating() {
		return bbfcRating;
	}


	public void setBbfcRating(String bbfcRating) {
		this.bbfcRating = bbfcRating;
	}


	public String getLeadingLady() {
		return leadingLady;
	}


	public void setLeadingLady(String leadingLady) {
		this.leadingLady = leadingLady;
	}


	public String getLeadingActor() {
		return leadingActor;
	}


	public void setLeadingActor(String leadingActor) {
		this.leadingActor = leadingActor;
	}


	@Override
	public String toString() {
		return "Dvd [dvdID=" + dvdID + ", title=" + title + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ ", runningTime=" + runningTime + ", bbfcRating=" + bbfcRating + ", leadingLady=" + leadingLady
				+ ", leadingActor=" + leadingActor + "]";
	}


}	