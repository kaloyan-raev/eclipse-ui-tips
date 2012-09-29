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

import java.util.HashMap;
import java.util.Map;

import name.raev.kaloyan.android.eclipseuitips.model.Guideline;
import name.raev.kaloyan.android.eclipseuitips.model.Subcategory;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;

public class GuidelinesFragment extends SherlockListFragment {
	
	private static final String SUBCATEGORY = "subcategory";
	private static final String POSITION = "position";
	
	// keep track of all available fragment to iterate them when the highlight is changed
	private static Map<Subcategory, GuidelinesFragment> fragments = new HashMap<Subcategory, GuidelinesFragment>();
	
	// the subcategory this fragment presents
	private Subcategory mSubcategory;
	
	// the position of the highlighted guideline, -1 means no highlight in this fragment
	private int mPos = -1;
	
	static GuidelinesFragment newInstance(Subcategory subcategory) {
		GuidelinesFragment fragment = new GuidelinesFragment();
		
		Bundle args = new Bundle();
		args.putInt(SUBCATEGORY, subcategory.ordinal());
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        int subcategoryIndex = -1;
        
        // first check if the subcategory and position are saved in the instance state - this happens when orientation changes
        if (savedInstanceState != null) {
        	subcategoryIndex = savedInstanceState.getInt(SUBCATEGORY, -1);
        	mPos = savedInstanceState.getInt(POSITION, -1);
        }
        
        if (subcategoryIndex == -1) {
        	// check if the subcategory is passed as an argument - initial creation of the fragment
        	subcategoryIndex = getArguments().getInt(SUBCATEGORY, 0);
        	
        	// check if this subcategory contains a highlighted guideline
        	Guideline highlightedGuideline = ((GuidelinesPagerActivity) getActivity()).getHighlightedGuildeine();
        	if (highlightedGuideline != null && highlightedGuideline.subcategory().ordinal() == subcategoryIndex) {
        		mPos = Guideline.positionInSubcategory(highlightedGuideline);
        	}
        }
        
        mSubcategory = Subcategory.values()[subcategoryIndex];

		fragments.put(mSubcategory, this);

        setListAdapter(new GuidelinesAdapter());
        
        // scroll to the highlighted item, if any
        setSelection(mPos);
    }

	@Override
	public void onDestroy() {
		fragments.remove(mSubcategory);
		super.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mSubcategory != null) {
			outState.putInt(SUBCATEGORY, mSubcategory.ordinal());
			outState.putInt(POSITION, mPos);
		}
	}

    public void clearHighlightedPosition() {
		// reset background color
		mPos = -1;
		repaint();
    }
    
	public void setHighlightedPosition(int pos) {
		// set the background color
		mPos = pos;
		repaint();
		
		if (isResumed()) {
    		// scroll to the highlighted guideline
    		setSelection(mPos);
		}
    }
	
	private void repaint() {
		GuidelinesAdapter adapter = (GuidelinesAdapter) getListAdapter();
		if (adapter != null) {
			// modify the adapter to trigger recreation of its item
			adapter.add(Guideline.G_18_1);
			adapter.remove(Guideline.G_18_1);
		}
	}
	
	static void highlightChanged(Guideline guideline) {
		// iterate all available fragments to make sure the previous highlighted guideline is cleared
		for (GuidelinesFragment fragment : fragments.values()) {
        	fragment.clearHighlightedPosition();
        	// check if the current fragment is the one with the new highlighted guideline
        	if (guideline.subcategory() == fragment.mSubcategory) {
        		// highlight the new guideline
        		fragment.setHighlightedPosition(Guideline.positionInSubcategory(guideline));
        	}
        }
	}
    
    private class GuidelinesAdapter extends ArrayAdapter<Guideline> {

		private LayoutInflater vi;
    	
    	GuidelinesAdapter() {
    		super(getActivity(), 0, mSubcategory.guidelines());
			vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	}
    	
    	@Override
		public View getView(int position, View v, ViewGroup parent) {
    		// Keeps reference to avoid future findViewById()
            GuidelinesViewHolder viewHolder;
            
    		if (v == null) {
    			v = vi.inflate(R.layout.guideline_list_item, null);
    			viewHolder = new GuidelinesViewHolder();
    			viewHolder.text = ((TextView) v.findViewById(R.id.text));
    			v.setTag(viewHolder);
    		} else {
    			viewHolder = (GuidelinesViewHolder) v.getTag();
    		}
    		
    		// set the background color based on the selection
			v.setBackgroundResource((mPos == position) ? 
					R.color.highlighted : 			// highlighted color
					android.R.color.transparent);	// no color - transparent
			
    		// set text to the guideline's index and text
			Guideline g = getItem(position);
			viewHolder.text.setText(String.format("%s. %s", 
					getContext().getText(g.index()),	// guideline index
					getContext().getText(g.text())));	// guideline text
			
			return v;
		}
    	
    	class GuidelinesViewHolder {
    		TextView text;
    	}
    	
    }

}
