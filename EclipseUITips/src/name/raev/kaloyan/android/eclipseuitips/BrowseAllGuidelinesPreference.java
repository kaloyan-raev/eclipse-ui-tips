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
import android.content.Intent;
import android.preference.Preference;
import android.util.AttributeSet;

public class BrowseAllGuidelinesPreference extends Preference {
	
	public BrowseAllGuidelinesPreference(Context context) {
		this(context, null);
	}

	public BrowseAllGuidelinesPreference(Context context, AttributeSet attrs) {
		this(context, attrs, android.R.attr.preferenceStyle);
	}

	public BrowseAllGuidelinesPreference(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onClick() {
		super.onClick();

		// create an intent for showing the categories activity
		Intent intent = new Intent(getContext(), CategoriesActivity.class);
		// show the activity
		getContext().startActivity(intent);
	}

}
