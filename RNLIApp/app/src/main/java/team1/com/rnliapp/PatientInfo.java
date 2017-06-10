package team1.com.rnliapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import team1.com.rnliapp.report.*;

public class PatientInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        setTitle("Patient Information");

        EditText name = (EditText) (findViewById(R.id.nameBox));
        EditText address = (EditText) (findViewById(R.id.addressBox));
        EditText phoneNumber = (EditText) (findViewById(R.id.telephoneBox));
        EditText medicalHistory = (EditText) (findViewById(R.id.historyBox));
        EditText lastMeal = (EditText) (findViewById(R.id.mealBox));

        EditText allergy = (EditText) (findViewById(R.id.allergyBox));
        EditText prescribed = (EditText) (findViewById(R.id.prescribedBox));

        EditText description = (EditText) (findViewById(R.id.incidentBox));

        EditText medicine = (EditText) (findViewById(R.id.medicineBox));
        EditText dose = (EditText) (findViewById(R.id.dosageBox));

        //creating database connection
       /* String dbURL = "jdbc:mysql://52.17.3.37:3306/rnli";
        String dbUser = "harvey";
        String dbPass = "password";
        Database db = new Database(dbURL, dbUser, dbPass);

        //forming objects
        Patient patientObj = new Patient(name.toString(), address.toString(), phoneNumber.toString(), medicalHistory.toString(), lastMeal.toString());
        Allergy allergyObj = new Allergy(allergy.toString(),  prescribed.toString());
        MedicineAdministered dosageObj = new MedicineAdministered(medicine.toString(), dose.toString());

        //submitting data to database
        int incidentId = db.createIncident(description.toString(), patientObj, allergyObj, dosageObj);

        Context context = getApplicationContext();
        CharSequence text = Integer.toString(incidentId);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/
    }


}
