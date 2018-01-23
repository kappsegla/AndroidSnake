package snowroller.myapplication.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import snowroller.myapplication.activities.BottomNavigationActivity;

/**
 * Created by Martin on 2018-01-19.
 */

public class Activity2Handler {

    private Context context;

    public Activity2Handler(Context context)
    {
        this.context = context;
    }

    public void nextButton(View view)
    {
        Intent intent = new Intent(context, BottomNavigationActivity.class);
        context.startActivity(intent);
    }


}
