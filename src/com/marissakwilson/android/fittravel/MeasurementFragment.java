package com.marissakwilson.android.fittravel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MeasurementFragment extends Fragment {

	CheckBox mMetricCheck;
	Trip mTrip;
	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		 View v = inflater.inflate(R.layout.fragment_edit_trip, parent, false);
		 
		 mMetricCheck =(CheckBox)v.findViewById(R.id.metric_checkbox);
		 mMetricCheck.setChecked(mTrip.isMetric());
		 mMetricCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	                mTrip.setMetric(isChecked);
	            }
		 });
		 
		return v; 
	 }
	
}
