package snowroller.myapplication.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import snowroller.myapplication.BR;
import snowroller.myapplication.models.LiftRide;
import snowroller.myapplication.models.SkistarSummary;
import snowroller.myapplication.services.SkistarAPIService;

/**
 * Created by Martin on 2018-01-24.
 */

public class TotalViewModel extends BaseObservable implements Callback<SkistarSummary> {

    private SkistarSummary summary;
    private String friendCount;

    private SkistarAPIService getService()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.skistar.com/myskistar/game/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SkistarAPIService.class);
    }

    @Bindable
    public SkistarSummary getSummary() {
        return summary;
    }

    public void setSummary(SkistarSummary summary) {
        this.summary = summary;
        notifyPropertyChanged(BR.summary);
    }

    @Bindable
    public String getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(String friendCount) {
        this.friendCount = friendCount;
        notifyPropertyChanged(BR.friendCount);
    }

    public void updateFriendCount()
    {
      getService().liftRides("3206","13").enqueue(new Callback<List<LiftRide>>() {
          @Override
          public void onResponse(Call<List<LiftRide>> call, Response<List<LiftRide>> response) {
                List<LiftRide> liftRides = response.body();
          }

          @Override
          public void onFailure(Call<List<LiftRide>> call, Throwable t) {

          }
      });
    }

    public void refresh()
    {
        getService().summary("3206").enqueue( this );
    }

    @Override
    public void onResponse(Call<SkistarSummary> call, Response<SkistarSummary> response) {
        setSummary(response.body());
    }

    @Override
    public void onFailure(Call<SkistarSummary> call, Throwable t) {

    }
}
