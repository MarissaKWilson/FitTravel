package com.marissakwilson.android.fittravel;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;

public class FitTravelJSONSerializer {
	
	private Context mContext;
	private String mFilename;

	
	public FitTravelJSONSerializer(Context c, String f){
		mContext = c;
		mFilename = f;
	}
	
	public void saveData(OAuthActivity userLogin, Trip t ) throws JSONException, IOException{
		JSONArray dataArray = new JSONArray();
		
		dataArray.put(userLogin.toJSON());
		dataArray.put(t.toJSON());
		
		Writer writer = null;
		try{
			OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
			writer = new OutputStreamWriter(out);
			writer.write(dataArray.toString());
		} finally{
			if(writer !=null )
				writer.close();
		}
	}
}
