package team1.com.rnliapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InjuryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury);
        this.setListeners();
    }

    protected void setListeners(){
        Button card12 = (Button)(findViewById(R.id.card12));
        Button card13 = (Button)(findViewById(R.id.card13));
        Button card14 = (Button)(findViewById(R.id.card14));
        Button card15 = (Button)(findViewById(R.id.card15));
        Button card16 = (Button)(findViewById(R.id.card16));


        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 12
            }
        });

        card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 13

            }
        });

        card14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 14
            }
        });

        card15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 15
            }
        });

        card16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 16
            }
        });
    }

}
