package team1.com.rnliapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class InformationCardDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_card_display);
        int cardNumber = getIntent().getIntExtra("CARD_NUMBER", 0);
        TextView text = (TextView) findViewById(R.id.cardNumberView);
        text.setText("Card Number: " + cardNumber);
    }

}
