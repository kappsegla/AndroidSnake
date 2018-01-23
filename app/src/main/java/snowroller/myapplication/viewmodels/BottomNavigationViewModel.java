package snowroller.myapplication.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;

import snowroller.myapplication.BR;

/**
 * Created by Martin on 2018-01-20.
 */

public class BottomNavigationViewModel extends BaseObservable{

    private boolean loading;

    public void onRefresh(){
        new Handler().postDelayed(()-> setLoading(false), 2000);
    }

    @Bindable
    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
        notifyPropertyChanged(BR.loading);
    }
}
