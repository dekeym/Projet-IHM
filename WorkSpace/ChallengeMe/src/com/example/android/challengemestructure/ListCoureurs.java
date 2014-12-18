package com.example.android.challengemestructure;

import java.util.ArrayList;
import java.util.List;

public class ListCoureurs {
	List<Coureur> listeCoureurs = new ArrayList<Coureur>();
	
	public ListCoureurs(){
		listeCoureurs.add(new Coureur("Stéphane", "#1", "  00:34:07"));
		listeCoureurs.add(new Coureur("Eddy", "#2", "+00:01:07"));
		listeCoureurs.add(new Coureur("Camille", "#3", "+00:02:07"));
		listeCoureurs.add(new Coureur("Jérémy", "#4", "+00:03:07"));
		listeCoureurs.add(new Coureur("Brice", "#5", "+00:04:07"));
		listeCoureurs.add(new Coureur("Myriam", "#6", "+00:05:07"));
		listeCoureurs.add(new Coureur("Félix", "#7", "+00:06:07"));
		listeCoureurs.add(new Coureur("Pelatan", "#8", "+00:07:07"));
		listeCoureurs.add(new Coureur("Etienne", "#9", "+00:08:07"));
		listeCoureurs.add(new Coureur("Farid", "#10", "+00:09:07"));
		listeCoureurs.add(new Coureur("Flora", "#11", "+00:10:07"));
	}
	
	public List<Coureur> getListeCoureurs(){
		return listeCoureurs;
	}
}
