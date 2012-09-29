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
import name.raev.kaloyan.android.eclipseuitips.model.Subcategory;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class GuidelinesPagerActivity extends UpNavigationActivity implements OnPageChangeListener {
	
	private ViewPager mPager;
	private Guideline mHighlightedGuideline;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.guidelines_pager);
		
        // get the index of the guideline to be displayed
        int index = getIntent().getIntExtra(Guideline.EXTRA_INDEX, 0);
        Guideline guideline = Guideline.values()[index];
        
        // check if the guideline shall be highlighted
        mHighlightedGuideline = getIntent().getBooleanExtra(Guideline.EXTRA_HIGHLIGHTED, false) ? guideline : null;

        // initialize the pager
		mPager = (ViewPager) findViewById(R.id.guidelines_pager);
		mPager.setOnPageChangeListener(this);
        mPager.setAdapter(new GuidelinesPageAdapter());
        
        // set the initial page to the guideline's category
        scrollTo(guideline);
	}
	
	private void scrollTo(Guideline guideline) {
		int subcategoryIndex = guideline.subcategory().ordinal();
        mPager.setCurrentItem(subcategoryIndex);
        setActivityTitle(subcategoryIndex);
        
        // notify all fragments that the highlight has changed
        GuidelinesFragment.highlightChanged(guideline);
	}
	
	private void setActivityTitle(int subcategoryIndex) {
		Subcategory subcategory = Subcategory.values()[subcategoryIndex];
        setTitle(getString(subcategory.title()));
	}
	
    @Override
	protected Class<?> getUpLevelActivity() {
    	return (mHighlightedGuideline == null) ?	// check if there is a highlighted guideline
    			CategoriesActivity.class : 			// No - return to the list of categories
    			super.getUpLevelActivity(); 		// Yes - return to the welcome screen
	}
	
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

	@Override
    public void onPageSelected(int position) {
    	// if page changes, then change the activity title
    	setActivityTitle(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.guidelines_pager_activity, menu);
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.menu_random:
	        	// draw a random guideline to show in the guidelines list
	    		mHighlightedGuideline = Guideline.random();
	    		// scroll the pager
	    		scrollTo(mHighlightedGuideline);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	public Guideline getHighlightedGuildeine() {
		return mHighlightedGuideline;
	}

	private class GuidelinesPageAdapter extends FragmentPagerAdapter {
		
		public GuidelinesPageAdapter() {
			 super(GuidelinesPagerActivity.this.getSupportFragmentManager());
		}

		@Override
		public int getCount() {
			return Subcategory.values().length;
		}
		
		@Override
		public GuidelinesFragment getItem(int position) {
			Subcategory subcategory = Subcategory.values()[position];
			return GuidelinesFragment.newInstance(subcategory);
		}
		
	}

}
