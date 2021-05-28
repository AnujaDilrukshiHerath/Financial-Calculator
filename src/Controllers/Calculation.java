package Controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class Calculation {
    public static List<Double> find(TextField one, TextField two, TextField three, TextField four , String decision){
        double returnValue = 0;
        String futureOption      = "Future Value";
        String interestOption    = "Annual Interest";
        String principalOption   = "Starting Principal";
        String periodOption      = "No. of Periods";
        String monthPayOption    = "Monthly Deposit";
        double futureValue = 0 ;
        double principal   = 0 ;
        double pmt = 0 ;
        double rate = 0 ;
        double periods = 0;
        if(decision.equals(futureOption)) {
            futureValue = -1;
            principal = Double.parseDouble(one.getText());
            rate = Double.parseDouble(two.getText());
            periods = Double.parseDouble(three.getText());
            pmt = Double.parseDouble(four.getText());
        }

        else if(decision.equals(interestOption)) {
            rate = -1;
            principal = Double.parseDouble(one.getText());
            periods = Double.parseDouble(two.getText());
            futureValue = Double.parseDouble(three.getText());
        }

        else if(decision.equals(periodOption)) {
            periods = -1;
            principal = Double.parseDouble(one.getText());
            rate = Double.parseDouble(two.getText());
            pmt = Double.parseDouble(three.getText());
            futureValue = Double.parseDouble(four.getText());
        }

        else if(decision.equals(monthPayOption)) {
            pmt = -1;
            principal = Double.parseDouble(one.getText());
            rate = Double.parseDouble(two.getText());
            periods = Double.parseDouble(three.getText());
            futureValue = Double.parseDouble(four.getText());
        }

        else if(decision.equals(principalOption)) {
            principal = -1;
            rate = Double.parseDouble(one.getText());
            periods = Double.parseDouble(two.getText());
            pmt = Double.parseDouble(three.getText());
            futureValue = Double.parseDouble(four.getText());
        }
//Calculation part Starts here

        if(futureValue==-1){
            futureValue = principal*(Math.pow(1+(rate/(100*12)),periods*12)) + pmt*((Math.pow(1+(rate/(100*12)),periods*12)-1)/(rate/(12*100.0)));
            futureValue = Math.round(futureValue*100.0)/100.0;
        }
        else if(rate==-1) {
            rate = Math.round(12 * 100 * (Math.pow((futureValue / principal), (1 / (periods * 12))) - 1));
        }

        else if(principal ==-1){
            principal = (futureValue - pmt*((Math.pow(1+(rate/(100*12)),periods*12)-1)/(rate/(12*100.0))))/Math.pow((1+rate/(100*12)),periods*12);
            principal = Math.round(principal*100)/100.0;
        }
        else if(periods==-1){
            periods = (Math.log((futureValue*(rate/(100*12))+pmt)/(principal*(rate/(100*12))+pmt))/(Math.log(1+rate/(100*12))))/12;
            periods = Math.round(periods*100.0)/100.0;
        }
        else if(pmt==-1){
            pmt = (futureValue- (principal*(Math.pow(1+(rate/(100*12)),periods*12))))/((Math.pow((1+rate/(12*100)),12*periods)-1)/(rate/(12*100)));
            pmt = Math.round(pmt*100.0)/100.0;
        }
        List<Double> finalAnswer = Arrays.asList(principal,periods,rate,pmt,futureValue);
        return finalAnswer;
    }

    public static void changingLabels(List<Button> buttonList,List<String> labels){
        for(int i=0;i<labels.size();i++){
            buttonList.get(i).setText(labels.get(i));
        }
        Stylist.setSpace(buttonList);
    }
}
