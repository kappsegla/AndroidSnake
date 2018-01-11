package snowroller.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class SnakeActivity extends AppCompatActivity {

    private MyView myView;
    private PhoneStateListener phoneStateListener;
    private static String SNAKE = "Snake";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        phoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    //Incoming call: Pause music
                    myView.setActive(false);
                } else if (state == TelephonyManager.CALL_STATE_IDLE) {
                    //Not in call: Play music
                    myView.setActive(true);
                } else if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
                    //A call is dialing, active or on hold
                    myView.setActive(false);
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };
        TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (mgr != null) {
            mgr.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String snake = sharedPref.getString(SNAKE,"");
        //Todo: Update MyViews snakelist with data from snake string. If snake is empty, randomize new snake.
        //Todo: Load apple positon and update MyViews with that.
    }

    @Override
    protected void onPause() {
        super.onPause();
        myView.setActive(false);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (mgr != null) {
            mgr.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
        }

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String snake = "";
        //Todo: Convert snake (MyView) to string. Override toString. (x,y,x2,y2....
        editor.putString(SNAKE, snake);
        //Todo: Store also the apple position
        editor.apply();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        myView.setActive(hasFocus);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Sluta nu?")
                .setCancelable(false)
                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Nej", null)
                .show();
    }
}

