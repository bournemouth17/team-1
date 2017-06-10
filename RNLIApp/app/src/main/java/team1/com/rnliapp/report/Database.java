package team1.com.rnliapp.report;

import java.sql.*;
/**
 * Created by harvey on 10/06/2017.
 */

public class Database {
    private static Connection connection = null;
    private static Statement statement = null;

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

    public void createIncident(String description){
        executeUpdate("INSERT INTO incident(`incidentId`,`description`) VALUES("+ getIncidentId() +", '" + description +"')");
    }

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

    public static void main(String args[]){
        String dbURL = "jdbc:mysql://52.17.3.37:3306/rnli";
        String dbUser = "harvey";
        String dbPass = "password";
        Database db = new Database(dbURL, dbUser, dbPass);
        db.createIncident("test");
    }
}
