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
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class GuidelinesFragment extends ListFragment {
	
	private Subcategory mSubcategory;
	private Guideline mGuideline;
	private boolean mHighlighted;

	static GuidelinesFragment newInstance(Subcategory subcategory, Guideline guideline, boolean highlighted) {
		GuidelinesFragment fragment = new GuidelinesFragment();
		
		Bundle args = new Bundle();
		args.putInt("subcategory", subcategory.ordinal());
		args.putInt("guideline", guideline.ordinal());
		args.putBoolean("highlighted", highlighted);
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSubcategory = Subcategory.values()[getArguments().getInt("subcategory", 0)];
        mGuideline = Guideline.values()[getArguments().getInt("guideline", 0)];
        mHighlighted = getArguments().getBoolean("highlighted", false);
    }
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new GuidelinesAdapter());
        
        // scroll the list to the highlighted guideline if any
        if (mHighlighted && mGuideline.subcategory == mSubcategory) {
        	setSelection(Guideline.positionInSubcategory(mGuideline));
        }
    }
    
    private class GuidelinesAdapter extends ArrayAdapter<Guideline> {

		private LayoutInflater vi;
    	
    	GuidelinesAdapter() {
    		super(getActivity(), 0, mSubcategory.guidelines());
			vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	}
    	
    	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
    		// TODO try to reuse the convertView
    		View v = convertView;
    		
    		if (mHighlighted && 
    				mGuideline.subcategory == mSubcategory && 
    				position == Guideline.positionInSubcategory(mGuideline)) {
    			v = vi.inflate(R.layout.guideline_list_item_highlight, null);
    		} else {
    			v = vi.inflate(R.layout.guideline_list_item, null);
    		}
    			
    		TextView text = ((TextView) v.findViewById(R.id.guideline_list_item));
    		
    		// set text to the guideline's index and text
			Guideline g = getItem(position);
			text.setText(getContext().getText(g.index) + ". " + getContext().getText(g.text));
			
			return v;
		}
    	
    }

}
