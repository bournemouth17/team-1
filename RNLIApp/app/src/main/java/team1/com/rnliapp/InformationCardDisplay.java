package team1.com.rnliapp;

import android.content.res.AssetManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import team1.com.rnliapp.informationCards.InformationCard;
import team1.com.rnliapp.informationCards.InformationCardParser;

public class InformationCardDisplay extends AppCompatActivity {

    private ConstraintLayout branchStepsLayout;
    private InformationCard currentCard;
    private int currentBranchStepCounter = 0, currentBranchIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_card_display);
        TextView cardNameDisplay = (TextView) findViewById(R.id.cardNameDisplay);
        branchStepsLayout = (ConstraintLayout) findViewById(R.id.branchStepsLayout);
        int cardNumber = getIntent().getIntExtra("CARD_NUMBER", 0);
        try {
            String cardName = "Card_" + cardNumber;
            currentCard = InformationCardParser.getInstance().parseCardFromFile(cardName, getBaseContext());
            cardNameDisplay.setText(currentCard.getInformationCardName());
        } catch (ParseException | IOException e) {
            //TODO Make this send a toast notification and then loop back to the start.
            e.printStackTrace();
        }
    }

}
