package name.raev.kaloyan.android.eclipseuitips;

import name.raev.kaloyan.android.eclipseuitips.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GuidelineActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guideline);
        
        // get the index of the guideline to be displayed
        int index = (Integer) getIntent().getExtras().get(Guideline.EXTRA_INDEX);
        Guideline guideline = Guideline.values()[index];
        
        setTitle(String.format(getString(R.string.guideline), getString(guideline.index)));

        ((TextView) findViewById(R.id.textGuideline)).setText(guideline.text);
        ((TextView) findViewById(R.id.textCategory)).setText(getCategoryText(guideline));
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

}
