package team1.com.rnliapp.report;

import java.util.Stack;

/**
 * Created by harvey on 10/06/2017.
 */

public class Patient {
    private String name, address, telephoneNumber, medicalHistory, lastMeal;

    public Patient(String name, String address, String telephoneNumber, String medicalHistory, String lastMeal){
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.medicalHistory = medicalHistory;
        this.lastMeal = lastMeal;
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getTelephoneNumber(){
        return telephoneNumber;
    }
    public String getMedicalHistory(){
        return medicalHistory;
    }
    public String getLastMeal(){
        return lastMeal;
    }
}
