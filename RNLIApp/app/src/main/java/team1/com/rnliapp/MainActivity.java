package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMainNavigationActivity();
            }
        });

        Button nickButton = (Button)(findViewById(R.id.NickButton));
        nickButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, InitialPatientCheck.class);
                startActivity(intent);
            }
        });
    }

    private void launchMainNavigationActivity() {
        Intent intent = new Intent(this, ContentsActivity.class);
        startActivity(intent);
    }

}
