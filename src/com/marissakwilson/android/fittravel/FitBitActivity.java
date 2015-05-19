package com.marissakwilson.android.fittravel;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class FitbitActivity extends FragmentActivity {

	private static final String CLIENT_KEY = "be70df3c413b4154b72498c4e0f56936";
	private static final String CLIENT_SECRET_KEY = "7d3b4bf3fae84867951f5c3f2c9d97e1";
	
	
//	private static final String FILENAME = "tripData.json";
//	private static final String JSON_ID = "id";
//	private static final String JSON_TITLE = "title";
//	private static final String JSON_SOLVED = "solved";
//	
	private Button mConnectFitbit;
	private Button mSyncFitbit;
	private Button mClearFitbit;
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
			Intent i = new Intent(this, OAuthActivity.class);
		}
	
	
	public void getOAuthInfo(){
		
		
	}


	public ArrayList getArray() {
		ArrayList tmp = new ArrayList();
		
		return tmp;
	}


	public Object toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
