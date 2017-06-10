package team1.com.rnliapp;

import android.content.Intent;
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

    /**
     * Sets the listeners for the buttons in the injury activity
     */
    protected void setListeners(){
        Button card12 = (Button)(findViewById(R.id.card12));
        Button card13 = (Button)(findViewById(R.id.card13));
        Button card14 = (Button)(findViewById(R.id.card14));
        Button card15 = (Button)(findViewById(R.id.card15));
        Button card16 = (Button)(findViewById(R.id.card16));


        //card 12 opens on click
        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 12
                Intent intent = new Intent(InjuryActivity.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",12);
                startActivity(intent);
            }
        });

        //card 13 opens on click
        card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 13
                Intent intent = new Intent(InjuryActivity.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",13);
                startActivity(intent);

            }
        });

        //card 14 opens on click
        card14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 14
                Intent intent = new Intent(InjuryActivity.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",14);
                startActivity(intent);
            }
        });

        //card 15 opens on click
        card15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 15
                Intent intent = new Intent(InjuryActivity.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",15);
                startActivity(intent);
            }
        });

        //card 16 opens on click
        card16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 16
                Intent intent = new Intent(InjuryActivity.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",16);
                startActivity(intent);
            }
        });
    }

}
