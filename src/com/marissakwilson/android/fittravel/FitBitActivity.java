package com.marissakwilson.android.fittravel;

import java.util.ArrayList;

import com.marissakwilson.android.fittravel.oauth.AppMainThread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class FitbitActivity extends FragmentActivity {

	
	private FragmentManager fm;
	private FragmentTransaction ft;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fitbit);
		
		 ft = getSupportFragmentManager().beginTransaction();
	        if(savedInstanceState != null){
	        	return;
	        }
	        FitbitDetailFragment fitbitDetail = new FitbitDetailFragment();
	        fitbitDetail.setArguments(getIntent().getExtras());
	        ft.add(R.id.fitbit_info_container, fitbitDetail);
	        
	       
	        FitbitSyncFragment sync = new FitbitSyncFragment();
	        ft.add(R.id.sync_container, sync);
	        
	        FitbitDisconnectFragment disconnect = new FitbitDisconnectFragment();
	        ft.add(R.id.disconnect_container, disconnect);
	        
	        ft.commit();
		
		
	
		
	}
	
		public void beginOAuth(View view){
			Intent i = new Intent(this, com.marissakwilson.android.fittravel.oauth.AppMainThread.class);
			startActivity(i);
		}
	
		public void removeFitbit(View view){
			
		}
	
		
	
}
