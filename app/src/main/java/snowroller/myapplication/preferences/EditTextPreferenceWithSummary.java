package snowroller.myapplication.preferences;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Martin on 2018-02-08.
 */

public class EditTextPreferenceWithSummary extends android.preference.EditTextPreference{
    public EditTextPreferenceWithSummary(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public EditTextPreferenceWithSummary(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextPreferenceWithSummary(Context context) {
        super(context);
    }

    @Override
    public CharSequence getSummary() {
        if ( super.getSummary() == null ) { return null; }
        String summary = super.getSummary().toString();
        return String.format(summary, getText());
    }
}
