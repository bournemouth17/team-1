package team1.com.rnliapp.report;

import java.util.Date;

/**
 * Created by harvey on 10/06/2017.
 */

public class MedicineAdministered {
    private String name, dose;
    private Date datetime;

    public MedicineAdministered(String name, String dose){
        this.name = name;
        this.datetime = new Date();
        this.dose = dose;
    }

    public String getName(){
        return name;
    }
    public Date getDatetime(){
        return datetime;
    }
    public String getDose(){
        return dose;
    }
}
