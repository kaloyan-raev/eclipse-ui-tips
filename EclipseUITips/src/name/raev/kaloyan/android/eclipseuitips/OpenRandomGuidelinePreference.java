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

import name.raev.kaloyan.android.eclipseuitips.model.Guideline;
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

		// create an intent for showing the guidelines activity
		Intent intent = new Intent(getContext(), GuidelinesPagerActivity.class);
		// draw a random guideline to show in the guidelines list
		Guideline guideline = Guideline.random();
		// pass the index of the guideline with this intent
		intent.putExtra(Guideline.EXTRA_INDEX, guideline.ordinal());
		intent.putExtra(Guideline.EXTRA_HIGHLIGHTED, true);
		// show the activity
		getContext().startActivity(intent);
	}

}
