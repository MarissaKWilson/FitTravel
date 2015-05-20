package com.marissakwilson.android.fittravel;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

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
			
//		mTrip = new Trip();
//		mTrip.setLocationA(40.7, -74.0);
//		mTrip.setLocationB(51.5, -0.1);
//		float[] results = new float[1];
//		Location.distanceBetween(mTrip.getLocationA().latitude, mTrip.getLocationA().longitude,
//                mTrip.getLocationB().latitude, mTrip.getLocationB().longitude, results);
//		mTrip.setTotalDistance(results);
//		mTrip.setCurrentDistance(4750000);
		
		
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
//		if(mTrip.getLocationB()==null){
//			getLastLocation();
//			googleMap.addMarker(new MarkerOptions().position(
//					mTrip.getLocationA()).title("Starting"));
//		}else{
			double[] mLocationA=mTrip.getLocationA();
			double[] mLocationB=mTrip.getLocationB();
			LatLng locationA = new LatLng(mLocationA[0], mLocationA[1]);
			LatLng locationB = new LatLng(mLocationB[0], mLocationB[1]);
			
			googleMap.addMarker(new MarkerOptions().position(locationA).title("Starting point"));
			googleMap.addMarker(new MarkerOptions().position(locationB).title("Ending point"));
			
			LatLng midPoint = getProgress();
//			googleMap.addMarker(new MarkerOptions().position(midPoint)
//					.icon(BitmapDescriptorFactory.fromFile(drawable/ic_walk.png)));
			
			Polyline bottomLine = googleMap.addPolyline(new PolylineOptions()
		     .add(locationA, locationB)
		     .width(10)
		     .color(Color.BLUE)
		     .geodesic(true));
			
			Polyline topLine = googleMap.addPolyline(new PolylineOptions()
		     .add(locationA, midPoint)
		     .width(10)
		     .color(Color.GREEN)
		     .geodesic(true));
			
//			googleMap.moveCamera(new CameraUpdateFactory());
//		}
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
	
	public void getLastLocation(){
		mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
        	mTrip.setLocationA(mLastLocation.getLatitude(),mLastLocation.getLongitude());
        }
        else{
        	mTrip.setLocationA(0,0);
        }
       System.out.println(mTrip.getLocationA().toString());
	}

	
	@Override
	public void onConnected(Bundle connectionHint) {
	    getLastLocation();
	}

	@Override
	public void onConnectionSuspended(int cause) {
		// TODO Auto-generated method stub
		
	}
	
	public LatLng getProgress(){
		double[] tmpA = mTrip.getLocationA();
		double[] tmpB = mTrip.getLocationB();
		double latA = tmpA[0];
		double latB = tmpB[0];
		double lngA = tmpA[1];
		double lngB = tmpB[1];
		double percentage = mTrip.getCurrentDistance()/mTrip.getTotalDistance();
		
	    //double dLon = Math.toRadians(lngB - lngA);
//
//	    //convert to radians
	    latA = Math.toRadians(latA);
	    latB = Math.toRadians(latB);
	    lngA = Math.toRadians(lngA);
	    lngB = Math.toRadians(lngB);

	    //Defining Cartesian components of the starting and ending points as vectors
	    double[] p = new double[3];
	    p[0] = Math.cos(latA)*Math.cos(lngA);
	    p[1] = Math.cos(latA)*Math.sin(lngA);
	    p[2] = Math.sin(latA);
	    double[] q = new double[3];
	    q[0] = Math.cos(latB)*Math.cos(lngB);
	    q[1] = Math.cos(latB)*Math.sin(lngB);
	    q[2] = Math.sin(latB);
	    
	    //Defining the dot product
	    double pDotq = p[0]*q[0]+p[1]*q[1]+p[2]*q[2];
	    
	    //Define angle between p and q
	    double alpha = Math.acos(pDotq);
	    
	    //Define progress rotation angle
	    double theta = alpha*percentage;
	    
	    //Defining a normalized cross product of the p and q
	    //Perpendicular to p and q
	    double[] pXq = new double[3];
	    pXq[0] = (p[1]*q[2]-q[1]*p[2])/Math.sin(alpha);
	    pXq[1] = (-p[0]*q[2]+q[0]*p[2])/Math.sin(alpha);
	    pXq[2] = (p[0]*q[1]-q[0]*p[1])/Math.sin(alpha);
	    
	    //Defining cosTheta and sinTheta to save computation time/effort
	    double cTh = Math.cos(theta);
	    double sTh = Math.sin(theta);
	    
	    //Calculate magnitude of r
	    double[][] rotationMatrix = new double[3][3];
	    rotationMatrix[0][0] = cTh + pXq[0] * pXq[0] * (1-cTh);
	    rotationMatrix[1][0] = pXq[0] * pXq[1] * (1-cTh) - pXq[2] * sTh;
	    rotationMatrix[2][0] = pXq[0] * pXq[2] * (1-cTh) + pXq[1] * sTh;
	    rotationMatrix[0][1] = pXq[1] * pXq[0] * (1-cTh) + pXq[2] * sTh;
	    rotationMatrix[1][1] = cTh + pXq[1] * pXq[1] * (1-cTh);
	    rotationMatrix[2][1] = pXq[1] * pXq[2] * (1-cTh) - pXq[0] * sTh;
	    rotationMatrix[0][2] = pXq[2] * pXq[0] * (1-cTh) - pXq[1] * sTh;
	    rotationMatrix[1][2] = pXq[2] * pXq[1] * (1-cTh) + pXq[0] * sTh;
	    rotationMatrix[2][2] = cTh + pXq[2] * pXq[2] * (1-cTh);
	  
	    //Calculate rotation
	    double[] s = new double[3];
	    for(int i=0; i<3; i++){
	    	s[i]=0;
	    	for(int j=0; j<3; j++){
	    		s[i]+=rotationMatrix[j][i]*p[j];
	    	}
	    }
	    
//	   	Convert back to lat lng
	    double latC = Math.asin(s[2]);
	    double lngC = Math.atan2(s[1],s[0]);
	   
	    //double Bx = Math.cos(latB) * Math.cos(dLon);
	    //double By = Math.cos(latB) * Math.sin(dLon);
	    //double lat3 = Math.atan2(Math.sin(latA) + Math.sin(latB), 
	    		//Math.sqrt((Math.cos(latA) + Bx) * (Math.cos(latA) + Bx) + By * By));
	    //double lng3 = lngA + Math.atan2(By, Math.cos(latA) + Bx);

//	    double lat3 = latA + (latB - latA) * percentage;
//	    double lng3 = lngA + Math.acos(Math.tan(latA) / Math.tan(lat3));
//	    
		LatLng progress = new LatLng(Math.toDegrees(latC), Math.toDegrees(lngC));
				
		return progress;
	}
		
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
				Intent i = new Intent(this, MenuActivity.class);
				startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
