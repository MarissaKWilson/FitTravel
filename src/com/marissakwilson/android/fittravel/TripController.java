package com.marissakwilson.android.fittravel;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;

public class TripController {

	private static final String DIALOG_START = "starting";
	private static final String DIALOG_END = "ending";
	
	private static final String FILENAME = "tripData.json";
	
	
	private Trip mTrip;
	private EditText mStartingLocalField;
	private EditText mEndingLocalField;
	private CheckBox mMetricCheck;
	SharedPreferences mPrefs;

	
	
	public TripController(){
//		mPrefs = getActivity().getPreferences( Context.MODE_PRIVATE);
	}

	public void saveTrip(Trip mTrip){
		Editor prefsEditor = mPrefs.edit();
	    Gson gson = new Gson();
	    String json = gson.toJson(mTrip);
	    prefsEditor.putString("MyTrip", json);
	    prefsEditor.commit();
	}
	
	public Trip loadTrip(){
		Gson gson = new Gson();
	    String json = mPrefs.getString("MyTrip", "");
	    Trip t = gson.fromJson(json, Trip.class);
	    return t;
	}
	
}
