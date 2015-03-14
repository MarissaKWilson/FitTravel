package com.marissakwilson.android.fittravel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final String TAG = "FitTravel";
	private static final String KEY_FITBIT = "fitbit";
	
	Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "Main onCreate called");
		
		super.onCreate(savedInstanceState);
		
		
		
	}

}
