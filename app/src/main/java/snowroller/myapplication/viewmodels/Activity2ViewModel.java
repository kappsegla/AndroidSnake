package snowroller.myapplication.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingConversion;
import android.databinding.ObservableArrayList;
import android.view.View;

import snowroller.myapplication.BR;

/**
 * Created by Martin on 2018-01-17.
 */

public class Activity2ViewModel extends BaseObservable {
    private String name;
    private boolean checked;
    private int progress;

    private String firstName;
    private String lastName;
    private int selectedDayPosition;

    public final ObservableArrayList<Object> days = new ObservableArrayList<>();

    public Activity2ViewModel() {
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
    }
    @Bindable
    public int getSelectedDayPosition()
    {
        return selectedDayPosition;
    }

    public void setSelectedDayPosition(int dayPosition)
    {
        selectedDayPosition = dayPosition;
        notifyPropertyChanged(BR.selectedDayPosition);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
        notifyPropertyChanged(BR.firstNameError);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
        notifyPropertyChanged(BR.lastNameError);
    }

    @Bindable
    public String getFirstNameError()
    {
        if( firstName != null && firstName.length() < 2)
            return("Too short");
        else
            return null;
    }

    @Bindable
    public String getLastNameError()
    {
        if( lastName != null && lastName.length() < 3)
            return("Too short");
        else
            return null;
    }

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

    public boolean longButtonClicked(View v)
    {
        setFirstName("Kalle");
        return true;
    }

    public void buttonClicked(View v)
    {
        setChecked(!isChecked());
    }
}
