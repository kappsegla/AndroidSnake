package snowroller.myapplication.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import snowroller.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment {


    public TodayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_today, container, false);
    }

    public void setCurrentDate(int day)
    {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_android:
                //Do something here
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
