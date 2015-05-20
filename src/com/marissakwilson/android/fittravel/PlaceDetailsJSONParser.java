package com.marissakwilson.android.fittravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import org.json.JSONException;
import org.json.JSONObject;
 
public class PlaceDetailsJSONParser {
 
    /** Receives a JSONObject and returns a list */
    public List<HashMap<String,String>> parse(JSONObject jObject){
 
        Double lat = Double.valueOf(0);
        Double lng = Double.valueOf(0);
        String formattedAddress = "";
 
        HashMap<String, String> hm = new HashMap<String, String>();
        List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
 
        try {
            lat = (Double)jObject.getJSONObject("result").getJSONObject("geometry").getJSONObject("location").get("lat");
            lng = (Double)jObject.getJSONObject("result").getJSONObject("geometry").getJSONObject("location").get("lng");
            formattedAddress = (String) jObject.getJSONObject("result").get("formatted_address");
 
        } catch (JSONException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
 
        hm.put("lat", Double.toString(lat));
        hm.put("lng", Double.toString(lng));
        hm.put("formatted_address",formattedAddress);
 
        list.add(hm);
 
        return list;
    }
}
