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

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class GuidelineActivity extends Activity implements OnClickListener, OnPageChangeListener {
	
	private ViewPager mPager;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        
        // create view
        setContentView(R.layout.pager);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new GuidelinePageAdapter());
        mPager.setOnClickListener(this);
        mPager.setOnPageChangeListener(this);
        
        // get the index of the guideline to be displayed
        int index = (Integer) getIntent().getExtras().get(Guideline.EXTRA_INDEX);
        
        // set the index as initial page
        mPager.setCurrentItem(index);
    }
    
	@Override
	public void onClick(View v) {
		// do nothing here - the gesture listener will process the event
	}
	
	private class GuidelinePageAdapter extends PagerAdapter {
		
		LayoutInflater mInflater;
		
		public GuidelinePageAdapter() {
			 mInflater = (LayoutInflater) GuidelineActivity.this.
					 getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return Guideline.values().length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// load the layout for displaying a guideline
			View page = mInflater.inflate(R.layout.guideline, container, false);
			container.addView(page);

			// feed the layout with the guideline information based on the current pager position
			Guideline guideline = Guideline.values()[position];
	        ((TextView) page.findViewById(R.id.textGuideline)).setText(guideline.text);
	        ((TextView) page.findViewById(R.id.textCategory)).setText(getCategoryText(guideline));

			return page;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
		
	}
    
    private String getCategoryText(Guideline guideline) {
    	if (guideline.category == guideline.subcategory) {
    		return getString(guideline.category);
    	} else {
    		return String.format("%s - %s",
    				getString(guideline.subcategory), 
    				getString(guideline.category));
    	}
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    	// if page changes, then change the activity title
    	Guideline guideline = Guideline.values()[position];
        setTitle(String.format(getString(R.string.guideline), getString(guideline.index)));
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

}
