package com.example.android.challengemestructure;

public class Course {
	private String typeCourse;
	private String dateCourse;
	private String heureCourse;
	private String distance;
	private String duree;
	private int iconID;

	public Course(String typeCourse, String dateCourse, String heureCourse,
			String distance, String duree, int iconID) {
		super();
		this.typeCourse = typeCourse;
		this.dateCourse = dateCourse;
		this.heureCourse = heureCourse;
		this.distance = distance;
		this.duree = duree;
		this.iconID = iconID;
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

}
