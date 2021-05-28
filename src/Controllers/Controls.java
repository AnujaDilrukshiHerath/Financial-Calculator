package Controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Controls {
    private static int clearCount = 0;
    public static void printKey(TextField currentText, List<Button> buttonList, List<TextField> clearingPurpose) {
        for (Button button : buttonList) {

            button.setFocusTraversable(false);
            button.setOnMouseClicked(e -> {
                Controls.tempKeyboardValidation(clearingPurpose, currentText.getText());
                currentText.requestFocus();
                int value = buttonList.indexOf(button);
                if (value == 10)
                    currentText.appendText(".");
                else if (value == 11) {
                    try {
                        String delete = currentText.getText();
                        delete = delete.substring(0, delete.length() - 1);
                        currentText.setText(delete);
                    } catch (Exception event) {
                    }
                } else if (value == 12) {
                    currentText.clear();
                } else if (value == 13) {
                } // Calculate Button
                else {
                    currentText.appendText("" + value);
                }
                if (value == 12)
                    clearCount++;
                else
                    clearCount=0;
                if(clearCount==2)
                    Stylist.clearFields(clearingPurpose);
                Validation.keyboardValidation(clearingPurpose);
                currentText.appendText("");
            });
        }
    }

    public static void tempKeyboardValidation(List<TextField> list, String check) {
        for (TextField text : list) {
            UnaryOperator<TextFormatter.Change> filter = change -> {
                return change;
            };
            TextFormatter<String> onScreenFormatter = new TextFormatter<String>(filter);
            text.setTextFormatter(onScreenFormatter);
        }
    }

    public static void printAnswers(List<Label> labelSpot,List<String> label,List<Label> answerSpot,List<Double> answer){
        List<String> extra = Arrays.asList("(PRI)","(PER)","(INT)","(PMT)","(FVA)");
        for(int i=0; i<label.size();i++){
            labelSpot.get(i).setText(" "+label.get(i)+" "+extra.get(i));
            answerSpot.get(i).setText(""+answer.get(i));
        }
    }
}
