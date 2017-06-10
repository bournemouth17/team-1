package team1.com.rnliapp.report;

/**
 * Created by harvey on 10/06/2017.
 */

public class Allergy {
    private String title, medication;

    public Allergy(String title, String medication){
        this.title = title;
        this.medication = medication;
    }

    public String getTitle(){
        return title;
    }
    public String getMedication(){
        return medication;
    }
}
