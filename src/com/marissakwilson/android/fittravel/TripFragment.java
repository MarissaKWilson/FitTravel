package com.marissakwilson.android.fittravel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ToggleButton;

public class TripFragment extends Fragment {

	private static final String DIALOG_START = "starting";
	private static final String DIALOG_END = "ending";
	
	private static final String FILENAME = "tripData.json";
	
	
	private Trip mTrip;
	private ToggleButton mDefaultToggle;
	private boolean metric;
	private CheckBox mMetricCheck;
	private Button mLocationA;
	private Button mLocationB;
	
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.activity_trip,parent, false);
		
		mMetricCheck = (CheckBox)v.findViewById(R.id.metric_checkbox);
		mMetricCheck.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				//Fill in functionality
			}
		});
		
		mLocationA = (Button)v.findViewById(R.id.button_change_starting);
		mLocationA.setText(mTrip.getLocationA().toString());
		mLocationA.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				FragmentManager fm = getActivity().getSupportFragmentManager();
				LocationPickerFragment dialog = new LocationPickerFragment();
				dialog.show(fm, DIALOG_START);
			}
		});
		
		mLocationB = (Button)v.findViewById(R.id.button_change_ending);
		mLocationB.setText(mTrip.getLocationB().toString());
		mLocationB.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				FragmentManager fm = getActivity().getSupportFragmentManager();
				LocationPickerFragment dialog = new LocationPickerFragment();
				dialog.show(fm, DIALOG_END);
			}
		});
		
		
		return v;
	}
}
