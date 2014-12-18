package com.example.android.challengeme;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.challengemestructure.Course;
import com.example.android.navigationdrawerexample.R;

public class MyListAdapterDefisAutour extends ArrayAdapter<Course> {
	Context context;
	private int layoutResourceId;
	List<Course> listeDefis;
	
	public MyListAdapterDefisAutour(Context context, int resource, List<Course> list) {
		super(context, resource, list);
		this.context = context;
		this.listeDefis = list;
		this.layoutResourceId = resource;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {

		View itemView = convertView;
		
		if (itemView == null ) {
			LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(layoutResourceId, parent, false);
		}

		ImageView image = (ImageView) itemView.findViewById(R.id.rowLD2Image);
		TextView tempsCourse = (TextView) itemView.findViewById(R.id.rowLD2DiffTempsCourse);
		TextView createur = (TextView) itemView.findViewById(R.id.createur);
		TextView status = (TextView) itemView.findViewById(R.id.rowLD2statut);
		
		// find the car to work with
		Course currentCourse = listeDefis.get(position);
		
		image.setImageResource(currentCourse.getIconID());
		tempsCourse.setText(currentCourse.getDuree());
		createur.setText(currentCourse.getCreateur());
		if(currentCourse.getDefiReussi()) {
			status.setText("Réussi");
			status.setBackgroundColor(Color.argb(255, 62, 174, 28));
		} else {
			status.setText("");
			status.setBackgroundResource(0);
		}
					
		return itemView;
	}
}
