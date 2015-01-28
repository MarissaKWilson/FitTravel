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
	private long mCurrentDistance;
	private long mTotalDistance;
	 
	
	

	public Trip(){
		mUUID = UUID.randomUUID();
	}

	
	public LatLng getLocationA() {
		return mLocationA;
	}
	

	public void setLocationA(Location lastLocation) {
		
		mLocationA = new LatLng((int)lastLocation.getLatitude(), (int)lastLocation.getLongitude());
//		System.out.println((int)lastLocation.getLatitude() + " + " + (int)lastLocation.getLongitude());
	}

	public LatLng getLocationB() {
		return mLocationB;
	}

	public void setLocationB(LatLng locationB) {
		mLocationB = locationB;
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

	public long getTotalDistance() {
		return mTotalDistance;
	}

	public void setTotalDistance(long totalDistance) {
		mTotalDistance = totalDistance;
	}

	public long getCurrentDistance() {
		return mCurrentDistance;
	}

	public void setCurrentDistance(long currentDistance) {
		mCurrentDistance = currentDistance;
	}
	
}
