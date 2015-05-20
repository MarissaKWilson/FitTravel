package com.marissakwilson.android.fittravel;

import java.io.File;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class FileHandler {
		static Context context;
		static String tripFileName = "tripfile.ser";
		static String oauthFileName = "oauthFile.ser";

		static SharedPreferences  mPrefs;
		
		public FileHandler(Context c){
			context=c;

		    if(!context.getFilesDir().exists()){
		         context.getFilesDir().mkdirs();
		   
			File tripFile = new File(context.getFilesDir(), tripFileName);
			File oauthFile = new File(context.getFilesDir(), oauthFileName);
		    }
		}
	
	   public static void writeTrip(Trip curTrip){
		   Trip trip = curTrip;

	        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
	        SharedPreferences.Editor prefsEditor = mPrefs.edit();
	        Gson gson = new Gson();
	        String json = gson.toJson(trip);
	        prefsEditor.putString("myTrip", json);
	        prefsEditor.commit();
	        
	   }
	   
	   public static Trip readTrip(){
		   Gson gson = new Gson();
		    String json = mPrefs.getString("myTrip", "");
		    Trip t = gson.fromJson(json, Trip.class);   
		    return t;
		    
	   }
	   
	   public static void writeFitbit(Fitbit curFB){
		   Fitbit fitbit = curFB;
		   
		   mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		   SharedPreferences.Editor prefsEditor = mPrefs.edit();
		   Gson g = new Gson();
		   String j = g.toJson(fitbit);
		   prefsEditor.putString("myFitbit", j);
		   prefsEditor.commit();
	   }
	   
	   public static Fitbit readFitbit(){
		   Gson gson = new Gson();
		   String json = mPrefs.getString("myFitbit", "");
		   Fitbit fb = gson.fromJson(json, Fitbit.class);
		   return fb;
	   }

}
