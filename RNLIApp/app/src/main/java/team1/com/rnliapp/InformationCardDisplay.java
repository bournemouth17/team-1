package team1.com.rnliapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.simple.parser.ParseException;

import java.io.IOException;

import team1.com.rnliapp.informationCards.InformationCard;
import team1.com.rnliapp.informationCards.InformationCardParser;

public class InformationCardDisplay extends AppCompatActivity {

    private LinearLayout branchButtonLayout;
    private InformationCard currentCard;
    private int currentBranchStepCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_card_display);
        TextView cardNameDisplay = (TextView) findViewById(R.id.cardNameDisplay), markersDisplay = (TextView) findViewById(R.id.attributesDisplay);
        branchButtonLayout = (LinearLayout) findViewById(R.id.branchButtonLayout);
        int cardNumber = getIntent().getIntExtra("CARD_NUMBER", 0);
        try {
            String cardName = "Card_" + cardNumber;
            currentCard = InformationCardParser.getInstance().parseCardFromFile(cardName, getBaseContext());
            cardNameDisplay.setText(currentCard.getInformationCardName());
            String[] markers = currentCard.getMarkers();
            String markersString = "";
            for(int i = 0; i < markers.length; i++) {
                markersString += markers[i];
                if(i < markers.length - 1) markersString += ",";
                else markersString += ".";
            }
            markersDisplay.setText(markersString);
            branchButtonGeneration(currentCard.getBranchCount());
        } catch (ParseException | IOException e) {
            //TODO Make this send a toast notification and then loop back to the start.
            e.printStackTrace();
        }
    }

    private void branchButtonGeneration(int numberOfBranches) {
        if(numberOfBranches <= 0) return;
        else if(numberOfBranches == 1)  {
            displayBranchSteps(0);
        } else {
            addButton(currentCard.getBranchName(0), 0);
            addButton(currentCard.getBranchName(1), 1);
        }
    }

    private void displayBranchSteps(int branchIndex) {
        branchButtonLayout.removeAllViews();
        final String[] branchSteps = currentCard.getBranchSteps(branchIndex);
        final Button currentButton = new Button(this);
        currentButton.setText(branchSteps[0]);
        currentButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        currentButton.setTextSize(24);
        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //TODO Add in the markers and such
                if(currentBranchStepCounter < branchSteps.length - 1) {
                    currentBranchStepCounter++;
                    currentButton.setText(branchSteps[currentBranchStepCounter]);
                } else {
                    currentBranchStepCounter = 0;
                    Intent intent = new Intent(InformationCardDisplay.this, ContentsActivity.class);
                    startActivity(intent);
                }
            }
        });
        branchButtonLayout.addView(currentButton);
    }

    private void addButton(String buttonText, final int branchIndex) {
        Button newButton = new Button(this);
        newButton.setText(buttonText);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayBranchSteps(branchIndex);
            }
        });
        branchButtonLayout.addView(newButton);
    }

}
