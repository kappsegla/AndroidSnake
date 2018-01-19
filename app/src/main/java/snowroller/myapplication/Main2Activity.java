package snowroller.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import snowroller.myapplication.databinding.ActivityMain2Binding;
import snowroller.myapplication.events.ShowToastEvent;
import snowroller.myapplication.events.StartActivityEvent;
import snowroller.myapplication.viewmodels.Activity2ViewModel;

public class Main2Activity extends AppCompatActivity {

    private Activity2ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);

        //Layoutfilens namn utan _ + Binding
        ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2 );

        Resources res = getResources();

        viewModel = new Activity2ViewModel(EventBus.getDefault(), res.getStringArray(R.array.days));
        viewModel.setName("Martin");
        viewModel.setChecked(false);
        binding.setViewModel(viewModel);
        //Activity2Handler handler = new Activity2Handler(this);
        //binding.setHandler(handler);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        viewModel.setClickable(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void startActivityRequest(StartActivityEvent event) {
        Intent intent = new Intent(this, event.getC());
        startActivity(intent);
    }

    @Subscribe
    public void showToastRequest(ShowToastEvent event) {
        Toast.makeText(this, event.getText(),Toast.LENGTH_LONG).show();
    }
}
