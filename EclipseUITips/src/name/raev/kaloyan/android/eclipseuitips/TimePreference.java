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
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

public class TimePreference extends DialogPreference {
    private Time time = new Time();
    private TimePicker picker = null;

    public TimePreference(Context context) {
        this(context, null);
    }

    public TimePreference(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextPreferenceStyle);
    }

    public TimePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected View onCreateDialogView() {
        picker = new TimePicker(getContext());
        picker.setIs24HourView(DateFormat.is24HourFormat(getContext()));
        return picker;
    }

    @Override
    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        
        picker.setCurrentHour(time.getHour());
        picker.setCurrentMinute(time.getMinute());
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {
        	// clear the focus to make sure that the fields are updated properly
        	picker.clearFocus();
        	
        	time = new Time(picker.getCurrentHour(), picker.getCurrentMinute());
        	
            if (callChangeListener(time)) {
                persistString(time.toString());
                notifyChanged();
            }
        }
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return (a.getString(index));
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
    	String value = (String) defaultValue;
    	
    	if (value == null) {
    		value = Time.DEFAULT;
    	}
    	
    	if (restoreValue) {
    		value = getPersistedString(value);
    	}
    	
    	time = new Time(value);
    }
    
    @Override
    public CharSequence getSummary() {
        return DateFormat.getTimeFormat(getContext()).format(time.toDate());
    }
} 