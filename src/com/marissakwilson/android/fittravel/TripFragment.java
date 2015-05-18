package com.marissakwilson.android.fittravel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TripFragment extends Fragment implements ISetTextInFragments {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		//Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_trip, container, false);
	}
	
	
	 public void setText(String text1, String text2) {
	        TextView t = (TextView) getView().findViewById(R.id.firstLine);  //UPDATE
	        t.setText(text1);
	        
	        TextView d = (TextView) getView().findViewById(R.id.secondLine);
	        d.setText(text2);
	    }

}
