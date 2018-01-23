package snowroller.myapplication.activities;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.Stack;

import snowroller.myapplication.R;
import snowroller.myapplication.databinding.ActivityBottomNavigationBinding;
import snowroller.myapplication.fragments.TodayFragment;
import snowroller.myapplication.fragments.WeekFragment;
import snowroller.myapplication.viewmodels.BottomNavigationViewModel;

public class BottomNavigationActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private Stack<Integer> fragmentBackStack = new Stack<>();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if( fragmentBackStack.peek() == item.getItemId())
                return true;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Fragment today = new TodayFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout, today,"TODAY").commit();
                    fragmentBackStack.push(R.id.navigation_home);
                    return true;
                case R.id.navigation_dashboard:
                    Fragment week = new WeekFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout, week, "WEEK").commit();
                    fragmentBackStack.push(R.id.navigation_dashboard);
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bottom_navigation);
        ActivityBottomNavigationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_navigation );
        binding.setViewModel(new BottomNavigationViewModel());

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment todayFragment = new TodayFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.frameLayout, todayFragment, "TODAY").commit();
        fragmentBackStack.push(R.id.navigation_home);
    }

    @Override
    public void onBackPressed() {
        fragmentBackStack.pop();
        if( !fragmentBackStack.empty() )
        {
            navigation.setSelectedItemId( fragmentBackStack.pop() );
        }
        else
            super.onBackPressed();
    }
}
