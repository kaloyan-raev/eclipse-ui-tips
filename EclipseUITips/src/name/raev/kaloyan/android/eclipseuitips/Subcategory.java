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
import java.util.List;

public enum Subcategory {
	
	SPIRIT(R.string.spirit, Category.GENERAL),
	CAPITALIZATION(R.string.capitalization, Category.GENERAL),
	LANGUAGE(R.string.language, Category.GENERAL), 
	ERRORS(R.string.errors, Category.GENERAL), 
	DESIGN(R.string.design, Category.GRAPHICS),
	SPECIFICATIONS(R.string.specifications, Category.GRAPHICS),
	IMPLEMENTATION(R.string.implementation, Category.GRAPHICS),
	COMMANDS(R.string.commands, Category.DEVELOPMENT),
	DIALOGS(R.string.dialogs, Category.DEVELOPMENT),
	WIZARDS(R.string.wizards, Category.DEVELOPMENT),
	EDITORS(R.string.editors, Category.DEVELOPMENT),
	VIEWS(R.string.views, Category.DEVELOPMENT),
	PERSPECTIVES(R.string.perspectives, Category.DEVELOPMENT),
	WINDOWDS(R.string.windows, Category.DEVELOPMENT),
	PROPERTIES(R.string.properties, Category.DEVELOPMENT),
	WIDGETS(R.string.widgets, Category.DEVELOPMENT),
	COMPONENTS(R.string.components, Category.COMPONENTS),
	NAVIGATOR(R.string.navigator, Category.COMPONENTS),
	TASKS(R.string.tasks, Category.COMPONENTS),
	PREFERENCES(R.string.preferences, Category.COMPONENTS),
	FLAT(R.string.flat, Category.FLAT),
	TAO(R.string.tao, Category.TAO),
	ACCESSIBILITY(R.string.accessibility, Category.ACCESSIBILITY);
	
	int name;
	Category category;
	
	private Subcategory(int name, Category category) {
		this.name = name;
		this.category = category;
	}
	
	public List<Guideline> guidelines() {
		List<Guideline> result = new ArrayList<Guideline>();
		
		for (Guideline g : Guideline.values()) {
			if (this.equals(g.subcategory)) {
				result.add(g);
			}
		}
		
		return result;
	}

}
