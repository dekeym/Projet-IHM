package com.example.android.challengemestructure;

public class Course {
	private String idCourse;
	private String typeCourse;
	private String dateCourse;
	private String heureCourse;
	private String distance;
	private String duree;
	private int iconID;
	private String diffTime;
	private Boolean defiReussi;
	private String createur;
	
	public Course(String idCourse, String typeCourse, String dateCourse,
			String heureCourse, String distance, String duree, int iconID) {
		super();
		this.idCourse = idCourse;
		this.typeCourse = typeCourse;
		this.dateCourse = dateCourse;
		this.heureCourse = heureCourse;
		this.distance = distance;
		this.duree = duree;
		this.iconID = iconID;
	}
	
	public Course(String idCourse, String typeCourse, String dateCourse,
			String heureCourse, String distance, String duree, int iconID, String diffTime, Boolean defiReussi, String createur) {
		super();
		this.idCourse = idCourse;
		this.typeCourse = typeCourse;
		this.dateCourse = dateCourse;
		this.heureCourse = heureCourse;
		this.distance = distance;
		this.duree = duree;
		this.iconID = iconID;
		this.diffTime = diffTime;
		this.defiReussi = defiReussi;
		this.createur = createur;
	}

	public String getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	public String getTypeCourse() {
		return typeCourse;
	}

	public void setTypeCourse(String typeCourse) {
		this.typeCourse = typeCourse;
	}

	public String getDateCourse() {
		return dateCourse;
	}

	public void setDateCourse(String dateCourse) {
		this.dateCourse = dateCourse;
	}

	public String getHeureCourse() {
		return heureCourse;
	}

	public void setHeureCourse(String heureCourse) {
		this.heureCourse = heureCourse;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public int getIconID() {
		return iconID;
	}

	public void setIconID(int iconID) {
		this.iconID = iconID;
	}

	public String getDiffTime() {
		return diffTime;
	}

	public void setDiffTime(String diffTime) {
		this.diffTime = diffTime;
	}

	public Boolean getDefiReussi() {
		return defiReussi;
	}

	public void setDefiReussi(Boolean defiReussi) {
		this.defiReussi = defiReussi;
	}

	public String getCreateur() {
		return createur;
	}

	public void setCreateur(String createur) {
		this.createur = createur;
	}
	
}
