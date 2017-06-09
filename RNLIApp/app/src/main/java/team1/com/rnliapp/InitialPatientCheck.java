package team1.com.rnliapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class InitialPatientCheck extends AppCompatActivity {
    EditText questionBox;
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
                          "Check the patient's breathing rate for 10 seconds and x 6. Consider depth and quality.",
                          "Check the patient's central capillary refill - heart/fluid loss?",
                          "Is the patient slumped/tripod/lying down?",
                          "Is the patient conscious?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_patient_check);
        questionBox = (EditText) (findViewById(R.id.editText));
        questionBox.setText(questions[0]);


        ImageButton yesButton = (ImageButton)(findViewById(R.id.imageButton3));
        ImageButton noButton = (ImageButton)(findViewById(R.id.imageButton2));

        yesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonClick(1);
            }
        });
        noButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonClick(0);
            }
        });
    }

    private void buttonClick(int result){
        issue.addInput(count, result);
        if(count == 12) count = 0;
        else count++;

        questionBox.setText(questions[count]);
    }
}
