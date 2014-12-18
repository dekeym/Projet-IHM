package com.example.android.challengeme;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.challengemestructure.Territoire;
import com.example.android.navigationdrawerexample.R;

public class MyListAdapterTerritoire extends ArrayAdapter<Territoire> {
	Context context;
	private int layoutResourceId;
	List<Territoire> listeTerritoires;
	
	public MyListAdapterTerritoire(Context context, int resource, List<Territoire> list) {
		super(context, resource, list);
		this.context = context;
		this.listeTerritoires = list;
		this.layoutResourceId = resource;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {

		View itemView = convertView;
		
		if (itemView == null ) {
			LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(layoutResourceId, parent, false);
		}

		TextView nom = (TextView) itemView.findViewById(R.id.rowTnameTer);
		TextView defis = (TextView) itemView.findViewById(R.id.rowTdefR);
		
		// find the car to work with
		Territoire currentTerritoire = listeTerritoires.get(position);
		
		nom.setText(currentTerritoire.getNomTerritoire());
		defis.setText(currentTerritoire.getNbreTerritoireControle());
					
		return itemView;
	}
}
