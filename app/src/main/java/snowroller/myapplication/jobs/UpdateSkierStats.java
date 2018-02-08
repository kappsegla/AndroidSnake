package snowroller.myapplication.jobs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import snowroller.myapplication.R;
import snowroller.myapplication.models.Latest;
import snowroller.myapplication.services.Services;

/**
 * Created by Martin on 2018-02-06.
 */

public class UpdateSkierStats extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d("SKISTAR", "onStartJob called");

        Services.getService().latestStatistics("3206").enqueue(new Callback<Latest>() {
            @Override
            public void onResponse(Call<Latest> call, Response<Latest> response) {
                jobFinished(jobParameters,false);

                //If running on sdk >= 26 we must create a notification channel
                //Code for that is in BottomNavigationActivity
                Notification.Builder builder =
                        new Notification.Builder(UpdateSkierStats.this, "default")
                                .setSmallIcon(R.drawable.ic_small_notification_pet_icon)
                                .setContentTitle("This is title")
                                .setContentText("This is some text");

                ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE))
                        .notify( 1, builder.build() );
            }

            @Override
            public void onFailure(Call<Latest> call, Throwable t) {
                jobFinished(jobParameters,false);
            }
        });
        return true;
}

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        //Todo: Maybe call cancel on the service?
        return false;
    }
}
