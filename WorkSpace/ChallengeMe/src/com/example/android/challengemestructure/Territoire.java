package com.example.android.challengemestructure;

public class Territoire {
	private String nomTerritoire;
	private String nbreTerritoireControle;
	
	public String getNomTerritoire() {
		return nomTerritoire;
	}
	public void setNomTerritoire(String nomTerritoire) {
		this.nomTerritoire = nomTerritoire;
	}
	public String getNbreTerritoireControle() {
		return nbreTerritoireControle;
	}
	public void setNbreTerritoireControle(String nbreTerritoireControle) {
		this.nbreTerritoireControle = nbreTerritoireControle;
	}
	public Territoire(String nomTerritoire, String nbreTerritoireControle) {
		super();
		this.nomTerritoire = nomTerritoire;
		this.nbreTerritoireControle = nbreTerritoireControle;
	}
	
}
