package com.marissakwilson.android.fittravel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ToggleButton;

public class TripFragment extends Fragment {

	private Trip mSetting;
	private ToggleButton mDefaultToggle;
	private boolean metric;
	private CheckBox mMetricCheck;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.activity_trip,parent, false);
		
		mMetricCheck = (CheckBox)v.findViewById(R.id.metric_checkbox);
		
		return v;
	}
}
