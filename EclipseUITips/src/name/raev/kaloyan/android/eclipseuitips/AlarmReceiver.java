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

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(ns);

		Notification notification = new Notification(
				R.drawable.ic_stat_notify_eclipse, 
				context.getString(R.string.notify_ticker_text), 
				0); // don't show time stamp
		// remove the notification once user clicks on it
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		
		// draw a random guideline to display in the notification
		Guideline guideline = Guideline.random();
		
		Intent notificationIntent = new Intent(context, GuidelinesPagerActivity.class);
		// pass the index of the guideline with this intent
		notificationIntent.putExtra(Guideline.EXTRA_INDEX, guideline.ordinal());
		notificationIntent.putExtra(Guideline.EXTRA_HIGHLIGHTED, true);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

		CharSequence contentTitle = context.getString(guideline.subcategory.name);
		CharSequence contentText = context.getString(guideline.text);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		mNotificationManager.notify(1, notification);
	}

}
