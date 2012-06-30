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
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class Scheduler {
	
	private final static int REQUEST_CODE = 919728657;
	
	private Context context;
	private Intent intent;
	
	public Scheduler(Context context) {
		this.context = context;
        intent = new Intent(context, AlarmReceiver.class);
	}
	
	public void updateAlarm() {
    	if (Preferences.tipEnabled(context)) {
    		scheduleAlarm();
    	} else {
    		cancelAlarm();
    	}
    }
    
    private boolean isAlarmSet() {
		return PendingIntent.getBroadcast(context, REQUEST_CODE, intent, PendingIntent.FLAG_NO_CREATE) != null;
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
		getAlarmManager().setRepeating(
				AlarmManager.RTC, // no wake up
				getAlarmTime(), 
				AlarmManager.INTERVAL_DAY, 
				getSender());
	}
	
	private AlarmManager getAlarmManager() {
		return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
	}
	
	private PendingIntent getSender() {
		return PendingIntent.getBroadcast(context, REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	}
	
	private long getAlarmTime() {
		Calendar c = Calendar.getInstance();
		
		// store the current time in a separate variable
		long now = c.getTimeInMillis();
		
		// read the configured time
		Time time = Preferences.getTime(context);
		
		// reset the calendar with the configured time
		c.set(HOUR_OF_DAY, time.getHour());
		c.set(MINUTE, time.getMinute());
		c.set(SECOND, 0);
		c.set(MILLISECOND, 0);
		
		// if the current time is after the configured time then schedule for tomorrow
		if (now > c.getTimeInMillis()) { 
			c.add(DATE, 1); // add one day
		}
		
		return c.getTimeInMillis();		
	}

}
