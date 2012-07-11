package name.raev.kaloyan.android.eclipseuitips;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.util.AttributeSet;

public class OpenRandomGuidelinePreference extends Preference {
	
	public OpenRandomGuidelinePreference(Context context) {
		this(context, null);
	}

	public OpenRandomGuidelinePreference(Context context, AttributeSet attrs) {
		this(context, attrs, android.R.attr.preferenceStyle);
	}

	public OpenRandomGuidelinePreference(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onClick() {
		super.onClick();

		// create an intent for showing the guideline activity
		Intent intent = new Intent(getContext(), GuidelineActivity.class);
		// draw a random guideline to display in the notification
		Guideline guideline = Guideline.random();
		// pass the index of the guideline with this intent
		intent.putExtra(Guideline.EXTRA_INDEX, guideline.ordinal());
		// show the activity
		getContext().startActivity(intent);
	}

}
