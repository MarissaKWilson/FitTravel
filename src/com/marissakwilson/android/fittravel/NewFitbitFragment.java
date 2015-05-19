package com.marissakwilson.android.fittravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class NewFitbitFragment extends Fragment implements OnClickListener {

	Button connect;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		//Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_new_fitbit, container, false);
		connect = (Button) v.findViewById(R.id.button_connect_fitbit);
		connect.setOnClickListener(this);
		return v;
	}

	@Override
	public void onClick(View arg0) {
		Intent i = new Intent(getActivity(), OAuthActivity.class);
        startActivity(i);
        
		
	}
}
