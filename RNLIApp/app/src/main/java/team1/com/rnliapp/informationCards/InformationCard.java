package team1.com.rnliapp.informationCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Alex on 09/06/2017.
 */

public class InformationCard {

    private String informationCardName = "New Information Card", importantInfo = null;
    private int informationCardNumber = -1;
    private List<String> markers = new ArrayList<>(), notes = new ArrayList<>();;
    private Hashtable<String, List<String>> branches = new Hashtable<>();

    public InformationCard(String cardName, int cardNumber) {
        informationCardName = cardName;
        informationCardNumber = cardNumber;
    }

    public InformationCard(String informationCardName, int cardNumber, String importantInfo, List<String> markers, List<String> notes, Hashtable<String, List<String>> branches) {
        this.informationCardName = informationCardName.length() > 1 ? informationCardName : "New Information Card";
        this.informationCardNumber = cardNumber > -1 ? cardNumber : -1;
        this.importantInfo = importantInfo.length() > 1 ? importantInfo : null;
        this.markers = markers.size() > 0 ? markers : new ArrayList<String>();
        this.notes = notes.size() > 0 ? markers : new ArrayList<String>();
        this.branches = branches.size() > 0 ? branches : new Hashtable<String, List<String>>();
    }

    //Checks for invalid length info before assigning to the variable.
    public void addImportantInfo(String importantInfo) {
        if(importantInfo.length() > 1) {
            this.importantInfo = importantInfo;
        }
    }

    //Checks for duplicate and invalid data length before adding to the list.
    public void addMarker(String marker) {
        if(!marker.contains(marker.toUpperCase()) && marker.length() > 0) {
            markers.add(marker.toUpperCase());
        }
    }

    //Checks for duplicates and for invalid data input before adding to the list.
    public void addNote(String note) {
        if(!notes.contains(note.toUpperCase()) && note.length() > 1) {
            notes.add(note.toUpperCase());
        }
    }

    //Checks for duplicate branch and invalid branch step length before adding entry.
    public void addBranch(String branchName, String[] branchSteps) {
        if(!branches.containsKey(branchName.toUpperCase()) && branchSteps.length != 0) {
            branches.put(branchName.toUpperCase(), new ArrayList<>(Arrays.asList(branchSteps)));
        }
    }

    public String getInformationCardName() {
        return informationCardName;
    }

    public int getInformationCardNumber() {
        return informationCardNumber;
    }

    public String getImportantInfo() {
        return importantInfo;
    }

    public String[] getMarkers() {
        if(markers.size() > 0) {
            return markers.toArray(new String[markers.size()]);
        }
        return null;
    }

    public String[] getNotes() {
        if(notes.size() > 0) {
            return notes.toArray(new String[notes.size()]);
        }
        return null;
    }

    public String getBranchName(int branchIndex) {
        if(branchIndex < branches.size()) {
            String[] keys = branches.keySet().toArray(new String[branches.keySet().size()]);
            return keys[branchIndex];
        }
        return null;
    }

    public int getBranchCount() {
        return branches.size();
    }

    public String[] getBranchSteps(int branchIndex) {
        if(branchIndex < branches.size()) {
            List<String> steps = branches.get(getBranchName(branchIndex));
            return steps.toArray(new String[steps.size()]);
        }
        return null;
    }

}