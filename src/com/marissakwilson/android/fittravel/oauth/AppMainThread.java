/***
	Copyright (c) 2011-2012 WareNinja.com 
	http://www.WareNinja.com - https://github.com/WareNinja
	
	Author: yg@wareninja.com / twitter: @WareNinja

  Licensed under the Apache License, Version 2.0 (the "License"); you may
  not use this file except in compliance with the License. You may obtain
  a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  
  >> Summary of the license:
  	You are allowed to re-use this code as you like, no kittens should be harmed though! 
 */


package com.marissakwilson.android.fittravel.oauth;

import java.util.HashMap;
import java.util.Map;

import com.marissakwilson.android.fittravel.oauth.GenericDialogListener;
import com.marissakwilson.android.fittravel.oauth.LOGGING;
import com.marissakwilson.android.fittravel.oauth.AppContext;
import com.marissakwilson.android.fittravel.oauth.NotifierHelper;
import com.marissakwilson.android.fittravel.oauth.WebService;
import com.marissakwilson.android.fittravel.oauth.FitbitOAuthDialog;
import com.marissakwilson.android.fittravel.R;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

public class AppMainThread extends Activity {
    
	protected static final String TAG = "AppMainExample";
	
	public Context mContext;
	public Activity mActivity;
	public WebService webService;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mContext = this;
        mActivity = this;
        setContentView(R.layout.activity_fitbit_oauth);
    }
    
    
    
  
    public void onClick_fitbitLogin(View v) {
		//NotifierHelper.displayToast(mContext, "TODO: onClick_instagramLogin", NotifierHelper.SHORT_TOAST);
		// http://instagram.com/developer/authentication/#
		
    	webService = new WebService();
    	
    	String authRequestRedirect = AppContext.FITBIT_APP_OAUTH_BASEURL+AppContext.FITBIT_APP_OAUTH_URL
		        + "?client_id="+AppContext.FITBIT_APP_ID
		        + "&response_type=code" 
		        + "&display=touch"
		        + "&scope=" + TextUtils.join("+", AppContext.FITBIT_SCOPES)
		        + "&redirect_uri="+AppContext.FITBIT_APP_CALLBACK_OAUTHCALLBACK
		        ;
		if(LOGGING.DEBUG)Log.d(TAG, "authRequestRedirect->"+authRequestRedirect);
		
		new FitbitOAuthDialog(mContext, authRequestRedirect
				, new GenericDialogListener() {
			public void onComplete(Bundle values) {
				if(LOGGING.DEBUG)Log.d(TAG, "onComplete->"+values);
				// http://your-redirect-uri#access_token=....
				// onComplete->Bundle[{access_token=<ACCESS_TOKEN>}]
/*
if user ALLOWs your app -> Bundle[{access_token=<ACCESS_TOKEN>}]
if user doesNOT ALLOW -> Bundle[{error=access_denied, error_description=The+user+denied+your+request}]
 */

				
				String tokenResponse = "";
				try{
					
					tokenResponse = values.toString();
					
					broadcastLoginResult(AppContext.COMMUNITY.INSTAGRAM, tokenResponse);

				}
				catch (Exception ex1){
					Log.w(TAG, ex1.toString());
					tokenResponse = null;
				}
		    }
			public void onError(String e) {
				if(LOGGING.DEBUG)Log.d(TAG, "onError->"+e);
		    }
			public void onCancel() {
				if(LOGGING.DEBUG)Log.d(TAG, "onCancel()");
		    }
		}).show();
	}
    
    	
	
	private void broadcastLoginResult(AppContext.COMMUNITY community, String payload) {
		
		String intentAction = "";
		String intentExtra = "";
		try {
			
			intentAction = AppContext.BCAST_USERLOGIN_FITBIT;
			intentExtra = AppContext.INTENT_EXTRA_USERLOGIN_FITBIT;
			
			if(LOGGING.DEBUG)Log.d(TAG, "sending Broadcast! " 
					+ "|intentAction->"+intentAction
					+ "|intentExtra->"+intentExtra
					+ "|payload->"+payload
					);
			
			Intent mIntent = new Intent();
        	mIntent.setAction(intentAction);
        	mIntent.putExtra(intentExtra, payload);
        	this.sendBroadcast(mIntent);
		}
    	catch (Exception ex) {
    		Log.w(TAG, ex.toString());
    	}
    	
	}
	
}