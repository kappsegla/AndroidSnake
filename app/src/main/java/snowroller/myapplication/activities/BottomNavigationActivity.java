package snowroller.myapplication.activities;

import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Stack;

import snowroller.myapplication.R;
import snowroller.myapplication.databinding.ActivityBottomNavigationBinding;
import snowroller.myapplication.fragments.TodayFragment;
import snowroller.myapplication.fragments.TotalFragment;
import snowroller.myapplication.fragments.WeekFragment;
import snowroller.myapplication.viewmodels.BottomNavigationViewModel;

public class BottomNavigationActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private Stack<Integer> fragmentBackStack = new Stack<>();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (fragmentBackStack.peek() == item.getItemId())
                return true;
            switch (item.getItemId()) {
                case R.id.navigation_today:
                    Fragment today = new TodayFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout, today, "TODAY").commit();
                    fragmentBackStack.push(R.id.navigation_today);
                    return true;
                case R.id.navigation_week:
                    Fragment week = new WeekFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout, week, "WEEK").commit();
                    fragmentBackStack.push(R.id.navigation_week);
                    return true;
                case R.id.navigation_season:
                    Fragment total = new TotalFragment();
                    getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left)
                            .replace(R.id.frameLayout, total, "TOTAL").commit();
                    fragmentBackStack.push(R.id.navigation_season);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bottom_navigation);
        ActivityBottomNavigationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_navigation);
        binding.setViewModel(new BottomNavigationViewModel());

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment todayFragment = new TodayFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.frameLayout, todayFragment, "TODAY").commit();
        fragmentBackStack.push(R.id.navigation_today);

        setSupportActionBar(findViewById(R.id.toolbar2));
    }

    @Override
    public void onBackPressed() {
        fragmentBackStack.pop();
        if (!fragmentBackStack.empty()) {
            navigation.setSelectedItemId(fragmentBackStack.pop());
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_playsnake:
                //Do something here
                Intent intent = new Intent(this, SnakeActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void notifyButton(View view) {

        //Property Animation, will actually change the property value of the target object
        /*AnimatorSet animSet =
                (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), R.animator.icon_expand);
        animSet.setTarget(view);
        animSet.start();
        */
        //View Animation, only animates the graphical view of the object
        //Actual properties are not affected
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.icon_animation);
        view.startAnimation(animation);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, TodayFragment.id)
                        .setSmallIcon(R.drawable.ic_small_notification_pet_icon)
                        .setContentTitle("This is title")
                        .setContentText("This is some text");

        NotificationManagerCompat.from(this).notify(1, builder.build() );
    }
}
