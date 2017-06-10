package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReassessNotifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reassess_notif);
        setTitle("Reassess Patient");

        Button cancelButton = (Button)(findViewById(R.id.cancelButton));
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button okayButton = (Button)findViewById(R.id.okButton);
        okayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent in = new Intent(ReassessNotifActivity.this, InitialPatientCheck.class);
                startActivity(in);
            }
        });
    }


}
