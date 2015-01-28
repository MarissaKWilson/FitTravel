package com.marissakwilson.android.fittravel;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class EditTripFragment extends Fragment {
	
	private Trip mTrip;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mTrip = new Trip();
		}

}
