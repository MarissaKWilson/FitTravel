package com.marissakwilson.android.fittravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MenuActivity extends FragmentActivity{
		FragmentManager fm;
		FragmentTransaction ft;
		NewFitbitFragment fitbit;
		TripFragment trip;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_menu);
        
        ft = getSupportFragmentManager().beginTransaction();
        if(savedInstanceState != null){
        	return;
        }
        NewFitbitFragment newFitbit = new NewFitbitFragment();
        newFitbit.setArguments(getIntent().getExtras());
        ft.add(R.id.fitbitcontainer, newFitbit);
        
       
        trip = new TripFragment();
        trip.setArguments(getIntent().getExtras());
        ft.add(R.id.tripcontainer, trip);
        
        MetricFragment metric = new MetricFragment();
        metric.setArguments(getIntent().getExtras());
        ft.add(R.id.metriccontainer, metric);
        
        ft.commit();
        
//        replaceFragments();
        
    }
    public void beginTripDetail(View view){
		 Intent i = new Intent(this, TripActivity.class);
		 startActivity(i);
	 }
    

//    
//    public void replaceFragments(){
//    	FileHandler fh = new FileHandler(this.getBaseContext());
//    	
//    	Trip t = new Trip();
//    	t.setLocationA(42.36, -71.05);
//    	t.setLocationB(48.85, 2.35);
//    	t.setTotalDistance();
//    	t.setCurrentDistance(205);
//    	
//    	fh.writeTrip(t);
//    	
//    	Trip r = fh.readTrip();
//    	
//    	String text1 = "Your trip from " + r.locBToString() + " to " + r.locAToString() + ".";
//    	String text2 = "So far " + r.getCurrentDistance() + "/" + r.getTotalDistance();
//    	View v = findViewById(R.id.fragment_trip);
//    	trip.setText(text1, text2, v);
    	
//    	TripFragment tripFrag = (TripFragment)getSupportFragmentManager().
//                findFragmentById(R.id.fragment_trip);
//    	tripFrag.setText(text1, text2, v);
//    	
//    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	
//    	transaction.replace(R.id.fitbitcontainer, trip);
//    	transaction.commit();
    	//if(FileHandler.nullTrip == false){
    	//	Trip t = FileHandler.readTrip();
    	//	transaction.replace(R.id.fragment_container, TripFragment);
//    }
    

	
}
