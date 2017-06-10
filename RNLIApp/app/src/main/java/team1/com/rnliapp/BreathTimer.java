package team1.com.rnliapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BreathTimer extends AppCompatActivity {
    Button startButton;
    EditText timer;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath_timer);

        startButton = (Button)(findViewById(R.id.timerButton));
        timer = (EditText)(findViewById(R.id.timerDigit));

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new CountDownTimer(10000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        timer.setText("Timer done. Enter breath count");

                    }
                }.start();
            }
        });

    }
}
