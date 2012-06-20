package name.raev.kaloyan.android.eclipseuitips;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
	
	public final static String TIP_OF_THE_DAY = "tip_of_the_day";
	
    public static boolean tipEnabled(Context context) {
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    	return prefs.getBoolean(TIP_OF_THE_DAY, false);
    }

}
