package com.marissakwilson.android.fittravel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class LocationPickerFragment extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstaceState){
		return new AlertDialog.Builder(getActivity()).setTitle(R.string.new_location_title)
				.setPositiveButton(android.R.string.ok, null).create();
	}
}
