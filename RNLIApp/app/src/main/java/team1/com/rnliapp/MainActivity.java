package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nick = (Button)(findViewById(R.id.NickButton));
        nick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PatientInfo.class);
                startActivity(i);
            }
        });

        Button startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMainNavigationActivity();
                Timer t = new Timer();
                t.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        timerActivity();
                    }

                }, 36000, 36000);
            }
        });



    }

    public void timerActivity(){
        //start redo assesment activity
        //TO TEST, DELETE AFTER
        Intent in = new Intent(MainActivity.this, ReassessNotifActivity.class);
        startActivity(in);

    }

    private void launchMainNavigationActivity() {
        Intent intent = new Intent(MainActivity.this, InitialPatientCheck.class);
        startActivity(intent);
    }

}
