package com.marissakwilson.android.fittravel;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
		    }
			File tripFile = new File(context.getFilesDir(), tripFileName);
			File oauthFile = new File(context.getFilesDir(), oauthFileName);
		}
	
	   public static void writeTrip(Trip curTrip){
		   Trip trip = curTrip;

	        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
	        SharedPreferences.Editor prefsEditor = mPrefs.edit();
	        Gson gson = new Gson();
	        String json = gson.toJson(trip);
	        prefsEditor.putString("myTrip", json);
	        prefsEditor.commit();
	        
//		   FileOutputStream outputStream;
//
//		   try {
//			   outputStream = context.openFileOutput(tripFileName, 0);
//			   ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
//			   objectStream.writeObject(trip);
//			   objectStream.close();
//		   } catch (Exception e) {
//			   e.printStackTrace();
//		   }
	   }
	   
	   public static Trip readTrip(){
		//   Trip t;
		   Gson gson = new Gson();
		    String json = mPrefs.getString("myTrip", "");
		    Trip t = gson.fromJson(json, Trip.class);   
		    return t;
		    
//		   try{
//			   FileInputStream inputStream = new FileInputStream(tripFileName);
//			   ObjectInputStream objectIn = new ObjectInputStream(inputStream);
//			   t = (Trip) objectIn.readObject();
//			   objectIn.close();
//			   
//			   return t;
//		   }
//		   catch(Exception e){
//			   e.printStackTrace();
//			   return null;
//		   }
	   }

}
