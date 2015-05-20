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


public class AppContext {

	public static final boolean DEBUG = LOGGING.DEBUG;// enable/disable logging

		public static final String WARENINJAAPPS_MARKET_URL = "market://search?q=wareninja";
		public static final String AMAZON_WARENINJAAPPS_MARKET_URL = 
			"http://www.amazon.com/gp/mas/dl/android?p=com.wareninja.android.loco&showAll=1";
	
	public static final String APPWEBSITE_URL = "http://www.WareNinja.net";
	
	public static final String GRAPH_BASE_URL = "http://graph.facebook.com/";
	public static final String GRAPH_BASE_URL_SSL = "https://graph.facebook.com/";
	
	// REGISTER to these bcast identifiers and you will get login response together with its payload as json (INTENT_EXTRA_...)!!!
	public static final String INTENT_EXTRA_USERLOGIN_FSQ = "USERLOGIN_FSQ";
    public static final String BCAST_USERLOGIN_FSQ = "com.wareninja.android.opensource.oauth2login.BCAST_USERLOGIN_FSQ";
    public static final String INTENT_EXTRA_USERLOGIN_FACEBOOK = "USERLOGIN_FACEBOOK";
    public static final String BCAST_USERLOGIN_FACEBOOK = "com.wareninja.android.opensource.oauth2login.BCAST_USERLOGIN_FACEBOOK";
    public static final String INTENT_EXTRA_USERLOGIN_FITBIT = "USERLOGIN_FITBIT";
    public static final String BCAST_USERLOGIN_FITBIT = "com.marissakwilson.android.fittravel.BCAST_USERLOGIN_FITBIT";

    
    public static final String INTENT_EXTRA_USERLOGOUT_FSQ = "USERLOGOUT_FSQ";
    public static final String BCAST_USERLOGOUT_FSQ = "com.wareninja.android.opensource.oauth2login.BCAST_USERLOGOUT_FSQ";
    public static final String INTENT_EXTRA_USERLOGOUT_FACEBOOK = "USERLOGOUT_FACEBOOK";
    public static final String BCAST_USERLOGOUT_FACEBOOK = "com.wareninja.android.opensource.oauth2login.BCAST_USERLOGOUT_FACEBOOK";
    public static final String INTENT_EXTRA_USERLOGOUT_GOWALLA = "USERLOGOUT_GOWALLA";
    public static final String BCAST_USERLOGOUT_GOWALLA = "com.wareninja.android.opensource.oauth2login.BCAST_USERLOGOUT_GOWALLA";
	
	//public static final String APP_CACHEDIR = ".WareNinja_OpenSource_appCache";
		
	
	
	// Fitbit App Params
	public static final String FITBIT_APP_ID = "229L36"; 
	public static final String FITBIT_RESPONSE_TYPE = "code";
	public static final String[] FITBIT_SCOPES = new String[] {
	/* 
	 * Only activtiy and profile are needed but currently
	 * fitbit requires all scopes.
	 */
		"activity", "nutrition", "profile", "settings", "sleep", "social", "weight"
		}; 
	public static final String FITBIT_APP_CALLBACK_OAUTHCALLBACK = "https://github.com/MarissaKWilson/FitTravel";// YOURAPP_REDIRECT_URI; 
	public static final String FITBIT_APP_OAUTH_BASEURL = "https://www.fitbit.com";
	public static final String FITBIT_APP_OAUTH_URL = "/oauth2/authorize/";
	public static final String FITBIT_APP_REFRESH_URL = "/oauth2/token";
	public static String code;

	
	

	public enum COMMUNITY {
		FACEBOOK, FOURSQUARE, GOWALLA
		, TWILIO
		, INSTAGRAM
	}

}
