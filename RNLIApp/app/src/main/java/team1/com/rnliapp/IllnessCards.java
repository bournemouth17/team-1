package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IllnessCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness_cards);
        this.setListeners();
    }

    /**
     * set the on click listeners for each of the buttons
     */
    protected void setListeners(){
        Button card4 = (Button)(findViewById(R.id.card4));
        Button card5 = (Button)(findViewById(R.id.card5));
        Button card6 = (Button)(findViewById(R.id.card6));
        Button card7 = (Button)(findViewById(R.id.card7));
        Button card8 = (Button)(findViewById(R.id.card8));
        Button card9 = (Button)(findViewById(R.id.card9));
        Button card10 = (Button)(findViewById(R.id.card10));
        Button card11 = (Button)(findViewById(R.id.card11));


        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 4
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",4);
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 5
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",5);
                startActivity(intent);

            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 6
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",6);
                startActivity(intent);
            }
        });

        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 7
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",7);
                startActivity(intent);
            }
        });

        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 8
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",8);
                startActivity(intent);
            }
        });

        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 9
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",9);
                startActivity(intent);
            }
        });

        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 10
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",10);
                startActivity(intent);
            }
        });

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open card 11
                Intent intent = new Intent(IllnessCards.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",11);
                startActivity(intent);
            }
        });
    }

}
