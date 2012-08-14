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

public enum Category {
	
	GENERAL(R.string.general), 
	GRAPHICS(R.string.graphics),
	DEVELOPMENT(R.string.development),
	COMPONENTS(R.string.components),
	FLAT(R.string.flat),
	TAO(R.string.tao),
	ACCESSIBILITY(R.string.accessibility); 
	
	int name;
	
	private Category(int name) {
		this.name = name;
	}

}
