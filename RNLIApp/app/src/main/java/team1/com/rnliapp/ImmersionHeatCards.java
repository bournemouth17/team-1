package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImmersionHeatCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersion_heat_cards);
        this.setListeners();
    }

    protected void setListeners(){
        Button card17 = (Button)(findViewById(R.id.card17));
        Button card18 = (Button)(findViewById(R.id.card18));
        Button card19 = (Button)(findViewById(R.id.card19));

        card17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 17
                Intent intent = new Intent(ImmersionHeatCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",17);
                startActivity(intent);
            }
        });

        card18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 18
                Intent intent = new Intent(ImmersionHeatCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",18);
                startActivity(intent);

            }
        });

        card19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 19
                Intent intent = new Intent(ImmersionHeatCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",19);
                startActivity(intent);
            }
        });
    }
}
