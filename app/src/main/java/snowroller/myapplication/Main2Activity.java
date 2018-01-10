package snowroller.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Get reference to intent and access string from other activity
        Intent intent = getIntent();
        String text = intent.getStringExtra("Text");

        //Set text for textView
        TextView textView = findViewById(R.id.textView);
        textView.setText(text);
    }
}
