package com.example.android.challengemestructure;

import java.util.ArrayList;
import java.util.List;

import com.example.android.navigationdrawerexample.R;


public class ListCourses {
	List<Course> listeCourses = new ArrayList<Course>();
	
	public ListCourses(String type){
		if (type == "train") {
			listeCourses.add(new Course("course#1", "defi", "12/12/2014", "17:30", "07km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#2", "defi", "12/12/2014", "17:30", "02km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#3", "defi", "12/12/2014", "17:30", "03km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#4", "defi", "12/12/2014", "17:30", "04km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#5", "defi", "12/12/2014", "17:30", "05km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#6", "defi", "12/12/2014", "17:30", "07km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#7", "defi", "12/12/2014", "17:30", "02km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#8", "defi", "12/12/2014", "17:30", "03km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#9", "defi", "12/12/2014", "17:30", "04km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#10", "defi", "12/12/2014", "17:30", "05km", "00:31:00", R.drawable.run));
		} else if (type == "compet") {
			listeCourses.add(new Course("course#1", "defi", "12/12/2014", "17:30", "07km", "00:31:00", R.drawable.compet, "-00:06:32", true, "Johny"));
			listeCourses.add(new Course("course#2", "defi", "12/12/2014", "17:30", "02km", "00:31:00", R.drawable.compet, "+00:06:32", false, "Arthur"));
			listeCourses.add(new Course("course#3", "defi", "12/12/2014", "17:30", "03km", "00:31:00", R.drawable.compet, "+00:06:32", false, "Jackie"));
			listeCourses.add(new Course("course#4", "defi", "12/12/2014", "17:30", "04km", "00:31:00", R.drawable.compet, "-00:06:32", true, "David"));
			listeCourses.add(new Course("course#5", "defi", "12/12/2014", "17:30", "05km", "00:31:00", R.drawable.compet, "-00:06:32", true, "Alexia"));
		} else {
			listeCourses.add(new Course("course#1", "defi", "12/12/2014", "17:30", "07km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#2", "defi", "12/12/2014", "17:30", "02km", "00:31:00", R.drawable.compet));
			listeCourses.add(new Course("course#3", "defi", "12/12/2014", "17:30", "03km", "00:31:00", R.drawable.compet));
			listeCourses.add(new Course("course#4", "defi", "12/12/2014", "17:30", "04km", "00:31:00", R.drawable.run));
			listeCourses.add(new Course("course#5", "defi", "12/12/2014", "17:30", "05km", "00:31:00", R.drawable.run));
		}
		
	}
		
	public List<Course> getListeCourses(){
		return listeCourses;
	}
}