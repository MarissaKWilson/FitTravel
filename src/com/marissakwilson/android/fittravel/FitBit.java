package com.marissakwilson.android.fittravel;

import java.io.Serializable;



public class Fitbit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mDistance;
	private boolean mUserMetric;
	private int mStrideLength;
	
	public int getDistance() {
		return mDistance;
	}
	
	public void setDistance(int d){
		mDistance=d;
	}

	public boolean isUserMetric() {
		return mUserMetric;
	}
	
	public void setIsUserMetric(boolean b){
		mUserMetric = b;
	}

	public int getStrideLength() {
		return mStrideLength;
	}

	//Temp values until OAuth is working
	public Fitbit() {
		mDistance = 301200;
		mUserMetric = true;
		mStrideLength = 55;
		
	}


}
