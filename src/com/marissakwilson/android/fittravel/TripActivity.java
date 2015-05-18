package com.marissakwilson.android.fittravel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

public class TripActivity extends FragmentActivity {

	private Trip mTrip;
	private FitBit mFitbit;
	private final double KM_IN_MILE =1.60934;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trip);
		
	}
	
	
	

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.settings, menu);
//		return true;
//	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}
	
	public int convertMetric(double distance){
		if(mTrip.isMetric()!=true){
			return (int) (distance/KM_IN_MILE);
		}
		else{
			return (int) distance;
		}
	}
	
	public int convertToSteps(double distance){
		return (int) (distance*mFitbit.getStrideLength());
	}

	
	
}
