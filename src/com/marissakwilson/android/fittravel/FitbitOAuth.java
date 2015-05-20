package com.marissakwilson.android.fittravel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public  class FitbitOAuth extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle extra = intent.getExtras();
		String payload = (String) extra.get("payload");
		
	}
	
//	public abstract Intent registerReceiver (BroadcastReceiver receiver, IntentFilter filter);
	
	
}
