package team1.com.rnliapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class InitialPatientCheck extends AppCompatActivity {
    EditText questionBox;
    ImageButton yesButton;
    ImageButton noButton;

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


        yesButton = (ImageButton)(findViewById(R.id.imageButton3));
        noButton = (ImageButton)(findViewById(R.id.imageButton2));

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
        if(count == 8){
            breathTimer();
        }
    }

    private void breathTimer(){
        ViewGroup yesLayout = (ViewGroup) yesButton.getParent();
        ViewGroup noLayout = (ViewGroup) noButton.getParent();
        if(null!=yesLayout && null!=noLayout){
            yesLayout.removeView(yesButton);
            noLayout.removeView(noButton);
        }

    }
}
