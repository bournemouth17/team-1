package team1.com.rnliapp.informationCards;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public InformationCard parseCardFromFile(String nameOfCard, Context context) throws ParseException, IOException {
        if(nameOfCard.length() < 1 ) return null;
        if(nameOfCard.contains(".json")) nameOfCard = nameOfCard.substring(0, nameOfCard.length() - 5);
        InformationCard card;
        JSONParser parser = new JSONParser();
        AssetManager am = context.getAssets();
        Object object = parser.parse(new BufferedReader(new InputStreamReader(am.open(nameOfCard + ".json"))));
        JSONObject jsonObject = (JSONObject) object;
        String cardName = (String) jsonObject.get("card_name");
        System.out.println("Name: " + cardName);
        long cardNumber = (Long) jsonObject.get("card_number");
        card = new InformationCard(cardName, (int)cardNumber);
        System.out.println("Number: " + cardNumber + "\nMarkers:");
        JSONArray markers = (JSONArray) jsonObject.get("markers");
        for(int i = 0; i < markers.size(); i++) {
            System.out.println(markers.get(i));
            card.addMarker((String) markers.get(i));
        }
        JSONArray branches = (JSONArray) jsonObject.get("branches");
        for(int i = 0; i < branches.size(); i++) {
            JSONObject branch = (JSONObject) branches.get(i);
            String branchName = (String) branch.get("branch_name");
            System.out.println(branchName + "'s Steps:");
            JSONArray steps = (JSONArray) branch.get("branch_steps");
            String[] stepArray = new String[steps.size()];
            for(int j = 0; j < steps.size(); j++) {
                System.out.println((j + 1) + ") " + steps.get(j));
                stepArray[j] = (String) steps.get(j);
            }
            card.addBranch(branchName, stepArray);
        }
        return card;
    }

}
