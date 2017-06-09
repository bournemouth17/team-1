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
    private List<String> markers = new ArrayList<>(), notes = new ArrayList<>();;
    private Hashtable<String, List<String>> branches = new Hashtable<>();

    public InformationCard(String cardName) { informationCardName = cardName; }

    public InformationCard(String informationCardName, String importantInfo, List<String> markers, List<String> notes, Hashtable<String, List<String>> branches) {
        this.informationCardName = informationCardName;
        this.importantInfo = importantInfo;
        this.markers = markers;
        this.notes = notes;
        this.branches = branches;
    }

    public void addImportantInfo(String importantInfo) {
        if(importantInfo.length() > 1) {
            this.importantInfo = importantInfo;
        }
    }

    public void addMarker(String marker) {
        if(!marker.contains(marker.toUpperCase()) && marker.length() > 0) {
            markers.add(marker.toUpperCase());
        }
    }

    public void addMarkers(String[] markers) {
        for(int i = 0; i < markers.length; i++) {
            addMarker(markers[i]);
        }
    }

    public void addMarkers(List<String> markers) {
        for(int i = 0; i < markers.size(); i++) {
            addMarker(markers.get(i));
        }
    }

    public void addNote(String note) {
        if(!notes.contains(note.toUpperCase()) && note.length() > 1) {
            notes.add(note.toUpperCase());
        }
    }

    public void addNotes(String[] notes) {
        for(int i = 0; i < notes.length; i++) {
            addNote(notes[i]);
        }
    }

    public void addNotes(List<String> notes) {
        for(int i = 0; i < notes.size(); i++) {
            addNote(notes.get(i));
        }
    }

    public void addBranch(String branchName, String[] branchSteps) {
        if(!branches.containsKey(branchName.toUpperCase()) && branchSteps.length != 0) {
            branches.put(branchName.toUpperCase(), new ArrayList<>(Arrays.asList(branchSteps)));
        }
    }

    public void addBranch(String branchName, List<String> branchSteps) {
        if(!branches.containsKey(branchName.toUpperCase()) && branchSteps.size() != 0) {
            branches.put(branchName.toUpperCase(), branchSteps);
        }
    }

    public String getInformationCardName() {
        return informationCardName;
    }

    public String getImportantInfo() {
        return importantInfo;
    }
    
}