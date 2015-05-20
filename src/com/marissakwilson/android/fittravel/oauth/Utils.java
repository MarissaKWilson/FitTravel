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

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;


public final class Utils {
	
	protected static final String TAG = "Utils";

    /**
     * Generate the multi-part post body providing the parameters and boundary
     * string
     * 
     * @param parameters the parameters need to be posted
     * @param boundary the random string as boundary
     * @return a string of the post body
     */
    public static String encodePostBody(Bundle parameters, String boundary) {
        if (parameters == null) return "";
        StringBuilder sb = new StringBuilder();
        
        for (String key : parameters.keySet()) {
        	
        	/*//YG:removed this from sdk
        	try{
            if (parameters.getByteArray(key) != null) {
        	    continue;
            }
        	}catch(Exception ex){}
        	*/
        	
            sb.append("Content-Disposition: form-data; name=\"" + key + 
            		//"\"\r\n\r\n" + parameters.getString(key));
            		"\"\r\n\r\n" + parameters.get(key));//to avoid type clash
            sb.append("\r\n" + "--" + boundary + "\r\n");
        }
        
        return sb.toString();
    }

    public static String encodeUrl(Bundle parameters) {
        if (parameters == null) {
        	return "";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        try {
        	for (String key : parameters.keySet()) {
        		if (first) first = false; else sb.append("&");
            	
        		sb.append(URLEncoder.encode(key, "UTF-8") + "=" +
        				URLEncoder.encode(parameters.getString(key), "UTF-8"));
			
        	}
        } catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        	}
        return sb.toString();
    }

    public static Bundle decodeUrl(String s) {
        Bundle params = new Bundle();
        if (s != null) {
            String array[] = s.split("&");
            for (String parameter : array) {
                String v[] = parameter.split("=");
                // YG: in case param has no value
                if (v.length==2){
                	params.putString(v[0],v[1]);
                }
                else {
                	try {
						params.putString(URLDecoder.decode(v[0],"UTF-8")," ");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
                }
            }
        }
        return params;
    }

    /**
     * Parse a URL query and fragment parameters into a key-value bundle.
     * 
     * @param url the URL to parse
     * @return a dictionary bundle of keys and values
     */
    public static Bundle parseUrl(String url) {
        // hack to prevent MalformedURLException
        url = url.replace("fbconnect", "http"); 
        try {
            URL u = new URL(url);
            Bundle b = decodeUrl(u.getQuery());
            b.putAll(decodeUrl(u.getRef()));
            return b;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    
    /**
     * Connect to an HTTP URL and return the response as a string.
     * 
     * Note that the HTTP method override is used on non-GET requests. (i.e.
     * requests are made as "POST" with method specified in the body).
     * 
     * @param url - the resource to open: must be a welformed URL
     * @param method - the HTTP method to use ("GET", "POST", etc.)
     * @param params - the query parameter for the URL (e.g. access_token=foo)
     * @return the URL contents as a String
     * @throws MalformedURLException - if the URL format is invalid
     * @throws IOException - if a network problem occurs
     */
    public static String openUrl(String url, String method, Bundle params) 
          throws MalformedURLException, IOException {
    	// random string as boundary for multi-part http post
    	String strBoundary = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    	String endLine = "\r\n";
   
    	OutputStream os;

        if (method.equals("GET")) {
            url = url + "?" + encodeUrl(params);
        }
        if (AppContext.DEBUG)Log.d("Facebook-Util", method + " URL: " + url);
        HttpURLConnection conn = 
            (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("User-Agent", System.getProperties().
                getProperty("http.agent") + " FacebookAndroidSDK");
        if (!method.equals("GET")) {
            Bundle dataparams = new Bundle();
            for (String key : params.keySet()) {
            	
            	/*
                if (params.getByteArray(key) != null) {
                        dataparams.putByteArray(key, params.getByteArray(key));
                }
                */
            	// YG: added this to avoid fups
            	byte[] byteArr = null;
            	try {
            		byteArr = (byte[])params.get(key);
            	}catch(Exception ex1){}
            	if (byteArr!=null)
            		dataparams.putByteArray(key, byteArr );
            }
        	
            // use method override
            if (!params.containsKey("method")) {
            	params.putString("method", method);           	
            }
            
            if (params.containsKey("access_token")) {
            	String decoded_token = URLDecoder.decode(params.getString("access_token"));
            	params.putString("access_token", decoded_token);
            }
                     
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+strBoundary);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.connect();
            os = new BufferedOutputStream(conn.getOutputStream());
            
            os.write(("--" + strBoundary +endLine).getBytes());
            os.write((encodePostBody(params, strBoundary)).getBytes());
            os.write((endLine + "--" + strBoundary + endLine).getBytes());
            
            if (!dataparams.isEmpty()) {
            	
                for (String key: dataparams.keySet()){
                    os.write(("Content-Disposition: form-data; filename=\"" + key + "\"" + endLine).getBytes());
                    os.write(("Content-Type: content/unknown" + endLine + endLine).getBytes());
                    os.write(dataparams.getByteArray(key));
                    os.write((endLine + "--" + strBoundary + endLine).getBytes());

                }          	
            }
            os.flush();
        }
        
        String response = "";
        try {
        	response = read(conn.getInputStream());
        } catch (FileNotFoundException e) {
            // Error Stream contains JSON that we can parse to a FB error
            response = read(conn.getErrorStream());
        }
        if (AppContext.DEBUG)Log.d("Facebook-Util", method + " response: " + response);
        
        return response;
    }

    private static String read(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(in), 1000);
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }

    public static void clearCookies(Context context) {
        // Edge case: an illegal state exception is thrown if an instance of 
        // CookieSyncManager has not be created.  CookieSyncManager is normally
        // created by a WebKit view, but this might happen if you start the 
        // app, restore saved state, and click logout before running a UI 
        // dialog in a WebView -- in which case the app crashes
        @SuppressWarnings("unused")
        CookieSyncManager cookieSyncMngr = 
            CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }

    /**
     * Parse a server response into a JSON Object.  This is a basic
     * implementation using org.json.JSONObject representation.  More
     * sophisticated applications may wish to do their own parsing.
     * 
     * The parsed JSON is checked for a variety of error fields and
     * a FacebookException is thrown if an error condition is set, 
     * populated with the error message and error type or code if
     * available. 
     * 
     * @param response - string representation of the response
     * @return the response as a JSON Object
     * @throws JSONException - if the response is not valid JSON
     * @throws FacebookError - if an error condition is set
     */
    /*public static JSONObject parseJson(String response) 
          throws JSONException, FacebookError {
        // Edge case: when sending a POST request to /[post_id]/likes
        // the return value is 'true' or 'false'. Unfortunately
        // these values cause the JSONObject constructor to throw
        // an exception.
        if (response.equals("false")) {
            throw new FacebookError("request failed");
        }
        if (response.equals("true")) {
            response = "{value : true}";
        }
        JSONObject json = new JSONObject(response);
        
        // errors set by the server are not consistent
        // they depend on the method and endpoint
        if (json.has("error")) {
            JSONObject error = json.getJSONObject("error");
            throw new FacebookError(
                    error.getString("message"), error.getString("type"), 0);
        }
        if (json.has("error_code") && json.has("error_msg")) {
            throw new FacebookError(json.getString("error_msg"), "",
                    Integer.parseInt(json.getString("error_code")));
        }
        if (json.has("error_code")) {
            throw new FacebookError("request failed", "",
                    Integer.parseInt(json.getString("error_code")));
        }
        if (json.has("error_msg")) {
            throw new FacebookError(json.getString("error_msg"));
        }
        if (json.has("error_reason")) {
            throw new FacebookError(json.getString("error_reason"));
        }
        return json;
    }*/
    
    /**
     * Display a simple alert dialog with the given text and title.
     * 
     * @param context 
     *          Android context in which the dialog should be displayed
     * @param title 
     *          Alert dialog title
     * @param text
     *          Alert dialog message
     */
    public static void showAlert(Context context, String title, String text) {
        Builder alertBuilder = new Builder(context);
        alertBuilder.setTitle(title);
        alertBuilder.setMessage(text);
        alertBuilder.create().show();
    }

    
    // basic extras for this example app!!!
	public static void go2WareninjaApps(Context context) {
		
		Intent intent = new Intent( Intent.ACTION_VIEW, 
					Uri.parse(AppContext.WARENINJAAPPS_MARKET_URL));
		
		if ( isIntentAvailable(context, intent) )
			context.startActivity(intent);
	} 
	public static void go2AppWebsite(Context context) {
		
		Intent intent = new Intent( Intent.ACTION_VIEW, 
				Uri.parse(AppContext.APPWEBSITE_URL));
		
		if ( isIntentAvailable(context, intent) )
			context.startActivity(intent);
	} 
	public static boolean isIntentAvailable(final Context context, final Intent intent) {
	    final PackageManager packageManager = context.getPackageManager();
	    
	    List<ResolveInfo> list =
	            packageManager.queryIntentActivities(intent,
	                    PackageManager.MATCH_DEFAULT_ONLY);
	    return list.size() > 0;
	}
    
}
