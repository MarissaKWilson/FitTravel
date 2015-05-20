package com.marissakwilson.android.fittravel;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public class Trip implements Serializable{
	
	private static final long serialVersionUID = 4840490339660604225L;

	private String mTitle;
	protected boolean mMetric;
	protected double[] mLocationA = new double[2];
	protected double[] mLocationB = new double[2];
//	protected String mstrLocA;
//	protected String mstrLocB;

	protected double mCurrentDistance;
	protected double mTotalDistance;
	
	public Trip(){
		mMetric=true;
	}
	
	public String locAToString() {
		return (mLocationA[0] + ", " + mLocationA[1]);
	}


//	public void setstrLocA(String mstrLocA) {
//		this.mstrLocA = mstrLocA;
//	}


	public String locBToString() {
		return (mLocationB[0] + ", " + mLocationB[1]);
	}

//
//	public void setstrLocB(String mstrLocB) {
//		this.mstrLocB = mstrLocB;
//	}

	
	public double[] getLocationA() {
		return mLocationA;
	}
	

	public void setLocationA(double lat, double lng) {
		
		mLocationA[0] = lat;
		mLocationA[1] = lng;
	}

	public double[] getLocationB() {
		return mLocationB;
	}

	public void setLocationB(double lat, double lng) {
		mLocationB[0] =lat;
		mLocationB[1] = lng;
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


	public double getTotalDistance() {
		return mTotalDistance;
	}

	//Sets total distance in meters
	public void setTotalDistance() {
		float[] results = new float[2];
		Location.distanceBetween(mLocationA[0], mLocationA[1],
                mLocationB[0], mLocationB[1], results);
		double tmp = results[0];
		mTotalDistance = tmp;
	}

	//Current distance in meters
	public double getCurrentDistance() {
		return mCurrentDistance;
	}

	public void setCurrentDistance(double currentDistance) {
		mCurrentDistance = currentDistance;
	}
	
//	public String[] tripToString(){
//		String[] data = new String[5];
//		data[0]=getLocationA().toString();
//		data[1]=getLocationB().toString();
//		data[2]=("" + getCurrentDistance());
//		data[3]=("" + getTotalDistance());
//		data[4]=("" + isMetric());
//		
//		return data;
//	}


	
}
