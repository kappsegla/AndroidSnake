package snowroller.myapplication.viewmodels;

import android.databinding.BaseObservable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import snowroller.myapplication.models.SkistarSummary;

/**
 * Created by Martin on 2018-01-24.
 */

public class TotalViewModel extends BaseObservable implements Callback<SkistarSummary> {

    public void refresh()
    {
       // Services.getService().summary("3206").enqueue( this );
    }

    @Override
    public void onResponse(Call<SkistarSummary> call, Response<SkistarSummary> response) {

    }

    @Override
    public void onFailure(Call<SkistarSummary> call, Throwable t) {

    }
}
