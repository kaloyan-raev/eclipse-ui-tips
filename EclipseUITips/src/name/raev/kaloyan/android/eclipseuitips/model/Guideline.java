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

import java.util.Random;

import name.raev.kaloyan.android.eclipseuitips.R;

/**
 * Enumerates all Eclipse UI Guidelines. 
 * 
 * The Eclipse UI Guidelines are grouped in a tree hierarchy: categories, 
 * subcategories and guidelines. 
 */
public enum Guideline {

	G_1_1(R.string.index_1_1, Subcategory.SPIRIT, R.string.guideline_1_1), 
	G_1_2(R.string.index_1_2, Subcategory.SPIRIT, R.string.guideline_1_2), 
	G_1_3(R.string.index_1_3, Subcategory.SPIRIT, R.string.guideline_1_3), 
	G_1_4(R.string.index_1_4, Subcategory.SPIRIT, R.string.guideline_1_4), 
	G_1_5(R.string.index_1_5, Subcategory.CAPITALIZATION, R.string.guideline_1_5), 
	G_1_6(R.string.index_1_6, Subcategory.CAPITALIZATION, R.string.guideline_1_6), 
	G_1_7(R.string.index_1_7, Subcategory.LANGUAGE, R.string.guideline_1_7), 
	G_1_8(R.string.index_1_8, Subcategory.ERRORS, R.string.guideline_1_8), 
	G_1_9(R.string.index_1_9, Subcategory.ERRORS, R.string.guideline_1_9), 
	G_2_1(R.string.index_2_1, Subcategory.DESIGN, R.string.guideline_2_1), 
	G_2_2(R.string.index_2_2, Subcategory.DESIGN, R.string.guideline_2_2), 
	G_2_3(R.string.index_2_3, Subcategory.DESIGN, R.string.guideline_2_3), 
	G_2_4(R.string.index_2_4, Subcategory.DESIGN, R.string.guideline_2_4), 
	G_2_5(R.string.index_2_5, Subcategory.DESIGN, R.string.guideline_2_5), 
	G_2_6(R.string.index_2_6, Subcategory.DESIGN, R.string.guideline_2_6), 
	G_2_7(R.string.index_2_7, Subcategory.SPECIFICATIONS, R.string.guideline_2_7), 
	G_2_8(R.string.index_2_8, Subcategory.SPECIFICATIONS, R.string.guideline_2_8), 
	G_2_9(R.string.index_2_9, Subcategory.SPECIFICATIONS, R.string.guideline_2_9), 
	G_2_10(R.string.index_2_10, Subcategory.SPECIFICATIONS, R.string.guideline_2_10), 
	G_2_11(R.string.index_2_11, Subcategory.IMPLEMENTATION, R.string.guideline_2_11), 
	G_2_12(R.string.index_2_12, Subcategory.IMPLEMENTATION, R.string.guideline_2_12), 
	G_2_13(R.string.index_2_13, Subcategory.IMPLEMENTATION, R.string.guideline_2_13), 
	G_2_14(R.string.index_2_14, Subcategory.IMPLEMENTATION, R.string.guideline_2_14), 
	G_2_15(R.string.index_2_15, Subcategory.IMPLEMENTATION, R.string.guideline_2_15), 
	G_2_16(R.string.index_2_16, Subcategory.IMPLEMENTATION, R.string.guideline_2_16), 
	G_2_17(R.string.index_2_17, Subcategory.IMPLEMENTATION, R.string.guideline_2_17), 
	G_2_18(R.string.index_2_18, Subcategory.IMPLEMENTATION, R.string.guideline_2_18), 
	G_2_19(R.string.index_2_19, Subcategory.IMPLEMENTATION, R.string.guideline_2_19), 
	G_2_20(R.string.index_2_20, Subcategory.IMPLEMENTATION, R.string.guideline_2_20), 
	G_3_1(R.string.index_3_1, Subcategory.COMMANDS, R.string.guideline_3_1), 
	G_3_2(R.string.index_3_2, Subcategory.COMMANDS, R.string.guideline_3_2), 
	G_3_3(R.string.index_3_3, Subcategory.COMMANDS, R.string.guideline_3_3), 
	G_3_4(R.string.index_3_4, Subcategory.COMMANDS, R.string.guideline_3_4), 
	G_3_5(R.string.index_3_5, Subcategory.COMMANDS, R.string.guideline_3_5), 
	G_4_1(R.string.index_4_1, Subcategory.DIALOGS, R.string.guideline_4_1), 
	G_4_2(R.string.index_4_2, Subcategory.DIALOGS, R.string.guideline_4_2), 
	G_5_1(R.string.index_5_1, Subcategory.WIZARDS, R.string.guideline_5_1), 
	G_5_2(R.string.index_5_2, Subcategory.WIZARDS, R.string.guideline_5_2), 
	G_5_3(R.string.index_5_3, Subcategory.WIZARDS, R.string.guideline_5_3), 
	G_5_4(R.string.index_5_4, Subcategory.WIZARDS, R.string.guideline_5_4), 
	G_5_5(R.string.index_5_5, Subcategory.WIZARDS, R.string.guideline_5_5), 
	G_5_6(R.string.index_5_6, Subcategory.WIZARDS, R.string.guideline_5_6), 
	G_5_7(R.string.index_5_7, Subcategory.WIZARDS, R.string.guideline_5_7), 
	G_5_8(R.string.index_5_8, Subcategory.WIZARDS, R.string.guideline_5_8), 
	G_5_9(R.string.index_5_9, Subcategory.WIZARDS, R.string.guideline_5_9), 
	G_5_10(R.string.index_5_10, Subcategory.WIZARDS, R.string.guideline_5_10), 
	G_5_11(R.string.index_5_11, Subcategory.WIZARDS, R.string.guideline_5_11), 
	G_5_12(R.string.index_5_12, Subcategory.WIZARDS, R.string.guideline_5_12), 
	G_5_13(R.string.index_5_13, Subcategory.WIZARDS, R.string.guideline_5_13), 
	G_6_1(R.string.index_6_1, Subcategory.EDITORS, R.string.guideline_6_1), 
	G_6_2(R.string.index_6_2, Subcategory.EDITORS, R.string.guideline_6_2), 
	G_6_3(R.string.index_6_3, Subcategory.EDITORS, R.string.guideline_6_3), 
	G_6_4(R.string.index_6_4, Subcategory.EDITORS, R.string.guideline_6_4), 
	G_6_5(R.string.index_6_5, Subcategory.EDITORS, R.string.guideline_6_5), 
	G_6_6(R.string.index_6_6, Subcategory.EDITORS, R.string.guideline_6_6), 
	G_6_7(R.string.index_6_7, Subcategory.EDITORS, R.string.guideline_6_7), 
	G_6_8(R.string.index_6_8, Subcategory.EDITORS, R.string.guideline_6_8), 
	G_6_9(R.string.index_6_9, Subcategory.EDITORS, R.string.guideline_6_9), 
	G_6_10(R.string.index_6_10, Subcategory.EDITORS, R.string.guideline_6_10), 
	G_6_11(R.string.index_6_11, Subcategory.EDITORS, R.string.guideline_6_11), 
	G_6_12(R.string.index_6_12, Subcategory.EDITORS, R.string.guideline_6_12), 
	G_6_13(R.string.index_6_13, Subcategory.EDITORS, R.string.guideline_6_13), 
	G_6_14(R.string.index_6_14, Subcategory.EDITORS, R.string.guideline_6_14), 
	G_6_15(R.string.index_6_15, Subcategory.EDITORS, R.string.guideline_6_15), 
	G_6_16(R.string.index_6_16, Subcategory.EDITORS, R.string.guideline_6_16), 
	G_6_17(R.string.index_6_17, Subcategory.EDITORS, R.string.guideline_6_17), 
	G_6_18(R.string.index_6_18, Subcategory.EDITORS, R.string.guideline_6_18), 
	G_6_19(R.string.index_6_19, Subcategory.EDITORS, R.string.guideline_6_19), 
	G_6_20(R.string.index_6_20, Subcategory.EDITORS, R.string.guideline_6_20), 
	G_6_21(R.string.index_6_21, Subcategory.EDITORS, R.string.guideline_6_21), 
	G_6_22(R.string.index_6_22, Subcategory.EDITORS, R.string.guideline_6_22), 
	G_6_23(R.string.index_6_23, Subcategory.EDITORS, R.string.guideline_6_23), 
	G_6_24(R.string.index_6_24, Subcategory.EDITORS, R.string.guideline_6_24), 
	G_6_25(R.string.index_6_25, Subcategory.EDITORS, R.string.guideline_6_25), 
	G_6_26(R.string.index_6_26, Subcategory.EDITORS, R.string.guideline_6_26), 
	G_6_27(R.string.index_6_27, Subcategory.EDITORS, R.string.guideline_6_27), 
	G_6_28(R.string.index_6_28, Subcategory.EDITORS, R.string.guideline_6_28), 
	G_6_29(R.string.index_6_29, Subcategory.EDITORS, R.string.guideline_6_29), 
	G_6_30(R.string.index_6_30, Subcategory.EDITORS, R.string.guideline_6_30), 
	G_7_1(R.string.index_7_1, Subcategory.VIEWS, R.string.guideline_7_1), 
	G_7_2(R.string.index_7_2, Subcategory.VIEWS, R.string.guideline_7_2), 
	G_7_3(R.string.index_7_3, Subcategory.VIEWS, R.string.guideline_7_3), 
	G_7_4(R.string.index_7_4, Subcategory.VIEWS, R.string.guideline_7_4), 
	G_7_5(R.string.index_7_5, Subcategory.VIEWS, R.string.guideline_7_5), 
	G_7_6(R.string.index_7_6, Subcategory.VIEWS, R.string.guideline_7_6), 
	G_7_7(R.string.index_7_7, Subcategory.VIEWS, R.string.guideline_7_7), 
	G_7_8(R.string.index_7_8, Subcategory.VIEWS, R.string.guideline_7_8), 
	G_7_9(R.string.index_7_9, Subcategory.VIEWS, R.string.guideline_7_9), 
	G_7_10(R.string.index_7_10, Subcategory.VIEWS, R.string.guideline_7_10), 
	G_7_11(R.string.index_7_11, Subcategory.VIEWS, R.string.guideline_7_11), 
	G_7_12(R.string.index_7_12, Subcategory.VIEWS, R.string.guideline_7_12), 
	G_7_13(R.string.index_7_13, Subcategory.VIEWS, R.string.guideline_7_13), 
	G_7_14(R.string.index_7_14, Subcategory.VIEWS, R.string.guideline_7_14), 
	G_7_15(R.string.index_7_15, Subcategory.VIEWS, R.string.guideline_7_15), 
	G_7_16(R.string.index_7_16, Subcategory.VIEWS, R.string.guideline_7_16), 
	G_7_17(R.string.index_7_17, Subcategory.VIEWS, R.string.guideline_7_17), 
	G_7_18(R.string.index_7_18, Subcategory.VIEWS, R.string.guideline_7_18), 
	G_7_19(R.string.index_7_19, Subcategory.VIEWS, R.string.guideline_7_19), 
	G_7_20(R.string.index_7_20, Subcategory.VIEWS, R.string.guideline_7_20), 
	G_7_21(R.string.index_7_21, Subcategory.VIEWS, R.string.guideline_7_21), 
	G_8_1(R.string.index_8_1, Subcategory.PERSPECTIVES, R.string.guideline_8_1), 
	G_8_2(R.string.index_8_2, Subcategory.PERSPECTIVES, R.string.guideline_8_2), 
	G_8_3(R.string.index_8_3, Subcategory.PERSPECTIVES, R.string.guideline_8_3), 
	G_8_4(R.string.index_8_4, Subcategory.PERSPECTIVES, R.string.guideline_8_4), 
	G_8_5(R.string.index_8_5, Subcategory.PERSPECTIVES, R.string.guideline_8_5), 
	G_8_6(R.string.index_8_6, Subcategory.PERSPECTIVES, R.string.guideline_8_6), 
	G_8_7(R.string.index_8_7, Subcategory.PERSPECTIVES, R.string.guideline_8_7), 
	G_8_8(R.string.index_8_8, Subcategory.PERSPECTIVES, R.string.guideline_8_8), 
	G_8_9(R.string.index_8_9, Subcategory.PERSPECTIVES, R.string.guideline_8_9), 
	G_8_10(R.string.index_8_10, Subcategory.PERSPECTIVES, R.string.guideline_8_10), 
	G_9_1(R.string.index_9_1, Subcategory.WINDOWDS, R.string.guideline_9_1), 
	G_9_2(R.string.index_9_2, Subcategory.WINDOWDS, R.string.guideline_9_2), 
	G_9_3(R.string.index_9_3, Subcategory.WINDOWDS, R.string.guideline_9_3), 
	G_9_4(R.string.index_9_4, Subcategory.WINDOWDS, R.string.guideline_9_4), 
	G_9_5(R.string.index_9_5, Subcategory.WINDOWDS, R.string.guideline_9_5), 
	G_9_6(R.string.index_9_6, Subcategory.WINDOWDS, R.string.guideline_9_6), 
	G_9_7(R.string.index_9_7, Subcategory.WINDOWDS, R.string.guideline_9_7), 
	G_9_8(R.string.index_9_8, Subcategory.WINDOWDS, R.string.guideline_9_8), 
	G_9_9(R.string.index_9_9, Subcategory.WINDOWDS, R.string.guideline_9_9), 
	G_10_1(R.string.index_10_1, Subcategory.PROPERTIES, R.string.guideline_10_1), 
	G_10_2(R.string.index_10_2, Subcategory.PROPERTIES, R.string.guideline_10_2), 
	G_10_3(R.string.index_10_3, Subcategory.PROPERTIES, R.string.guideline_10_3), 
	G_10_4(R.string.index_10_4, Subcategory.PROPERTIES, R.string.guideline_10_4), 
	G_11_1(R.string.index_11_1, Subcategory.WIDGETS, R.string.guideline_11_1), 
	G_12_1(R.string.index_12_1, Subcategory.COMPONENTS, R.string.guideline_12_1), 
	G_12_2(R.string.index_12_2, Subcategory.COMPONENTS, R.string.guideline_12_2), 
	G_13_1(R.string.index_13_1, Subcategory.NAVIGATOR, R.string.guideline_13_1), 
	G_13_2(R.string.index_13_2, Subcategory.NAVIGATOR, R.string.guideline_13_2), 
	G_13_3(R.string.index_13_3, Subcategory.NAVIGATOR, R.string.guideline_13_3), 
	G_14_1(R.string.index_14_1, Subcategory.TASKS, R.string.guideline_14_1), 
	G_14_2(R.string.index_14_2, Subcategory.TASKS, R.string.guideline_14_2), 
	G_14_3(R.string.index_14_3, Subcategory.TASKS, R.string.guideline_14_3), 
	G_14_4(R.string.index_14_4, Subcategory.TASKS, R.string.guideline_14_4), 
	G_14_5(R.string.index_14_5, Subcategory.TASKS, R.string.guideline_14_5), 
	G_15_1(R.string.index_15_1, Subcategory.PREFERENCES, R.string.guideline_15_1), 
	G_15_2(R.string.index_15_2, Subcategory.PREFERENCES, R.string.guideline_15_2), 
	G_15_3(R.string.index_15_3, Subcategory.PREFERENCES, R.string.guideline_15_3), 
	G_15_4(R.string.index_15_4, Subcategory.PREFERENCES, R.string.guideline_15_4), 
	G_15_5(R.string.index_15_5, Subcategory.PREFERENCES, R.string.guideline_15_5), 
	G_16_1(R.string.index_16_1, Subcategory.FLAT, R.string.guideline_16_1), 
	G_16_2(R.string.index_16_2, Subcategory.FLAT, R.string.guideline_16_2), 
	G_16_3(R.string.index_16_3, Subcategory.FLAT, R.string.guideline_16_3), 
	G_17_1(R.string.index_17_1, Subcategory.TAO, R.string.guideline_17_1), 
	G_18_1(R.string.index_18_1, Subcategory.ACCESSIBILITY, R.string.guideline_18_1);
	
	public static final String EXTRA_INDEX = Guideline.class.getName() + "Index";
	public static final String EXTRA_HIGHLIGHTED = Guideline.class.getName() + "Highlighted";
	
	private int index;
	private Subcategory subcategory;
	private int text;
	
	private Guideline(int index, Subcategory subcategory, int text) {
		this.index = index;
		this.subcategory = subcategory;
		this.text = text;
	}
	
	/**
	 * Returns the numeric index of the guideline.
	 * @return resource id of the index
	 */
	public int index() {
		return index;
	}
	
	/**
	 * Returns the subcategory that this guideline belongs to. 
	 * @return the parent subcategory
	 */
	public Subcategory subcategory() {
		return subcategory;
	}
	
	/**
	 * Returns the guideline's text.
	 * @return resource id of the text
	 */
	public int text() {
		return text;
	}
	
	/**
	 * Returns a random guideline. 
	 * @return a guideline
	 */
	public static Guideline random() {
		int x = new Random().nextInt(Guideline.values().length);
		return Guideline.values()[x];
	}

	/**
	 * Returns the first guideline in the specified subcategory. 
	 * @param subcategory the subcategory to look into
	 * @return a guideline
	 */
	public static Guideline firstFor(Subcategory subcategory) {
		for (Guideline g : Guideline.values()) {
			if (g.subcategory.equals(subcategory)) {
				return g;
			}
		}
		return null;
	}
	
	/**
	 * Returns the position of the specified guideline in its subcategory. 
	 * @param guideline the guideline to find the position of
	 * @return the 0-based position of the guideline
	 */
	public static int positionInSubcategory(Guideline guideline) {
		int pos = -1;
		
		for (Guideline g : Guideline.values()) {
			if (g.subcategory == guideline.subcategory) {
				pos++;
				if (g == guideline) {
					break;
				}
			}
		}
		
		return pos;
	}
	
}
