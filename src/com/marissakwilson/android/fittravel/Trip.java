package com.marissakwilson.android.fittravel;

import java.util.UUID;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public class Trip {

	private String mTitle;
	private boolean mMetric=true;
	private UUID mUUID;
	private LatLng mLocationA;
	private LatLng mLocationB;
	private double mCurrentDistance;
	private double mTotalDistance;
	 
	
	

	public Trip(){
		mUUID = UUID.randomUUID();
	}

	
	public LatLng getLocationA() {
		return mLocationA;
	}
	

	public void setLocationA(double lat, double lng) {
		
		mLocationA = new LatLng(lat, lng);
//		System.out.println((int)lastLocation.getLatitude() + " + " + (int)lastLocation.getLongitude());
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
	
}
