package com.example.android.challengemestructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListTerritoires {
	List<Territoire> listTerritoires = new ArrayList<Territoire>();
	
	public ListTerritoires() {
		listTerritoires.add(new Territoire("Territoire#1", "2/3 d�fis remport�s"));
		listTerritoires.add(new Territoire("Territoire#2", "2/3  d�fis remport�s"));
		listTerritoires.add(new Territoire("Territoire#3", "4/6  d�fis remport�s"));
		listTerritoires.add(new Territoire("Territoire#4", "3/5  d�fis remport�s"));
		listTerritoires.add(new Territoire("Territoire#5", "3/3  d�fis remport�s"));	
	}
	
	public List<Territoire> getListTerritoires() {
		return listTerritoires;
	}
}
