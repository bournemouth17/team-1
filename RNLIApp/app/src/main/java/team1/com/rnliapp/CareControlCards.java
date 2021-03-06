package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CareControlCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_control_cards);
        this.setListeners();

    }

    protected void setListeners(){
        Button card1 = (Button)(findViewById(R.id.card1));
        Button card2 = (Button)(findViewById(R.id.card2));
        Button card3 = (Button)(findViewById(R.id.card3));

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 1
                Intent intent = new Intent(CareControlCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",1);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 2
                Intent intent = new Intent(CareControlCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",2);
                startActivity(intent);

            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 3
                Intent intent = new Intent(CareControlCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",3);
                startActivity(intent);
            }
        });
    }
}
