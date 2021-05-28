package Controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.List;

public class Stylist {
    public static void setSize(List<Button> list) {
        for (Button button : list)
            button.setMaxSize(3000, 3000);
        setId(list);
    }

    public static void setId(List<Button> list) {
        for (Button button : list)
            button.setId("button" + button.getText());
    }

    public static void setIdLabels(List<Label> list,String finder) {
        for (Label button : list)
            button.setId("label"+finder+ list.indexOf(button));
    }

    public static void setSpace(List<Button> list) {
        for (Button button : list) {
            String label = button.getText();
            int end = button.getText().length();
            end = 50 - end;
            for (int i = 0; i < end; i++)
                label = label + " ";
            button.setText(label);
        }
    }

    public static void focusStyle(List<Button> buttonList, int index) {
        for (Button button : buttonList) {
            if (buttonList.indexOf(button) == index) {
                button.setStyle("-fx-background-color: black;" +
                        "-fx-text-fill: white");
            } else {
                button.setStyle("-fx-background-color: none;" +
                        "-fx-text-fill: black");
            }
        }
    }

    public static void focusStyle(List<Button> buttonList, int index, TextField textField) {
        for (Button button : buttonList) {
            if (buttonList.indexOf(button) == index) {
                button.setStyle("-fx-background-color: black;" +
                        "-fx-text-fill: white");
            } else {
                button.setStyle("-fx-background-color: none;" +
                        "-fx-text-fill: black");
            }
        }
        textField.requestFocus();
    }

    public static void focusStyle(List<Button> offButtonList) {
        for (Button button : offButtonList) {
            button.setStyle("-fx-background-color: none;" +
                    "-fx-text-fill: black");
        }
    }

    public static void hBoxAddChild(List<HBox> parent, List<Label> childLeft,List<Label>childRight){
        for(int i=0; i<parent.size();i++){
            parent.get(i).getChildren().addAll(childLeft.get(i),childRight.get(i));
        }
    }
    public static void hBoxSetStyle(List<HBox> list){
        for(HBox box : list) {
            box.setSpacing(0);
            box.setId("hb"+list.indexOf(box));
        }
    }

    public static void clearFields(List<TextField> texts){
        for(TextField text: texts){
            text.clear();
        }
    }

    public static void clearLabels(List<Label> texts){
        for(Label text: texts){
            text.setText("");
        }
    }
}

