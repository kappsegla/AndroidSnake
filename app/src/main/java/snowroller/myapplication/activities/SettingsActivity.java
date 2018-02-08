package snowroller.myapplication.activities;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import snowroller.myapplication.R;
import snowroller.myapplication.jobs.UpdateSkierStats;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences.OnSharedPreferenceChangeListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setSupportActionBar(findViewById(R.id.toolbar2));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //https://stackoverflow.com/questions/2542938/sharedpreferences-onsharedpreferencechangelistener-not-being-called-consistently/3104265#3104265
        listener =   new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

                JobScheduler jobScheduler =
                        (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

                if( sharedPreferences.getBoolean("background_updates_preference",false))
                {
                    jobScheduler.schedule(new JobInfo.Builder(1234,
                            new ComponentName(SettingsActivity.this, UpdateSkierStats.class))
                            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                            .setPeriodic(Integer.parseInt(sharedPreferences.getString("update_frequency_preference","15")) * 60000)
                            .build());
                }
                else
                {
                    // Call cancel to stop scheduling of job
                    jobScheduler.cancel(1234);
                }
            }
        };

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(listener);

    }
}
