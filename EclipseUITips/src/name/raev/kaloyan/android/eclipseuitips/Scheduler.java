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
	
	private final static int ALARM_HOUR = 8;
	private final static int ALARM_MINUTE = 30;
	
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
		getAlarmManager().setInexactRepeating(
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

		long now = c.getTimeInMillis();
		
		// schedule for 8:30 am
		c.set(HOUR_OF_DAY, ALARM_HOUR);
		c.set(MINUTE, ALARM_MINUTE);
		c.set(SECOND, 0);
		c.set(MILLISECOND, 0);
		
		// if the current time is after 8:30 am then schedule for tomorrow
		if (now > c.getTimeInMillis()) { 
			c.add(DATE, 1); // add one day
		}
		
		return c.getTimeInMillis();		
	}

}
