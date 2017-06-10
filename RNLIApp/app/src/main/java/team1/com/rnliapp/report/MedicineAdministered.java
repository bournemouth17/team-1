package team1.com.rnliapp.report;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by harvey on 10/06/2017.
 */

public class MedicineAdministered {
    private String name, dose, datetime;

    public MedicineAdministered(String name, String dose){
        this.name = name;
        this.datetime = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
        this.dose = dose;
    }

    public String getName(){
        return name;
    }
    public String getDatetime(){
        return datetime;
    }
    public String getDose(){
        return dose;
    }
}
