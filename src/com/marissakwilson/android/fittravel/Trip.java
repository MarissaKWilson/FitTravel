package com.marissakwilson.android.fittravel;

import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;

public class Trip {

	private static final String JSON_ID = "id";
	private static final String JSON_LOCATIONA = "locationA";
	private static final String JSON_LOCATIONB = "locationB";
	private static final String JSON_CURRENTDISTANCE = "currentDistance";
	private static final String JSON_TOTALDISTANCE = "totalDistance";
	
	private String mTitle;
	private boolean mMetric=true;
	private UUID mUUID;
	private LatLng mLocationA;
	private LatLng mLocationB;
	private String mstrLocA;
	private String mstrLocB;

	private double mCurrentDistance;
	private double mTotalDistance;
	
	public Trip(){
		mUUID = UUID.randomUUID();
	}
	
	public String getstrLocA() {
		return mstrLocA;
	}


	public void setstrLocA(String mstrLocA) {
		this.mstrLocA = mstrLocA;
	}


	public String getstrLocB() {
		return mstrLocB;
	}


	public void setstrLocB(String mstrLocB) {
		this.mstrLocB = mstrLocB;
	}


	 
	
	

	

	
	public LatLng getLocationA() {
		return mLocationA;
	}
	

	public void setLocationA(double lat, double lng) {
		
		mLocationA = new LatLng(lat, lng);
	}

	public LatLng getLocationB() {
		return mLocationB;
	}

	public void setLocationB(double lat, double lng) {
		mLocationB = new LatLng(lat, lng);
	}
	
	public String toStringLocationA(){
		return mLocationA.toString();
	}

	@Override
	public String toString(){
		return mTitle;
	}
	
	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public boolean isMetric() {
		return mMetric;
	}

	public void setMetric(boolean isMetric) {
		mMetric = isMetric;
	}
	
	public UUID getUUID() {
		return mUUID;
	}

	public double getTotalDistance() {
		return mTotalDistance;
	}

	public void setTotalDistance(float[] results) {
		double tmp = results[0];
		mTotalDistance = tmp;
	}

	public double getCurrentDistance() {
		return mCurrentDistance;
	}

	public void setCurrentDistance(double currentDistance) {
		mCurrentDistance = currentDistance;
	}


	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_ID, mUUID.toString());
		json.put(JSON_LOCATIONA, mLocationA.toString());
		json.put(JSON_LOCATIONB, mLocationB.toString());
		json.put(JSON_CURRENTDISTANCE, mCurrentDistance);
		json.put(JSON_TOTALDISTANCE, mTotalDistance);
		return null;
	}
	
}
