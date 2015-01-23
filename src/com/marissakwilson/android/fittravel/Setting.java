package com.marissakwilson.android.fittravel;

import java.util.UUID;

public class Setting {

	private String mTitle;
	private boolean mDefault;
	private UUID mUUID;
	

	public Setting(){
		mUUID = UUID.randomUUID();
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

	public boolean isDefault() {
		return mDefault;
	}

	public void setDefault(boolean default1) {
		mDefault = default1;
	}
	
	public UUID getUUID() {
		return mUUID;
	}
	
}
