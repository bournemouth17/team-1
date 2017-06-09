package team1.com.rnliapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        Button redoAssessmentButton = (Button) findViewById(R.id.redoAssessmentButton);
        Button homeButton = (Button) findViewById(R.id.homeButton);
        Button patientInfoButton = (Button) findViewById(R.id.patientInfoButton);

    }

    private void launchRedoAssessmentActivity() {
        Intent intent = new Intent(this, MainNavigationActivity.class);
        startActivity(intent);
    }

    private void launchHomeActivity() {
        Intent intent = new Intent(this, MainNavigationActivity.class);
        startActivity(intent);
    }

    private void launchPatientInfoButtonActivity() {
        Intent intent = new Intent(this, MainNavigationActivity.class);
        startActivity(intent);
    }

}
