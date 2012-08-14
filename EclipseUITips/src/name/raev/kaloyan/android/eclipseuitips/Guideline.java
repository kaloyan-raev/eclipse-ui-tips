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

import java.util.Random;

public enum Guideline {

	G_1_1(R.string.index_1_1, Category.GENERAL, Subcategory.SPIRIT, R.string.guideline_1_1), 
	G_1_2(R.string.index_1_2, Category.GENERAL, Subcategory.SPIRIT, R.string.guideline_1_2), 
	G_1_3(R.string.index_1_3, Category.GENERAL, Subcategory.SPIRIT, R.string.guideline_1_3), 
	G_1_4(R.string.index_1_4, Category.GENERAL, Subcategory.SPIRIT, R.string.guideline_1_4), 
	G_1_5(R.string.index_1_5, Category.GENERAL, Subcategory.CAPITALIZATION, R.string.guideline_1_5), 
	G_1_6(R.string.index_1_6, Category.GENERAL, Subcategory.CAPITALIZATION, R.string.guideline_1_6), 
	G_1_7(R.string.index_1_7, Category.GENERAL, Subcategory.LANGUAGE, R.string.guideline_1_7), 
	G_1_8(R.string.index_1_8, Category.GENERAL, Subcategory.ERRORS, R.string.guideline_1_8), 
	G_1_9(R.string.index_1_9, Category.GENERAL, Subcategory.ERRORS, R.string.guideline_1_9), 
	G_2_1(R.string.index_2_1, Category.GRAPHICS, Subcategory.DESIGN, R.string.guideline_2_1), 
	G_2_2(R.string.index_2_2, Category.GRAPHICS, Subcategory.DESIGN, R.string.guideline_2_2), 
	G_2_3(R.string.index_2_3, Category.GRAPHICS, Subcategory.DESIGN, R.string.guideline_2_3), 
	G_2_4(R.string.index_2_4, Category.GRAPHICS, Subcategory.DESIGN, R.string.guideline_2_4), 
	G_2_5(R.string.index_2_5, Category.GRAPHICS, Subcategory.DESIGN, R.string.guideline_2_5), 
	G_2_6(R.string.index_2_6, Category.GRAPHICS, Subcategory.DESIGN, R.string.guideline_2_6), 
	G_2_7(R.string.index_2_7, Category.GRAPHICS, Subcategory.SPECIFICATIONS, R.string.guideline_2_7), 
	G_2_8(R.string.index_2_8, Category.GRAPHICS, Subcategory.SPECIFICATIONS, R.string.guideline_2_8), 
	G_2_9(R.string.index_2_9, Category.GRAPHICS, Subcategory.SPECIFICATIONS, R.string.guideline_2_9), 
	G_2_10(R.string.index_2_10, Category.GRAPHICS, Subcategory.SPECIFICATIONS, R.string.guideline_2_10), 
	G_2_11(R.string.index_2_11, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_11), 
	G_2_12(R.string.index_2_12, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_12), 
	G_2_13(R.string.index_2_13, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_13), 
	G_2_14(R.string.index_2_14, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_14), 
	G_2_15(R.string.index_2_15, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_15), 
	G_2_16(R.string.index_2_16, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_16), 
	G_2_17(R.string.index_2_17, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_17), 
	G_2_18(R.string.index_2_18, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_18), 
	G_2_19(R.string.index_2_19, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_19), 
	G_2_20(R.string.index_2_20, Category.GRAPHICS, Subcategory.IMPLEMENTATION, R.string.guideline_2_20), 
	G_3_1(R.string.index_3_1, Category.DEVELOPMENT, Subcategory.COMMANDS, R.string.guideline_3_1), 
	G_3_2(R.string.index_3_2, Category.DEVELOPMENT, Subcategory.COMMANDS, R.string.guideline_3_2), 
	G_3_3(R.string.index_3_3, Category.DEVELOPMENT, Subcategory.COMMANDS, R.string.guideline_3_3), 
	G_3_4(R.string.index_3_4, Category.DEVELOPMENT, Subcategory.COMMANDS, R.string.guideline_3_4), 
	G_3_5(R.string.index_3_5, Category.DEVELOPMENT, Subcategory.COMMANDS, R.string.guideline_3_5), 
	G_4_1(R.string.index_4_1, Category.DEVELOPMENT, Subcategory.DIALOGS, R.string.guideline_4_1), 
	G_4_2(R.string.index_4_2, Category.DEVELOPMENT, Subcategory.DIALOGS, R.string.guideline_4_2), 
	G_5_1(R.string.index_5_1, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_1), 
	G_5_2(R.string.index_5_2, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_2), 
	G_5_3(R.string.index_5_3, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_3), 
	G_5_4(R.string.index_5_4, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_4), 
	G_5_5(R.string.index_5_5, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_5), 
	G_5_6(R.string.index_5_6, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_6), 
	G_5_7(R.string.index_5_7, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_7), 
	G_5_8(R.string.index_5_8, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_8), 
	G_5_9(R.string.index_5_9, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_9), 
	G_5_10(R.string.index_5_10, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_10), 
	G_5_11(R.string.index_5_11, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_11), 
	G_5_12(R.string.index_5_12, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_12), 
	G_5_13(R.string.index_5_13, Category.DEVELOPMENT, Subcategory.WIZARDS, R.string.guideline_5_13), 
	G_6_1(R.string.index_6_1, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_1), 
	G_6_2(R.string.index_6_2, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_2), 
	G_6_3(R.string.index_6_3, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_3), 
	G_6_4(R.string.index_6_4, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_4), 
	G_6_5(R.string.index_6_5, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_5), 
	G_6_6(R.string.index_6_6, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_6), 
	G_6_7(R.string.index_6_7, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_7), 
	G_6_8(R.string.index_6_8, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_8), 
	G_6_9(R.string.index_6_9, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_9), 
	G_6_10(R.string.index_6_10, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_10), 
	G_6_11(R.string.index_6_11, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_11), 
	G_6_12(R.string.index_6_12, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_12), 
	G_6_13(R.string.index_6_13, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_13), 
	G_6_14(R.string.index_6_14, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_14), 
	G_6_15(R.string.index_6_15, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_15), 
	G_6_16(R.string.index_6_16, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_16), 
	G_6_17(R.string.index_6_17, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_17), 
	G_6_18(R.string.index_6_18, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_18), 
	G_6_19(R.string.index_6_19, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_19), 
	G_6_20(R.string.index_6_20, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_20), 
	G_6_21(R.string.index_6_21, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_21), 
	G_6_22(R.string.index_6_22, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_22), 
	G_6_23(R.string.index_6_23, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_23), 
	G_6_24(R.string.index_6_24, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_24), 
	G_6_25(R.string.index_6_25, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_25), 
	G_6_26(R.string.index_6_26, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_26), 
	G_6_27(R.string.index_6_27, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_27), 
	G_6_28(R.string.index_6_28, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_28), 
	G_6_29(R.string.index_6_29, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_29), 
	G_6_30(R.string.index_6_30, Category.DEVELOPMENT, Subcategory.EDITORS, R.string.guideline_6_30), 
	G_7_1(R.string.index_7_1, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_1), 
	G_7_2(R.string.index_7_2, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_2), 
	G_7_3(R.string.index_7_3, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_3), 
	G_7_4(R.string.index_7_4, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_4), 
	G_7_5(R.string.index_7_5, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_5), 
	G_7_6(R.string.index_7_6, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_6), 
	G_7_7(R.string.index_7_7, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_7), 
	G_7_8(R.string.index_7_8, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_8), 
	G_7_9(R.string.index_7_9, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_9), 
	G_7_10(R.string.index_7_10, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_10), 
	G_7_11(R.string.index_7_11, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_11), 
	G_7_12(R.string.index_7_12, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_12), 
	G_7_13(R.string.index_7_13, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_13), 
	G_7_14(R.string.index_7_14, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_14), 
	G_7_15(R.string.index_7_15, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_15), 
	G_7_16(R.string.index_7_16, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_16), 
	G_7_17(R.string.index_7_17, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_17), 
	G_7_18(R.string.index_7_18, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_18), 
	G_7_19(R.string.index_7_19, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_19), 
	G_7_20(R.string.index_7_20, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_20), 
	G_7_21(R.string.index_7_21, Category.DEVELOPMENT, Subcategory.VIEWS, R.string.guideline_7_21), 
	G_8_1(R.string.index_8_1, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_1), 
	G_8_2(R.string.index_8_2, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_2), 
	G_8_3(R.string.index_8_3, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_3), 
	G_8_4(R.string.index_8_4, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_4), 
	G_8_5(R.string.index_8_5, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_5), 
	G_8_6(R.string.index_8_6, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_6), 
	G_8_7(R.string.index_8_7, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_7), 
	G_8_8(R.string.index_8_8, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_8), 
	G_8_9(R.string.index_8_9, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_9), 
	G_8_10(R.string.index_8_10, Category.DEVELOPMENT, Subcategory.PERSPECTIVES, R.string.guideline_8_10), 
	G_9_1(R.string.index_9_1, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_1), 
	G_9_2(R.string.index_9_2, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_2), 
	G_9_3(R.string.index_9_3, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_3), 
	G_9_4(R.string.index_9_4, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_4), 
	G_9_5(R.string.index_9_5, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_5), 
	G_9_6(R.string.index_9_6, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_6), 
	G_9_7(R.string.index_9_7, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_7), 
	G_9_8(R.string.index_9_8, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_8), 
	G_9_9(R.string.index_9_9, Category.DEVELOPMENT, Subcategory.WINDOWDS, R.string.guideline_9_9), 
	G_10_1(R.string.index_10_1, Category.DEVELOPMENT, Subcategory.PROPERTIES, R.string.guideline_10_1), 
	G_10_2(R.string.index_10_2, Category.DEVELOPMENT, Subcategory.PROPERTIES, R.string.guideline_10_2), 
	G_10_3(R.string.index_10_3, Category.DEVELOPMENT, Subcategory.PROPERTIES, R.string.guideline_10_3), 
	G_10_4(R.string.index_10_4, Category.DEVELOPMENT, Subcategory.PROPERTIES, R.string.guideline_10_4), 
	G_11_1(R.string.index_11_1, Category.DEVELOPMENT, Subcategory.WIDGETS, R.string.guideline_11_1), 
	G_12_1(R.string.index_12_1, Category.COMPONENTS, Subcategory.COMPONENTS, R.string.guideline_12_1), 
	G_12_2(R.string.index_12_2, Category.COMPONENTS, Subcategory.COMPONENTS, R.string.guideline_12_2), 
	G_13_1(R.string.index_13_1, Category.COMPONENTS, Subcategory.NAVIGATOR, R.string.guideline_13_1), 
	G_13_2(R.string.index_13_2, Category.COMPONENTS, Subcategory.NAVIGATOR, R.string.guideline_13_2), 
	G_13_3(R.string.index_13_3, Category.COMPONENTS, Subcategory.NAVIGATOR, R.string.guideline_13_3), 
	G_14_1(R.string.index_14_1, Category.COMPONENTS, Subcategory.TASKS, R.string.guideline_14_1), 
	G_14_2(R.string.index_14_2, Category.COMPONENTS, Subcategory.TASKS, R.string.guideline_14_2), 
	G_14_3(R.string.index_14_3, Category.COMPONENTS, Subcategory.TASKS, R.string.guideline_14_3), 
	G_14_4(R.string.index_14_4, Category.COMPONENTS, Subcategory.TASKS, R.string.guideline_14_4), 
	G_14_5(R.string.index_14_5, Category.COMPONENTS, Subcategory.TASKS, R.string.guideline_14_5), 
	G_15_1(R.string.index_15_1, Category.COMPONENTS, Subcategory.PREFERENCES, R.string.guideline_15_1), 
	G_15_2(R.string.index_15_2, Category.COMPONENTS, Subcategory.PREFERENCES, R.string.guideline_15_2), 
	G_15_3(R.string.index_15_3, Category.COMPONENTS, Subcategory.PREFERENCES, R.string.guideline_15_3), 
	G_15_4(R.string.index_15_4, Category.COMPONENTS, Subcategory.PREFERENCES, R.string.guideline_15_4), 
	G_15_5(R.string.index_15_5, Category.COMPONENTS, Subcategory.PREFERENCES, R.string.guideline_15_5), 
	G_16_1(R.string.index_16_1, Category.FLAT, Subcategory.FLAT, R.string.guideline_16_1), 
	G_16_2(R.string.index_16_2, Category.FLAT, Subcategory.FLAT, R.string.guideline_16_2), 
	G_16_3(R.string.index_16_3, Category.FLAT, Subcategory.FLAT, R.string.guideline_16_3), 
	G_17_1(R.string.index_17_1, Category.TAO, Subcategory.TAO, R.string.guideline_17_1), 
	G_18_1(R.string.index_18_1, Category.ACCESSIBILITY, Subcategory.ACCESSIBILITY, R.string.guideline_18_1);
	
	public static final String EXTRA_INDEX = Guideline.class.getName() + "Index";
	public static final String EXTRA_HIGHLIGHTED = Guideline.class.getName() + "Highlighted";
	
	int index;
	Category category;
	Subcategory subcategory;
	int text;
	
	private Guideline(int index, Category category, Subcategory subcategory, int text) {
		this.index = index;
		this.category = category;
		this.subcategory = subcategory;
		this.text = text;
	}
	
	public static Guideline random() {
		int index = new Random().nextInt(Guideline.values().length);
		return Guideline.values()[index];
	}

	public static Guideline firstFor(Subcategory subcategory) {
		for (Guideline g : Guideline.values()) {
			if (g.subcategory.equals(subcategory)) {
				return g;
			}
		}
		return null;
	}
	
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
