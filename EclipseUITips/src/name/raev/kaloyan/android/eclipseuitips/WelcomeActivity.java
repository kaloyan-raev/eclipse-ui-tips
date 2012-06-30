/*******************************************************************************
 * Copyright (c) 2012 Kaloyan Raev.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kaloyan Raev - initial implementation
 *******************************************************************************/
package name.raev.kaloyan.android.eclipseuitips;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class WelcomeActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.preferences);
        
        // register a listener to update the alarm when preferences change
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    	prefs.registerOnSharedPreferenceChangeListener(this);
        
        // schedule the alarm if the check box is selected
        updateAlarm();
    }
    
    @Override
	protected void onDestroy() {
		// unregister the preference listener
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    	prefs.unregisterOnSharedPreferenceChangeListener(this);

    	super.onDestroy();
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		if (Preferences.TIP_OF_THE_DAY.equals(key) || Preferences.TIME.equals(key)) {
			updateAlarm();
		}
	}

	private void updateAlarm() {
		new Scheduler(this).updateAlarm();
	}
	
}