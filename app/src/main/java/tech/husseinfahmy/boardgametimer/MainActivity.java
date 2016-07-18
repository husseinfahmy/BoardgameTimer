package tech.husseinfahmy.boardgametimer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //local vars for timer info, add getters and setters after
    private int numPlayers;
    private int bankMins;
    private int bankSecs;
    private int roundMins;
    private int roundSecs;



    private double bankTime;
    private double roundTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.startTimerButton);


        submitButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            EditText numPlayersField = (EditText) findViewById(R.id.numPlayersField);
                            numPlayers = Integer.parseInt(numPlayersField.getText().toString());

                            EditText bankMinsField = (EditText) findViewById(R.id.bankMinsField);
                            bankMins = Integer.parseInt(bankMinsField.getText().toString());

                            EditText bankSecsField = (EditText) findViewById(R.id.bankSecsField);
                            bankSecs = Integer.parseInt(bankSecsField.getText().toString());

                            EditText roundMinsField = (EditText) findViewById(R.id.roundMinsField);
                            roundMins = Integer.parseInt(roundMinsField.getText().toString());

                            EditText roundSecsField = (EditText) findViewById(R.id.roundSecsField);
                            roundSecs = Integer.parseInt(roundSecsField.getText().toString());


                            Intent newIntent =  new Intent(v.getContext(), TimerActivity.class);



                            if ((numPlayers <= 0) || (bankMins < 0) || (bankSecs < 0) ||(roundMins<0)||(roundMins<0)||(roundSecs>59)||(bankSecs>59)) {
                                Toast errorMessage = Toast.makeText(getApplicationContext(),"Invalid Field(s)",Toast.LENGTH_SHORT);
                                errorMessage.show();
                            }
                            else{
                                roundTime = (roundMins*60000)+(roundSecs*1000);
                                bankTime = (bankMins*60000)+(bankSecs*1000);
                            }

                            Bundle data = new Bundle();
                            newIntent.putExtra("numberOfPlayers", numPlayers);
                            newIntent.putExtra("bankMinutes", bankMins);
                            newIntent.putExtra("bankSeconds", bankSecs);
                            newIntent.putExtra("roundMinutes", roundMins);
                            newIntent.putExtra("roundSeconds", roundSecs);
                            newIntent.putExtra("bankTime", bankTime);
                            newIntent.putExtra("roundTime", roundTime);

                            startActivity(newIntent);
                        }catch(NumberFormatException nfe){
                            Toast errorMessage = Toast.makeText(getApplicationContext(),"Invalid Field(s)",Toast.LENGTH_SHORT);
                            errorMessage.show();
                        }
                    }
                }

        );
    }


    public double getRoundTime() {
        return roundTime;
    }

    public double getBankTime() {
        return bankTime;
    }

}
