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

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

/**
 * An activity with action bar where the icon enabled for up navigation. 
 */
public class UpNavigationActivity extends SherlockFragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		enableUpNavigation();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go one level up
	            Intent intent = new Intent(this, getUpLevelActivity());
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	/**
	 * Returns the activity that is one level up. This is the activity that will
	 * be shown when the user invokes the up navigation.
	 * 
	 * <p>
	 * The default is to navigate to the home activity. Superclasses may
	 * override this method and define other activities for destination.
	 * </p>
	 * 
	 * @return the class of the activity that is one level up
	 */
	protected Class<?> getUpLevelActivity() {
		return WelcomeActivity.class;
	}

	private void enableUpNavigation() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayOptions(actionBar.getDisplayOptions() | ActionBar.DISPLAY_HOME_AS_UP);
	}
	
}
