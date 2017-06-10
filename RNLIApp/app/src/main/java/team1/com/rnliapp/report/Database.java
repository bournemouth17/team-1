package team1.com.rnliapp.report;

import java.sql.*;
/**
 * Created by harvey on 10/06/2017.
 */

public class Database {
    private static Connection connection = null;
    private static Statement statement = null;

    //Setting up the SQL server database connection and error checking the connection as it goes.
    public Database(String url, String user, String pass){
        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC DRIVER ERROR");
            e.printStackTrace();
            return;
        }
        System.out.println("DATABASE REGISTERED");
        try {
            connection = DriverManager
                    .getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println("CONNECTION FAILED");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("CONNECTED TO DATABASE");
        } else {
            System.out.println("CONNECTION FAILED");
        }
    }

    //Sends a given sql query to the database and returns the result to the caller.
    public ResultSet executeQuery(String sql){
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("QUERY EXECUTED");
            return rs;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Updates the SQL database
    public void executeUpdate(String sql){
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("QUERY EXECUTED");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //Takes information on the patient, and their medical before formatting it and sending it as a SQL query to the database to be stored.
    public int createIncident(String description, Patient patient, Allergy allergy, MedicineAdministered dosage){
        int incidentId = getIncidentId();
        executeUpdate("INSERT INTO patient(`incidentId`,`name`,`address`,`telephoneNumber`, `medicalHistory`, `lastMeal`) VALUES("+ incidentId +", '" + patient.getName() +"', '" + patient.getAddress() +"','" + patient.getTelephoneNumber() +"', '" + patient.getLastMeal() +"', '" + patient.getMedicalHistory() +"')");
        executeUpdate("INSERT INTO allergy(`incidentId`,`title`,`medication`) VALUES("+ incidentId +", '" + allergy.getTitle() +"', '" + allergy.getMedication() +"')");
        executeUpdate("INSERT INTO medicineAdministered(`incidentId`,`name`,`time`,`dose`) VALUES("+ incidentId +", '" + dosage.getName() +"', '" + dosage.getDatetime() +"', '" + dosage.getDose() +"')");
        executeUpdate("INSERT INTO incident(`incidentId`,`description`) VALUES("+ incidentId +", '" + description +"')");
        return incidentId;
    }

    //Gets the ID that links the patient to the medical records and to the incident that happened.
    private int getIncidentId(){
        int incidentId = 0;
        try{
            ResultSet rs = executeQuery("SELECT incidentId FROM incident ORDER BY incidentId DESC");
            rs.next();
            incidentId = rs.getInt("incidentId");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return ++incidentId;
    }

//    public static void main(String args[]){
//        String dbURL = "jdbc:mysql://52.17.3.37:3306/rnli";
//        String dbUser = "harvey";
//        String dbPass = "password";
//        Database db = new Database(dbURL, dbUser, dbPass);
//        Patient pat = new Patient("Leon Watts", ", Bournemouth", "01202222222", "None", "Ice Cream");
//        Allergy allergy = new Allergy("Hayfever", "Nasal Spray");
//        MedicineAdministered dosage = new MedicineAdministered("Paracetemol", "400mg");
//        db.createIncident("Fell off of pier", pat, allergy, dosage);
//    }
}
