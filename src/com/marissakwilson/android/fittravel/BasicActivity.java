package com.marissakwilson.android.fittravel;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class BasicActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        ft.add(R.id.fitbitcontainer, new NewFitbitFragment());
        ft.add(R.id.tripcontainer, new NewTripFragment());
        ft.add(R.id.metriccontainer, new MetricFragment());
        
        ft.commit();
        
    }
	
}
