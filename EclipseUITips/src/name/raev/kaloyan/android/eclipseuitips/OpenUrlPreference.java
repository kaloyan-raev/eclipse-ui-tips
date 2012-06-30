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
import android.net.Uri;
import android.preference.Preference;
import android.util.AttributeSet;

public class OpenUrlPreference extends Preference {
	
	private static final String ATTR_URL = "url";
	
	private String url;

	public OpenUrlPreference(Context context) {
		this(context, null);
	}

	public OpenUrlPreference(Context context, AttributeSet attrs) {
		this(context, attrs, android.R.attr.preferenceStyle);
		url = attrs.getAttributeValue(null, ATTR_URL);
	}

	public OpenUrlPreference(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onClick() {
		super.onClick();

		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		getContext().startActivity(intent);
	}

}
