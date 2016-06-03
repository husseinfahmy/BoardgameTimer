package tech.husseinfahmy.boardgametimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Bundle data = getIntent().getExtras();

        if(data==null){
            return;
        } else{
           double bankTime = data.getDouble("bankTime");
           double roundTime = data.getDouble("roundTime");
           int numPlayers = data.getInt("numberOfPlayers");
           int bankSecs = data.getInt("bankSeconds");
           int roundSecs = data.getInt("roundSeconds");
           int bankMins = data.getInt("bankMinutes");
           int roundMins = data.getInt("roundMinutes");
        }
    }
}
