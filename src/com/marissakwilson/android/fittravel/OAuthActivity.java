package com.marissakwilson.android.fittravel;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class OAuthActivity extends FragmentActivity{

	private static final String CLIENT_KEY = "be70df3c413b4154b72498c4e0f56936";
	private static final String CLIENT_SECRET_KEY = "7d3b4bf3fae84867951f5c3f2c9d97e1";
	
	
	private static final String FILENAME = "tripData.json";
	private static final String JSON_ID = "id";
	private static final String JSON_TITLE = "title";
	private static final String JSON_SOLVED = "solved";
	
	private Button mConnectFitbit;
	private Button mSyncFitbit;
	private Button mClearFitbit;
	
//	private OAuthManager oam;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oauth);
		
		
		mConnectFitbit = (Button)findViewById(R.id.button_connect_fitbit);
		mConnectFitbit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getOAuthInfo();
			}
		});
		
		mSyncFitbit = (Button)findViewById(R.id.button_connect_fitbit);
		
		mClearFitbit = (Button)findViewById(R.id.button_clear_fitbit);
	
		
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
