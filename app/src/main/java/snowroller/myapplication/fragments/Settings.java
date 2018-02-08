package snowroller.myapplication.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import snowroller.myapplication.R;

/**
 * Created by Martin on 2018-02-08.
 */

public class Settings extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
