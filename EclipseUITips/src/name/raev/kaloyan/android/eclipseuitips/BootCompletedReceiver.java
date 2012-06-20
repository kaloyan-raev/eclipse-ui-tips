package name.raev.kaloyan.android.eclipseuitips;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// make sure the alarm is set according to the preferences
	    new Scheduler(context).updateAlarm();
	}

}
