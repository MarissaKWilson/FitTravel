package com.marissakwilson.android.fittravel;

import android.app.FragmentTransaction;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, 
	ConnectionCallbacks, OnConnectionFailedListener{

	private final String TAG = "MapActivity";
	
	private MapFragment mMapFragment;
	private GoogleMap mGoogleMap;
	private GoogleApiClient mGoogleApiClient;
	private Location mLastLocation;
	private Trip mTrip;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity);
		
		mTrip = new Trip();
		
		
		
		 mMapFragment = MapFragment.newInstance();
		 FragmentTransaction fragmentTransaction =
		         getFragmentManager().beginTransaction();
		 fragmentTransaction.add(R.id.map_container, mMapFragment);
		 fragmentTransaction.commit();

		MapFragment mapFragment = (MapFragment)getFragmentManager()
				.findFragmentById(R.id.map);
		mMapFragment.getMapAsync(this);
		
		buildGoogleApiClient();
		mGoogleApiClient.connect();
		
	}
	
	@Override
	public void onMapReady(GoogleMap googleMap) {
		googleMap.setMyLocationEnabled(true);
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(0,0)).title("Marker"));
		
	}
	
	protected synchronized void buildGoogleApiClient() {
	    mGoogleApiClient = new GoogleApiClient.Builder(this)
	        .addConnectionCallbacks(this)
	        .addOnConnectionFailedListener(this)
	        .addApi(LocationServices.API)
	        .build();
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onConnected(Bundle connectionHint) {
	    mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
        	mTrip.setLocationA(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()));
        	
        }
        else{
        	mTrip.setLocationA(new LatLng(0,0));
        }
        
        System.out.println(mTrip.getLocationA().toString());
	}

	@Override
	public void onConnectionSuspended(int cause) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
	

}
