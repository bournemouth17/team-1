package team1.com.rnliapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InitialPatientCheck extends AppCompatActivity {
    EditText inputText;
    Chronometer chronometer;
    TextView questionBox;
    ImageButton yesButton;
    ImageButton noButton;
    Button startButton;
    Button submitButton;
    Button startTimerButton;
    Button stopTimerButton;
    static int[] suggestion;

    int count = 0;
    PredictIssue issue = new PredictIssue();
    String[] questions = {"Is the patient injured?",
                          "Is the patient ill?",
                          "Is the patient immersed?",
                          "Is the patient alert?",
                          "Is the patient able to speak?",
                          "Is the patient in pain?",
                          "Is the patient responsive?",
                          "Does the patient have any life threatening bleeding?",
                          "Is the patient slumped/tripod/lying down?",
                          "Is the patient conscious?",
                          "Check the patient's breathing rate for 10 seconds. Consider depth and quality.",
                          "Check the patient's central capillary refill - heart/fluid loss?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_patient_check);

                questionBox = (TextView) (findViewById(R.id.textView));
        questionBox.setText(questions[0]);
        chronometer = (Chronometer) findViewById(R.id.chronometer);


        yesButton = (ImageButton)(findViewById(R.id.imageButton3));
        noButton = (ImageButton)(findViewById(R.id.imageButton2));
        startButton = (Button)(findViewById(R.id.startButton));
        submitButton = (Button)(findViewById((R.id.submitButton)));
        startTimerButton = (Button)(findViewById(R.id.startTimerButton));
        stopTimerButton = (Button)(findViewById(R.id.stopTimerButton));
        inputText = (EditText)(findViewById(R.id.editText));
        inputText.setVisibility(View.INVISIBLE);
        startButton.setVisibility(View.INVISIBLE);
        submitButton.setVisibility(View.INVISIBLE);
        startTimerButton.setVisibility(View.GONE);
        stopTimerButton.setVisibility(View.INVISIBLE);
        chronometer.setVisibility(View.INVISIBLE);

        yesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonClick(1);
                System.out.println("YES BUTTON");
            }
        });
        noButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonClick(0);
                System.out.println("NO BUTTON");
            }
        });
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new CountDownTimer(10000, 50) {

                    public void onTick(long millisUntilFinished) {
                        questionBox.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        questionBox.setText("Timer done. Enter breath count here");
                        startButton.setVisibility(View.INVISIBLE);
                        submitButton.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });

        questionBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                questionBox.setVisibility(View.INVISIBLE);
                inputText.setVisibility(View.VISIBLE);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonClick(Integer.parseInt(inputText.getText().toString())*6);
                submitButton.setVisibility(View.INVISIBLE);
                inputText.setVisibility(View.INVISIBLE);
                questionBox.setVisibility(View.VISIBLE);
            }
        });

        startTimerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                questionBox.setVisibility(View.INVISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.setVisibility(View.VISIBLE);
                chronometer.start();
                stopTimerButton.setVisibility(View.VISIBLE);
                startTimerButton.setVisibility(View.INVISIBLE);
            }
        });

        stopTimerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                chronometer.stop();
                long elapsedSec =(SystemClock.elapsedRealtime() - chronometer.getBase())/1000;
                int value = 0;
                if(elapsedSec>=3) value = 1;
                buttonClick(value);
                Intent intent = new Intent(InitialPatientCheck.this, ContentsActivity.class);
                startActivity(intent);
            }
        });


    }

    private void buttonClick(int result){
        System.out.println("COUNT: " + count);
        issue.addInput(count, result);
        if(count == 11){
            System.out.println("IF");
            suggestion = issue.compareArray();
            System.out.println("MIDDLE");
            if(suggestion.length == 0) {
                ContentsActivity.setCard(-1);
            }
            else {
                ContentsActivity.setCard(suggestion[0]);
            }
            System.out.println("END");
            count = 0;
        }
        else count++;

        questionBox.setText(questions[count]);
        if(count == 10){
            startButton.setVisibility(View.VISIBLE);
        }
        else if(count == 11){
            startTimerButton.setVisibility(View.VISIBLE);
        }
    }

    public static int getSuggestion(){
        return suggestion[0];
    }
}
