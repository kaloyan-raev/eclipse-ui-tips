package name.raev.kaloyan.android.eclipseuitips;

import java.util.Calendar;

import name.raev.kaloyan.android.eclipseuitips.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        scheduleAlarm();
    }

	private void scheduleAlarm() {
		 // get a Calendar object with current time
		 Calendar cal = Calendar.getInstance();
		 // add 5 minutes to the calendar object
		 cal.add(Calendar.SECOND, 15);
		 Intent intent = new Intent(this, AlarmReceiver.class);
		 intent.putExtra("alarm_message", "O'Doyle Rules!");
		 // In reality, you would want to have a static variable for the request code instead of 192837
		 PendingIntent sender = PendingIntent.getBroadcast(this, 919728657, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		 
		 // Get the AlarmManager service
		 AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		 am.setInexactRepeating(AlarmManager.RTC, cal.getTimeInMillis(), 15 * 1000 * 100, sender);
	}
}