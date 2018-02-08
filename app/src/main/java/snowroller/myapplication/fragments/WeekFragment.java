package snowroller.myapplication.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import snowroller.myapplication.R;
import snowroller.myapplication.viewmodels.ViewModelProvider;
import snowroller.myapplication.viewmodels.WeekViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeekFragment extends Fragment {


    public WeekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        WeekViewModel weekViewModel = ViewModelProvider.getInstance().getBottomNavigationViewModel().weekViewModel;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_week, container, false);
    }

}
