package team1.com.rnliapp.informationCards;

import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by Alex on 10/06/2017.
 */

public class InformationCardReader {

    private static final int CARD_COUNT = 19;

    private int branchCount = 0, branchStepCounter = 0, currentBranchIndex = 0;
    private int[] branchSteps;
    private InformationCard card = null;

    public InformationCardReader(int cardNumber) {
        if(cardNumber < CARD_COUNT || cardNumber > -1) {
            card = retreiveCard(cardNumber);
            branchCount = card.getBranchCount();
            branchSteps = new int[branchCount];
            for(int i = 0; i < branchCount; i++) {
                branchSteps[i] = card.getBranchSteps(i).length;
            }
        }
    }

    private InformationCard retreiveCard(int cardNumber) {
        InformationCard card = null;
        try {
            card = InformationCardParser.getInstance().parseCardFromFile("Card_" + cardNumber);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return card;
    }

}
