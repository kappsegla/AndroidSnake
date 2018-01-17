package snowroller.myapplication.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingConversion;
import android.databinding.ObservableField;
import android.view.View;

import snowroller.myapplication.BR;

/**
 * Created by Martin on 2018-01-17.
 */

public class Activity2ViewModel extends BaseObservable {
    private String name;
    private boolean checked;
    private int progress;

    public final ObservableField<String> firstName =
            new ObservableField<>();

    public final ObservableField<String> lastName =
            new ObservableField<>();

    @Bindable
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        if (progress > 50)
            setChecked(false);
        else
            setChecked(true);
        notifyPropertyChanged(BR.progress);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        firstName.set(name);
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        notifyPropertyChanged(BR.checked);
    }

    @BindingConversion
    public static int ConvertBooleanToVisibility(boolean visible) {
        if (visible)
            return View.VISIBLE;
        else
            return View.INVISIBLE;
    }
}
