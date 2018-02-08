package snowroller.myapplication.application;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.preference.PreferenceManager;

import snowroller.myapplication.R;

/**
 * Created by Martin on 2018-02-08.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Set up notification channel
        registerNotificationChannel();
        //Set up default preferences
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    private void registerNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("default",
                "Channel name",
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel description");
        notificationManager.createNotificationChannel(channel);
    }
}
