package com.marissakwilson.android.fittravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class SplashActivity extends FragmentActivity {

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		FileHandler fh = new FileHandler(this);
		
		Trip t = fh.readTrip();
		Fitbit f = fh.readFitbit();
		if(t!=null && f!=null){
			Intent i = new Intent(this, MenuActivity.class);
			startActivity(i);
		}
		else{

			Intent i = new Intent(this, MenuActivity.class);
			startActivity(i);
		}
	}
	
}
