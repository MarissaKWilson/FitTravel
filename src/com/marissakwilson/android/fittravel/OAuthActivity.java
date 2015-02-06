package com.marissakwilson.android.fittravel;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class OAuthActivity extends FragmentActivity{

	private static final String CLIENT_KEY = "be70df3c413b4154b72498c4e0f56936";
	private static final String CLIENT_SECRET_KEY = "7d3b4bf3fae84867951f5c3f2c9d97e1";
	
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
	
}
