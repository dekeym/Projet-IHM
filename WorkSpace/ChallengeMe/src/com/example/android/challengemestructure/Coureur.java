package com.example.android.challengemestructure;

public class Coureur {
	String nomCoureur;
	String placeCoureur;
	String timeCoureur;
	
	public String getNomCoureur() {
		return nomCoureur;
	}
	public void setNomCoureur(String nomCoureur) {
		this.nomCoureur = nomCoureur;
	}
	public String getPlaceCoureur() {
		return placeCoureur;
	}
	public void setPlaceCoureur(String placeCoureur) {
		this.placeCoureur = placeCoureur;
	}
	public String getTimeCoureur() {
		return timeCoureur;
	}
	public void setTimeCoureur(String timeCoureur) {
		this.timeCoureur = timeCoureur;
	}
	public Coureur(String nomCoureur, String placeCoureur, String timeCoureur) {
		super();
		this.nomCoureur = nomCoureur;
		this.placeCoureur = placeCoureur;
		this.timeCoureur = timeCoureur;
	}
	
	
}
