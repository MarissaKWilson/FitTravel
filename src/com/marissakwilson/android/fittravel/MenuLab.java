package com.marissakwilson.android.fittravel;

import java.util.ArrayList;

import android.content.Context;

public class MenuLab {
	private static MenuLab sMenuLab;
	private Context mAppContext;
	ArrayList mMenuViews;
	
	private MenuLab(Context appContext){
		mAppContext = appContext;
		mMenuViews = new ArrayList();
	}
	
	public static MenuLab get(Context c){
		if(sMenuLab == null){
			sMenuLab = new MenuLab(c.getApplicationContext());
		}
		return sMenuLab;
	}
	
	public ArrayList getMenus(){
		return mMenuViews;
	}
	
//	public Object getMenu(){
//		for(Object o : mMenuViews){
//			if(o.getID().equals(id))
//				return o;
//		}
//	}
}
