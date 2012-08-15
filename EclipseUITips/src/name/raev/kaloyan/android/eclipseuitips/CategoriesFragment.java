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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import name.raev.kaloyan.android.eclipseuitips.model.Category;
import name.raev.kaloyan.android.eclipseuitips.model.Guideline;
import name.raev.kaloyan.android.eclipseuitips.model.Subcategory;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CategoriesFragment extends ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new CategoriesAdapter());
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// create an intent for showing the guidelines activity
		Intent intent = new Intent(getActivity(), GuidelinesPagerActivity.class);
		// determine the first guideline in the selected subcategory
		CategoryItem c = (CategoryItem) getListView().getItemAtPosition(position);
		Guideline guideline = Guideline.firstFor(Subcategory.values()[c.ordinal]);
		// pass the index of the guideline with this intent
		intent.putExtra(Guideline.EXTRA_INDEX, guideline.ordinal());
		// show the activity
		getActivity().startActivity(intent);
	}

	private class CategoriesAdapter extends ArrayAdapter<CategoryItem> {

		private LayoutInflater vi;

		public CategoriesAdapter() {
			super(getActivity(), 0, CategoryItem.list());
			vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView; // TODO try reusing the convertView

			CategoryItem c = getItem(position);
			if (c != null) {
				if (c.isSubcategory) {
					v = vi.inflate(R.layout.category_item, null);
					
					((TextView) v.findViewById(R.id.category_item_title)).setText(c.title);
				} else {
					v = vi.inflate(R.layout.category_section, null);

					v.setOnClickListener(null);
					v.setOnLongClickListener(null);
					v.setLongClickable(false);
					
					((TextView) v.findViewById(R.id.category_section_text)).setText(c.title);
				}
			}
			
			return v;
		}
		
	}
	
	private static class CategoryItem {
		
		int title;
		boolean isSubcategory;
		int ordinal;
		
		public CategoryItem(Category category) {
			title = category.title();
			isSubcategory = false;
			ordinal = category.ordinal();
		}
		
		public CategoryItem(Subcategory subcategory) {
			title = subcategory.title();
			isSubcategory = true;
			ordinal = subcategory.ordinal();
		}
		
		public static ArrayList<CategoryItem> list() {
			ArrayList<CategoryItem> list = new ArrayList<CategoryItem>();
			Set<Category> categories = new HashSet<Category>();
			Set<Subcategory> subcategories = new HashSet<Subcategory>();
			
			for (Guideline g : Guideline.values()) {
				Subcategory subcategory = g.subcategory();
				Category category = subcategory.category();
				
				if (!categories.contains(category)) {
					list.add(new CategoryItem(category));
					categories.add(category);
				}
				
				if (!subcategories.contains(subcategory)) {
					list.add(new CategoryItem(subcategory));
					subcategories.add(subcategory);
				}
			}
			
			return list;
		}
	}

}
