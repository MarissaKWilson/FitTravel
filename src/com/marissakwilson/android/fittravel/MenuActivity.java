package com.marissakwilson.android.fittravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends FragmentActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		if(findViewById(R.id.fragment_container) !=null ){			
			//If being restored from previous state we don't need to do anything
			if(savedInstanceState != null){
				return;
			}
		
		//	NewTripFragment blankTrip = new NewTripFragment();
			getSupportFragmentManager().beginTransaction()
			.add(R.id.fitbitcontainer, new NewTripFragment()).commit();

			
//	
//			final ListView listview = (ListView) findViewById(R.id.listview_activity);
//		    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//		        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//		        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
//		        "Android", "iPhone", "WindowsMobile" };
//
//		    final ArrayList<String> list = new ArrayList<String>();
//		    for (int i = 0; i < values.length; ++i) {
//		      list.add(values[i]);
//		    }
//		    final StableArrayAdapter adapter = new StableArrayAdapter(this,
//		        android.R.layout.simple_list_item_1, list);
//		    listview.setAdapter(adapter);
//
//		    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//		      @Override
//		      public void onItemClick(AdapterView<?> parent, final View view,
//		          int position, long id) {
//		        final String item = (String) parent.getItemAtPosition(position);
//		        view.animate().setDuration(2000).alpha(0)
//		            .withEndAction(new Runnable() {
//		              @Override
//		              public void run() {
//		                list.remove(item);
//		                adapter.notifyDataSetChanged();
//		                view.setAlpha(1);
//		              }
//		            });
//		      }
//
//		    });
//		  }

		  

		
			
			


		}
	}
}
