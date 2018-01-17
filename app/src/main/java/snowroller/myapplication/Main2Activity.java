package snowroller.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import snowroller.myapplication.databinding.ActivityMain2Binding;
import snowroller.myapplication.viewmodels.Activity2ViewModel;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);

        //Layoutfilens namn utan _ + Binding
        ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2 );

        Activity2ViewModel viewModel = new Activity2ViewModel();
        viewModel.setName("Martin");
        viewModel.setChecked(false);
        binding.setViewModel(viewModel);

/*        text = findViewById(R.id.editText);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ((TextView)findViewById(R.id.textView)).setText(editable.toString());
            }
        });

        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener((view)->{

            switch (view.getId()) {
                case R.id.checkBox:
                    ((Button) findViewById(R.id.button)).setEnabled(checkBox.isChecked());
                    break;
            }
        });*/

    }
}
