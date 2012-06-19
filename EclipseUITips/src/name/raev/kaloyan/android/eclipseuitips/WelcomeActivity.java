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

import static java.util.Calendar.DATE;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class WelcomeActivity extends PreferenceActivity {
	
	private final static String CHECKBOX_KEY = "tip_of_the_day";
	private final static int REQUEST_CODE = 919728657;

	private Intent intent;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.preferences);
        
        intent = new Intent(this, AlarmReceiver.class);
        
        findPreference(CHECKBOX_KEY).setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				updateAlarm();
				return true;
			}
		});
        
        // schedule the alarm if the check box is selected
        updateAlarm();
    }
    
    private boolean tipEnabled() {
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    	return prefs.getBoolean(CHECKBOX_KEY, false);
    }
    
    private void updateAlarm() {
    	if (tipEnabled()) {
    		scheduleAlarm();
    	} else {
    		cancelAlarm();
    	}
    }
    
    private boolean isAlarmSet() {
		return PendingIntent.getBroadcast(this, REQUEST_CODE, intent, PendingIntent.FLAG_NO_CREATE) != null;
    }
    
    private void cancelAlarm() {
    	if (isAlarmSet()) { // cancel only if set previously
	    	PendingIntent sender = getSender();
	    	getAlarmManager().cancel(sender);
	    	sender.cancel();
    	}
    }

	private void scheduleAlarm() {
		// make sure the alarm is canceled
		cancelAlarm();
		
		// schedule the alarm 
		getAlarmManager().setInexactRepeating(
				AlarmManager.RTC, // no wake up
				getAlarmTime(), 
				AlarmManager.INTERVAL_DAY, 
				getSender());
	}
	
	private AlarmManager getAlarmManager() {
		return (AlarmManager) getSystemService(ALARM_SERVICE);
	}
	
	private PendingIntent getSender() {
		return PendingIntent.getBroadcast(this, REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	}
	
	private long getAlarmTime() {
		Calendar c = Calendar.getInstance();

		// if the current time is after 8:45 am then schedule for tomorrow
		if ((c.get(HOUR_OF_DAY) > 9) 
				|| (c.get(HOUR_OF_DAY) == 8 && c.get(MINUTE) > 45)) {
			c.add(DATE, 1);
		}
		
		// schedule for 8:45 am
		c.set(HOUR_OF_DAY, 8);
		c.set(MINUTE, 45);
		
		return c.getTimeInMillis();		
	}
	
}