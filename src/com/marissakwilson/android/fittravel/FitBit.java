package com.marissakwilson.android.fittravel;



public class FitBit{
	
	private int mDistance;
	private boolean mUserMetric;
	private int mStrideLength;
	
	public int getDistance() {
		return mDistance;
	}

	public boolean isUserMetric() {
		return mUserMetric;
	}

	public int getStrideLength() {
		return mStrideLength;
	}

	//Temp values until OAuth is working
	public FitBit() {
		mDistance = 301200;
		mUserMetric = true;
		mStrideLength = 55;
	}


}
