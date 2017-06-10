package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContentsActivity extends AppCompatActivity {
    Button suggestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
        this.setListeners();

    }

    //sets the card to be opened on click of the suggested button
    public void setSuggestion(final int cardNum){
        suggestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContentsActivity.this, InformationCardDisplay.class);
                intent.putExtra("CARD_NUMBER",cardNum);
                startActivity(intent);
            }
        });

        switch (cardNum) {
            case 1:
                suggestionButton.setText("SUGGESTION: UNCONCIOUS BREATHING PATIENT CARE");
                break;
            case 2:
                suggestionButton.setText("SUGGESTION: RESUSCITATIONAND VENTILATORY SUPPORT");
                break;
            case 3:
                suggestionButton.setText("SUGGESTION: CONTROL OF MAJOR BLEEDING");
                break;
            case 4:
                suggestionButton.setText("SUGGESTION: UNDIAGNOSED ILLNESS");
                break;
            case 5:
                suggestionButton.setText("SUGGESTION: CARDIAC CHEST PAIN (NOT TRAUMATIC)");
                break;
            case 6:
                suggestionButton.setText("SUGGESTION: ASTHMA");
                break;
            case 7:
                suggestionButton.setText("SUGGESTION: SEVERE ALLERGIC REATION");
                break;
            case 8:
                suggestionButton.setText("SUGGESTION: LOW BLOOD SUGAR (HYPO)");
                break;
            case 9:
                suggestionButton.setText("SUGGESTION: DIVING RELATED");
                break;
            case 10:
                suggestionButton.setText("SUGGESTION: SEA SICKNESS");
                break;
            case 11:
                suggestionButton.setText("SUGGESTION: EPILEPSY / FITTING");
                break;
            case 12:
                suggestionButton.setText("SUGGESTION: BURN TREATMENT");
                break;
            case 13:
                suggestionButton.setText("SUGGESTION: FRACTURE TREATMENT");
                break;
            case 14:
                suggestionButton.setText("SUGGESTION: CHEST INJURY TREATMENT");
                break;
            case 15:
                suggestionButton.setText("SUGGESTION: SPINAL INJURY TREATMENT");
                break;
            case 16:
                suggestionButton.setText("SUGGESTION: HEAD INJURY TREATMENT");
                break;
            case 17:
                suggestionButton.setText("SUGGESTION: DROWNING TREATMENT");
                break;
            case 18:
                suggestionButton.setText("SUGGESTION: COLD / HYPOTHERMIA TREATMENT");
                break;
            case 19:
                suggestionButton.setText("SUGGESTION: HEAT EXHAUSTION / HEAT STROKE");
                break;
            case 20:
                break;
            case 21:
                break;
        }
    }




    protected void setListeners(){
        suggestionButton = (Button)(findViewById(R.id.suggestionButton));
        Button darkBlueButton = (Button)(findViewById(R.id.darkBlueButton));
        Button orangeButton = (Button)(findViewById(R.id.orangeButton));
        Button greenButton = (Button)(findViewById(R.id.greenButton));
        Button lightBlueButton = (Button)(findViewById(R.id.lightBlueButton));
        Button pinkButton = (Button)(findViewById(R.id.pinkButton));

        suggestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //goes to suggested card
            }
        });

        darkBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to care / control card options
                Intent intent = new Intent(ContentsActivity.this, CareControlCards.class);
                startActivity(intent);
            }
        });

        orangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to illness card options
                Intent intent = new Intent(ContentsActivity.this, IllnessCards.class);
                startActivity(intent);
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to injury card options
                Intent intent = new Intent(ContentsActivity.this, InjuryActivity.class);
                startActivity(intent);
            }
        });

        lightBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to immersion / heat card options
                Intent intent = new Intent(ContentsActivity.this, ImmersionHeatCards.class);
                startActivity(intent);
            }
        });

        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContentsActivity.this, PatientInfo.class);
                startActivity(intent);
            }
        });
    }


}
