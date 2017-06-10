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
        //Gets the text views for displaying information and the layout to add the buttons too.
        TextView cardNameDisplay = (TextView) findViewById(R.id.cardNameDisplay), markersDisplay = (TextView) findViewById(R.id.attributesDisplay);
        branchButtonLayout = (LinearLayout) findViewById(R.id.branchButtonLayout);
        //Gets the card number requested by the previous activity.
        int cardNumber = getIntent().getIntExtra("CARD_NUMBER", 0);
        try {
            //Formats filename and uses parser to get the requested card from its file.
            String cardName = "Card_" + cardNumber;
            currentCard = InformationCardParser.getInstance().parseCardFromFile(cardName, getBaseContext());
            //Sets the card name display and the markers display on the GUI interface.
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

    //Currently very inflexibly generates some buttons to fit the number of branches.
    private void branchButtonGeneration(int numberOfBranches) {
        if(numberOfBranches <= 0) return; //Checking if number of branches is valid
        else if(numberOfBranches == 1)  {
            displayBranchSteps(0);
        } else {
            addButton(currentCard.getBranchName(0), 0);
            addButton(currentCard.getBranchName(1), 1);
        }
    }

    //Runs through the steps in a given branch and step by step displays the step's information on a button
    //Before looping back to the contents screen.
    private void displayBranchSteps(int branchIndex) {
        branchButtonLayout.removeAllViews();
        //Gets the branch's steps and sets up the button to display them.
        final String[] branchSteps = currentCard.getBranchSteps(branchIndex);
        final Button currentButton = new Button(this);
        currentButton.setText(branchSteps[0]);
        currentButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        currentButton.setTextSize(24);
        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Checks for valid counter value before changing text to next step and incrementing counter
                //Otherwise counter is reset and the Contents activity page is loaded.
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

    //Adds a button to the button layout and sets the onClick to run the display method for the given branch index.
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
