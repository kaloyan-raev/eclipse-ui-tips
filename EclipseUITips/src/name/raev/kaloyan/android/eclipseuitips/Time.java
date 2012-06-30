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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.util.Log;

public class Time {
	
	public static final String DEFAULT = "08:30";
	public static final String FORMAT = "HH:mm";
	
	private String value;
	private SimpleDateFormat dfm = new SimpleDateFormat(FORMAT);
	
	public Time() {
		this(DEFAULT);
	}
	
	public Time(String value) {
		this.value = value;
	}
	
	public Time(int hour, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		
		this.value = dfm.format(calendar.getTime());
	}
	
	public int getHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(toDate());
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinute() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(toDate());
		return calendar.get(Calendar.MINUTE);
	}
	
	public Date toDate() {
		try {
			return dfm.parse(value);
		} catch (ParseException e) {
			Log.e(Time.class.getName(), "Error parsing time value", e);
			// return the current time
			return new Date();
		}
	}

	@Override
	public String toString() {
		return value;
	}
	
}
