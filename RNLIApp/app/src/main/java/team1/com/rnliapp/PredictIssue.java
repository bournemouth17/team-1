package team1.com.rnliapp;

import java.util.ArrayList;

/**
 * Created by 1998d on 09/06/2017.
 */

public class PredictIssue {
    int[] patient = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] card = {{0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 6, 0},
                    {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 30, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 30, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 30, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 30, 0},
                    {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 30, 0},
                    {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 30, 0},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 30, 0},
                    {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 30, 1},
                    {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 30, 1},
                    {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 30, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 1},
                    {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 30, 1},
                    {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 30, 0},
                    {0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                    {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0}};
    int[] result = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    ArrayList<Integer> cards = new ArrayList<Integer>();

    //checks to see if the symptoms inputted match any illness/cause
    protected int[] compareArray(){
      for(int i=0; i<19; i++){
          boolean match = true;
          for(int j=0; j<12; j++){
              if(j==10){
                    System.out.println("IF");
                  if(patient[j]<=12 && card[i][j]<=12){System.out.println("MID");}
                  else if(patient[j]<30 && card[i][j]<30){}
                  else if(patient[j]>30 && card[i][j]>30){}
                  else{
                      result[i] = 0;
                      match = false;
                      break;
                  }
              }
              else if(patient[j] != card[i][j]){
                  result[i] = 0;
                  match = false;
                  break;
              }
          }
          if(match){
              cards.add(i);
          }
      }
      int[] finalResult = new int[cards.size()];
      for(int i=0; i<cards.size(); i++){
          finalResult[i] = cards.get(i)+1;
          System.out.print(finalResult[i] + ", ");
      }
      System.out.println();
      return finalResult;
    }

    //adds a symptom to the patient's profile
    protected void addInput(int index, int result){
        patient[index] = result;
        System.out.println("RESULT: " + patient[index]);
    }

    protected void clearPatient(){
        int[] patient = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
