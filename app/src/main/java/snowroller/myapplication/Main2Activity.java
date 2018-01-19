package snowroller.myapplication;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import snowroller.myapplication.databinding.ActivityMain2Binding;
import snowroller.myapplication.handlers.Activity2Handler;
import snowroller.myapplication.viewmodels.Activity2ViewModel;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);

        //Layoutfilens namn utan _ + Binding
        ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2 );

        Resources res = getResources();

        Activity2ViewModel viewModel = new Activity2ViewModel(res.getStringArray(R.array.days));
        viewModel.setName("Martin");
        viewModel.setChecked(false);
        binding.setViewModel(viewModel);
        Activity2Handler handler = new Activity2Handler(this);
        binding.setHandler(handler);
    }
}
