package tech.husseinfahmy.boardgametimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {

    private Handler handler;


    private double roundTime;
    private TextView timeLeftText;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Bundle data = getIntent().getExtras();

        if(data==null){
            Log.d("myApp", "null");
            return;

        }

        double bankTime = data.getDouble("bankTime");
        roundTime = data.getDouble("roundTime");
        int numPlayers = data.getInt("numberOfPlayers");
        int bankSecs = data.getInt("bankSeconds");
        int roundSecs = data.getInt("roundSeconds");
        int bankMins = data.getInt("bankMinutes");
        int roundMins = data.getInt("roundMinutes");



        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                a = Double.toString(roundTime);
                timeLeftText.setText(a);
                */
                roundTime -= 1000;
                Log.d("myApp", "1 second");
                if(roundTime>0) {
                    handler.postDelayed(this, 1000);
                }
            }
        };

        handler.postDelayed(runnable, 1000);
    }
}
