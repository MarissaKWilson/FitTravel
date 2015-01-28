package com.marissakwilson.android.fittravel;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EditTripFragment extends Fragment {
	
	private Trip mTrip;
	private Button mNewStartingButton;
	private Button mNewEndingButton;
	private Button mNewTripButton;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mTrip = new Trip();
		}
	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		 View v = inflater.inflate(R.layout.fragment_edit_trip, parent, false);
		
		 mNewStartingButton = (Button)v.findViewById(R.id.button_new_starting);
		 mNewStartingButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		 mNewEndingButton = (Button)v.findViewById(R.id.button_new_ending);
		 mNewEndingButton.setOnClickListener(new View.OnClickListener(){
			 
			 @Override
			 public void onClick(View v){
				 
				 
			 }
			 
		 });
		 
		 mNewTripButton = (Button)v.findViewById(R.id.button_new_trip);
		 mNewTripButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		 });
		 
		 
		 return v;
	 }

}
