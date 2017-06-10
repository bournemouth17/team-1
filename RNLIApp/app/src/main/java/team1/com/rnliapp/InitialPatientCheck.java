package team1.com.rnliapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class InitialPatientCheck extends AppCompatActivity {
    EditText questionBox;
    ImageButton yesButton;
    ImageButton noButton;
    Button startButton;
    Button submitButton;

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

                questionBox = (EditText) (findViewById(R.id.editText));
        questionBox.setText(questions[0]);


        yesButton = (ImageButton)(findViewById(R.id.imageButton3));
        noButton = (ImageButton)(findViewById(R.id.imageButton2));
        startButton = (Button)(findViewById(R.id.startButton));
        submitButton = (Button)(findViewById((R.id.submitButton)));
        startButton.setVisibility(View.INVISIBLE);
        submitButton.setVisibility(View.INVISIBLE);

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
                questionBox.setText("");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonClick(Integer.parseInt(questionBox.getText().toString())*6);
                submitButton.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void buttonClick(int result){
        System.out.println("COUNT: " + count);
        issue.addInput(count, result);
        if(count == 11){
            int[] test = issue.compareArray();
            count = 0;
        }
        else count++;

        questionBox.setText(questions[count]);
        if(count == 10){
            startButton.setVisibility(View.VISIBLE);
        }
    }
}
