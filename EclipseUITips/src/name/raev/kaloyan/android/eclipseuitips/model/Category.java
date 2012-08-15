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
package name.raev.kaloyan.android.eclipseuitips.model;

import name.raev.kaloyan.android.eclipseuitips.R;

/**
 * Enumerates all categories of the Eclipse UI Guidelines. 
 * 
 * The Eclipse UI Guidelines are grouped in a tree hierarchy: categories, 
 * subcategories and guidelines. 
 */
public enum Category {
	
	GENERAL(R.string.general), 
	GRAPHICS(R.string.graphics),
	DEVELOPMENT(R.string.development),
	COMPONENTS(R.string.components),
	FLAT(R.string.flat),
	TAO(R.string.tao),
	ACCESSIBILITY(R.string.accessibility); 
	
	private int title;
	
	private Category(int title) {
		this.title = title;
	}
	
	/**
	 * Returns the category's title. 
	 * @return resource id of the title string
	 */
	public int title() {
		return title;
	}

}
