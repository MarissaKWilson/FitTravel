package com.marissakwilson.android.fittravel;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FitbitDetailFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		//Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_fitbit_detail, container, false);
//		Button connect = (Button) v.findViewById(R.id.button_connect_fitbit);
//		connect.setOnClickListener(this);
		return v;
	}
	
	public void connectFitbit(View view){
		Intent i = new Intent(getActivity(), OAuthActivity.class);
		startActivity(i);
	}
	
}
