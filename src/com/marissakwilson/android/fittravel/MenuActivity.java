package com.marissakwilson.android.fittravel;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuActivity extends FragmentActivity{
		FragmentManager fm;
		FragmentTransaction ft;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        if(savedInstanceState != null){
        	return;
        }
        NewFitbitFragment newFitbit = new NewFitbitFragment();
        newFitbit.setArguments(getIntent().getExtras());
        ft.add(R.id.fitbitcontainer, newFitbit);
        
        NewTripFragment newTrip = new NewTripFragment();
        newTrip.setArguments(getIntent().getExtras());
        ft.add(R.id.tripcontainer, newTrip);
        
        MetricFragment metric = new MetricFragment();
        metric.setArguments(getIntent().getExtras());
        ft.add(R.id.metriccontainer, metric);
        
        ft.commit();
        
        replaceFragments();
        
    }
    
    public void replaceFragments(){
    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	FileHandler fh = new FileHandler(this.getApplicationContext());
    	
    	Trip t = new Trip();
    	t.setLocationA(42.36, -71.05);
    	t.setLocationB(48.85, 2.35);
    	t.setTotalDistance();
    	t.setCurrentDistance(205);
    	
    	fh.writeTrip(t);
    	
    	Trip r = fh.readTrip();
    	
    	String text1 = "Your trip from " + r.locBToString() + " to " + r.locAToString() + ".";
    	String text2 = "So far " + r.getCurrentDistance() + "/" + r.getTotalDistance();
    	
    	TripFragment trip = new TripFragment();
    	trip.setText(text1, text2);
    	
    	transaction.replace(R.id.fitbitcontainer, trip);
    	transaction.commit();
    	//if(FileHandler.nullTrip == false){
    	//	Trip t = FileHandler.readTrip();
    	//	transaction.replace(R.id.fragment_container, TripFragment);
    }
    

	
}
