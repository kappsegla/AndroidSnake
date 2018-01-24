package snowroller.myapplication.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import snowroller.myapplication.BR;
import snowroller.myapplication.models.SkistarSummary;
import snowroller.myapplication.services.SkistarAPIService;

/**
 * Created by Martin on 2018-01-24.
 */

public class TotalFragmentViewModel extends BaseObservable implements Callback<SkistarSummary> {

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
      getService().friendCount("3206").enqueue(new Callback<Integer>() {
          @Override
          public void onResponse(Call<Integer> call, Response<Integer> response) {
              setFriendCount(response.body().toString());
          }

          @Override
          public void onFailure(Call<Integer> call, Throwable t) {

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
