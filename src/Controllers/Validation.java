package Controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.List;
import java.util.function.UnaryOperator;

public class Validation {
    public static void keyboardValidation(List<TextField> list){
        for(TextField text : list) {
            UnaryOperator<TextFormatter.Change> filter = change -> {
                String check = change.getText();
                if (check.matches("[0-9]*") || check.matches("[.]")) {
                    return change;
                }
                return null;
            };
            TextFormatter<String> mainKeyboardFormatter = new TextFormatter<String>(filter);
            text.setTextFormatter(mainKeyboardFormatter);
        }
    }

    public static boolean emptyCheck(List<TextField> list,String interest){
        for(TextField text : list){
            String check = text.getText();
            if(check.isEmpty() && interest.equals("Annual Interest")==false){
                Alert message = new Alert(Alert.AlertType.ERROR);
                message.setTitle("Empty Error");
                message.setHeaderText("Don't leave the fields empty");
                message.showAndWait();
                return false;
            }
        }
        return true;
    }

    public static void decimalCheck(List<TextField> textList){
        try {
            for (TextField text : textList) {
                text.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (twoDecimal(newValue)) {
                        try {
                            String delete = text.getText();
                            delete = delete.substring(0, delete.length() - 1);
                            text.setText(delete);
                        } catch (Exception event) { }
                    }
                });
            }
        }catch(StackOverflowError e){

        }

    }

    public static boolean twoDecimal(String text){
        int checkCount = 0;
        for(int i=0;i<text.length();i++){
            String check = text.substring(i,i+1);
            if(check.equals("."))
                checkCount++;
            if(checkCount==2)
                return true;
        }
        return false;
    }
}
