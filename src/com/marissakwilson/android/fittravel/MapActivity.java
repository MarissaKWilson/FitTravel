package com.marissakwilson.android.fittravel;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{

	private MapFragment mMapFragment;
	private GoogleMap mGoogleMap;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity);
		
		 mMapFragment = MapFragment.newInstance();
		 FragmentTransaction fragmentTransaction =
		         getFragmentManager().beginTransaction();
		 fragmentTransaction.add(R.id.map_container, mMapFragment);
		 fragmentTransaction.commit();

		MapFragment mapFragment = (MapFragment)getFragmentManager()
				.findFragmentById(R.id.map);
		mMapFragment.getMapAsync(this);
		
	}
	
	@Override
	public void onMapReady(GoogleMap googleMap) {
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(0,0)).title("Marker"));
		
	}
	
//	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
//        View v = super.onCreateView(inflater, parent, savedInstanceState);
//        
//        //stash a reference to the GoogleMap
//        mGoogleMap = getMap();
//        // show the user's location
//        mGoogleMap.setMyLocationEnabled(true);
//	}

}
