package com.example.android.challengeme;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.challengemestructure.Course;
import com.example.android.navigationdrawerexample.R;

public class MyListAdapter extends ArrayAdapter<Course> {
	Context context;
	private int layoutResourceId;
	List<Course> listeCourses;
	
	public MyListAdapter(Context context, int resource, List<Course> list) {
		super(context, resource, list);
		this.context = context;
		this.listeCourses = list;
		this.layoutResourceId = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Make sure we have a view to work with
		View itemView = convertView;
		
		if (itemView == null ) {
			LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(layoutResourceId, parent, false);
		}
		
		ImageView image = (ImageView) itemView.findViewById(R.id.imageView1);
		TextView distance = (TextView) itemView.findViewById(R.id.distance);
		TextView date = (TextView) itemView.findViewById(R.id.date);
		TextView timevar = (TextView) itemView.findViewById(R.id.timevar);
		TextView time = (TextView) itemView.findViewById(R.id.time);
		
		// find the car to work with
		Course currentCourse = listeCourses.get(position);
		
		image.setImageResource(currentCourse.getIconID());
		date.setText(currentCourse.getDateCourse());
		distance.setText(currentCourse.getDistance());
		timevar.setText(currentCourse.getDuree());
		time.setText(currentCourse.getHeureCourse());
		
		return itemView;
	}
}
