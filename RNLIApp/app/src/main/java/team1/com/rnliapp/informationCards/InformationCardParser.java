package team1.com.rnliapp.informationCards;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Alex on 09/06/2017.
 */

public class InformationCardParser {

    public static InformationCardParser getInstance() {
        if(instance == null) return new InformationCardParser();
        else return instance;
    }

    private static InformationCardParser instance = null;

    private InformationCardParser() {}
    //TODO Split into sub methods and maybe error check?
    public InformationCard parseCardFromFile(String nameOfCard) {
        InformationCard card;
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader("app/src/main/java/team1/com/rnliapp/informationCards/" + nameOfCard + ".json"));
            JSONObject jsonObject = (JSONObject) object;
            String cardName = (String) jsonObject.get("card_name");
            //System.out.println("Name: " + cardName);
            long cardNumber = (Long) jsonObject.get("card_number");
            card = new InformationCard(cardName, (int)cardNumber);
            //System.out.println("Number: " + cardNumber + "\nMarkers:");
            JSONArray markers = (JSONArray) jsonObject.get("markers");
            for(int i = 0; i < markers.size(); i++) {
                //System.out.println(markers.get(i));
                card.addMarker((String) markers.get(i));
            }
            JSONArray branches = (JSONArray) jsonObject.get("branches");
            for(int i = 0; i < branches.size(); i++) {
                JSONObject branch = (JSONObject) branches.get(i);
                String branchName = (String) branch.get("branch_name");
                //System.out.println(branchName + "'s Steps:");
                JSONArray steps = (JSONArray) branch.get("branch_steps");
                String[] stepArray = new String[steps.size()];
                for(int j = 0; j < steps.size(); j++) {
                    //System.out.println((j + 1) + ") " + steps.get(j));
                    stepArray[j] = (String) steps.get(j);
                }
                card.addBranch(branchName, stepArray);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return null;
        }
        return card;
    }

}
