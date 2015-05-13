package com.marissakwilson.android.fittravel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class TripController extends Fragment {

	private static final String DIALOG_START = "starting";
	private static final String DIALOG_END = "ending";
	
	private static final String FILENAME = "tripData.json";
	
	
	private Trip mTrip;
	private EditText mStartingLocalField;
	private EditText mEndingLocalField;
	private CheckBox mMetricCheck;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mTrip = new Trip();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_trip, parent, false);
		
//		mStartingLocalField = (EditText)v.findViewById(R.id.trip_starting_string);
//		mStartingLocalField.addTextChangedListener(new TextWatcher(){
//			public void onTextChanged(CharSequence c, int start, int before, int count){
//				mTrip.setstrLocA(c.toString());
//			}
//			
//			public void beforeTextChanged(CharSequence c, int start, int count, int after){
//				//intentionally left blank
//			}
//			
//			public void afterTextChanged(Editable c){
//				//intentionally left blank
//			}
//		});
//		
//		mEndingLocalField = (EditText)v.findViewById(R.id.trip_ending_string);
//		mEndingLocalField.addTextChangedListener(new TextWatcher(){
//			public void onTextChanged(CharSequence c, int start, int before, int count){
//				mTrip.setstrLocB(c.toString());
//			}
//			
//			public void beforeTextChanged(CharSequence c, int start, int count, int after){
//				//intentionally left blank
//			}
//			
//			public void afterTextChanged(Editable c){
//				//intentionally left blank
//			}
//			
//		});
//		
//		mMetricCheck = (CheckBox)v.findViewById(R.id.metric_checkbox);
//		mMetricCheck.setOnCheckedChangeListener(new OnCheckedChangeListener(){
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
//				mTrip.setMetric(isChecked);
//			}
//		});
//		
		return v;
	}
	
}
