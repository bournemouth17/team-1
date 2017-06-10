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

    //Takes the filename of a json file and parses it into a InformationCard using org.json.simple.
    public InformationCard parseCardFromFile(String nameOfCard, Context context) throws ParseException, IOException {
        //Error checking
        if(nameOfCard.length() < 1 ) return null;
        if(nameOfCard.contains(".json")) nameOfCard = nameOfCard.substring(0, nameOfCard.length() - 5);
        InformationCard card;
        //Getting the file using the Asset manager and then parsing the resulting file.
        JSONParser parser = new JSONParser();
        AssetManager am = context.getAssets();
        Object object = parser.parse(new BufferedReader(new InputStreamReader(am.open(nameOfCard + ".json"))));
        JSONObject jsonObject = (JSONObject) object;
        //Getting the information cards name and number.
        String cardName = (String) jsonObject.get("card_name");
        long cardNumber = (Long) jsonObject.get("card_number");
        card = new InformationCard(cardName, (int)cardNumber);
        //Getting each of them markers from the json array
        JSONArray markers = (JSONArray) jsonObject.get("markers");
        for(int i = 0; i < markers.size(); i++) {
            card.addMarker((String) markers.get(i));
        }
        //Breaking down each branch into its name and steps.
        JSONArray branches = (JSONArray) jsonObject.get("branches");
        for(int i = 0; i < branches.size(); i++) {
            JSONObject branch = (JSONObject) branches.get(i);
            String branchName = (String) branch.get("branch_name");
            JSONArray steps = (JSONArray) branch.get("branch_steps");
            String[] stepArray = new String[steps.size()];
            for(int j = 0; j < steps.size(); j++) {
                stepArray[j] = (String) steps.get(j);
            }
            card.addBranch(branchName, stepArray);
        }
        return card;
    }

}
