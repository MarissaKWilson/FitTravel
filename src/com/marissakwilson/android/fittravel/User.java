package com.marissakwilson.android.fittravel;

import java.util.UUID;

public class User {
	
	private int mStrideLength;
	private UUID mUUID;
	
	public User(){
		mUUID=UUID.randomUUID();
	}

	public int getStrideLength() {
		return mStrideLength;
	}

	public void setStrideLength(int strideLength) {
		mStrideLength = strideLength;
	}

	public UUID getUUID() {
		return mUUID;
	}
	
	
}
