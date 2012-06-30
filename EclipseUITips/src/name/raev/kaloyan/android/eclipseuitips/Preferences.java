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

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
	
	public final static String TIP_OF_THE_DAY = "tip_of_the_day";
	public final static String TIME = "time";
	
    public static boolean tipEnabled(Context context) {
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    	return prefs.getBoolean(TIP_OF_THE_DAY, false);
    }
    
    public static Time getTime(Context context) {
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    	return new Time(prefs.getString(TIME, Time.DEFAULT));
    }

}
