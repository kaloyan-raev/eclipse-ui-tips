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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class GuidelinesPagerActivity extends FragmentActivity implements OnPageChangeListener {
	
	private ViewPager mPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.guidelines_pager);
        
        // get the index of the guideline to be displayed
        int index = getIntent().getIntExtra(Guideline.EXTRA_INDEX, 0);
        Guideline guideline = Guideline.values()[index];
        
        // check if the guideline shall be highlighted
        boolean highlighted = getIntent().getBooleanExtra(Guideline.EXTRA_HIGHLIGHTED, false);
	
        // initialize the pager
		mPager = (ViewPager) findViewById(R.id.guidelines_pager);
		mPager.setOnPageChangeListener(this);
        mPager.setAdapter(new GuidelinesPageAdapter(guideline, highlighted));
        
        // set the initial page to the guideline's category
        int subcategoryIndex = guideline.subcategory.ordinal();
        mPager.setCurrentItem(subcategoryIndex);
        setActivityTitle(subcategoryIndex);
	}
	
	private void setActivityTitle(int subcategoryIndex) {
		Subcategory subcategory = Subcategory.values()[subcategoryIndex];
        setTitle(getString(subcategory.name));
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
	
	private class GuidelinesPageAdapter extends FragmentPagerAdapter {
		
		private Guideline mGuideline;
		private boolean mHighlighted;
		
		public GuidelinesPageAdapter(Guideline guideline, boolean hightlighed) {
			 super(GuidelinesPagerActivity.this.getSupportFragmentManager());
			 mGuideline = guideline;
			 mHighlighted = hightlighed;
		}

		@Override
		public int getCount() {
			return Subcategory.values().length;
		}
		
		@Override
		public Fragment getItem(int position) {
			Subcategory subcategory = Subcategory.values()[position];
			return GuidelinesFragment.newInstance(subcategory, mGuideline, mHighlighted);
		}
		
	}

}
