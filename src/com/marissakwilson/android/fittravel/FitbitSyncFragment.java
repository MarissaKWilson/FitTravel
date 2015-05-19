package com.marissakwilson.android.fittravel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FitbitSyncFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		//Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_syncfitbit, container, false);
//		Button connect = (Button) v.findViewById(R.id.button_connect_fitbit);
//		connect.setOnClickListener(this);
		return v;
	}

}
