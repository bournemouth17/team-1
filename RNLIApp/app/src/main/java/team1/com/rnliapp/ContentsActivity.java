package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
        this.setListeners();

    }

    //sets the card to be opened on click of the suggested button
    public void setSuggestion(int cardNum){
        switch (cardNum){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;


        }
    }




    protected void setListeners(){
        Button suggestionButton = (Button)(findViewById(R.id.suggestionButton));
        Button darkBlueButton = (Button)(findViewById(R.id.darkBlueButton));
        Button orangeButton = (Button)(findViewById(R.id.orangeButton));
        Button greenButton = (Button)(findViewById(R.id.greenButton));
        Button lightBlueButton = (Button)(findViewById(R.id.lightBlueButton));

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
    }
}
