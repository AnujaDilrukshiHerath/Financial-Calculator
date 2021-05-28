import Controllers.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FinanceCalculator extends Application{
    public static  void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //File Storage
        File tempHistoryFile = new File("cache/tempHistory.txt");
        File historyFile = new File("cache/history.txt");
        File rePopFile = new File("cache/lastEntries.txt");
        //Option Box Created here
        String futureValueOption = "Future Value";
        String interestOption    = "Annual Interest";
        String principalOption   = "Starting Principal";
        String periodOption      = "No. of Periods";
        String monthPayOption    = "Monthly Deposit";
        List<String> futureValueLabels = Arrays.asList(principalOption,interestOption,periodOption,monthPayOption);
        List<String> interestLabels    = Arrays.asList(principalOption,periodOption,futureValueOption,monthPayOption);
        List<String> periodLabels      = Arrays.asList(principalOption,interestOption,monthPayOption,futureValueOption);
        List<String> monthPayLabels    = Arrays.asList(principalOption,interestOption,periodOption,futureValueOption);
        List<String> principalLabels   = Arrays.asList(interestOption,periodOption,monthPayOption,futureValueOption);
        ComboBox<String> whatCal = new ComboBox<>();
        whatCal.getItems().addAll(futureValueOption,interestOption,monthPayOption,periodOption,principalOption);
        whatCal.setValue(futureValueOption);
        whatCal.setMaxSize(1000,1000);

        //KeyBoard Buttons are created here
        Button buttonZero = new Button("0");
        Button buttonOne = new Button("1");
        Button buttonTwo = new Button("2");
        Button buttonThree = new Button("3");
        Button buttonFour = new Button("4");
        Button buttonFive = new Button("5");
        Button buttonSix = new Button("6");
        Button buttonSeven = new Button("7");
        Button buttonEight = new Button("8");
        Button buttonNine = new Button("9");
        Button buttonDecimal = new Button(".");
        Button buttonDelete = new Button("DEL");
        Button buttonClear = new Button("CLEAR");
        Button buttonCalculate = new Button("CALCULATE");
        List<Button> keyBoardButtons = Arrays.asList(buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonDecimal, buttonDelete, buttonClear, buttonCalculate);

        GridPane keyboard = new GridPane();
        keyboard.setId("keyboard");
        ColumnConstraints keyBoardColumns = new ColumnConstraints(275);
        RowConstraints keyBoardRows = new RowConstraints(125);
        keyboard.getColumnConstraints().addAll(keyBoardColumns, keyBoardColumns, keyBoardColumns, keyBoardColumns);
        keyboard.getRowConstraints().addAll(keyBoardRows, keyBoardRows, keyBoardRows, keyBoardRows);
        keyboard.add(whatCal, 0, 0,2,1);
        keyboard.add(buttonSeven, 0, 1);
        keyboard.add(buttonFour, 0, 2);
        keyboard.add(buttonOne, 0, 3);

        keyboard.add(buttonEight, 1, 1);
        keyboard.add(buttonFive, 1, 2);
        keyboard.add(buttonTwo, 1, 3);

        keyboard.add(buttonClear, 2, 0);
        keyboard.add(buttonNine, 2, 1);
        keyboard.add(buttonSix, 2, 2);
        keyboard.add(buttonThree, 2, 3);

        keyboard.add(buttonCalculate, 3, 0);
        keyboard.add(buttonDelete, 3, 1);
        keyboard.add(buttonZero, 3, 2);
        keyboard.add(buttonDecimal, 3, 3);

        GridPane display = new GridPane();
        display.setId("display");

//        Button buttonMenu   = new Button("MENU");
        Label title   = new Label("Compound Interest Calculator");
        title.setId("title");
        title.setPadding(new Insets(0,0,0,10));
//        buttonMenu.setId("menuButton");

        Button buttonRowOne   = new Button(principalOption);
        TextField textRowOne  = new TextField();

        Button buttonRowTwo   = new Button(interestOption);
        TextField textRowTwo  = new TextField();

        Button buttonRowThree = new Button(periodOption);
        TextField textRowThree= new TextField();

        Button buttonRowFour  = new Button(monthPayOption);
        TextField textRowFour = new TextField();


        display.add(title,0,0,2,1);
//        display.add(buttonMenu,0,0);
        display.add(buttonRowOne,0,1,2,1);
        display.add(textRowOne,1,1);
        display.add(buttonRowTwo,0,2,2,1);
        display.add(textRowTwo,1,2);
        display.add(buttonRowThree,0,3,2,1);
        display.add(textRowThree,1,3);
        display.add(buttonRowFour,0,4,2,1);
        display.add(textRowFour,1,4);

        List<Button> inputButtonList = Arrays.asList(buttonRowOne,buttonRowTwo,buttonRowThree,buttonRowFour);

        List<TextField> inputTextList = Arrays.asList(textRowOne,textRowTwo,textRowThree,textRowFour);

        VBox displayAnswer = new VBox();
        displayAnswer.setId("displayAnswer");
        display.add(displayAnswer,2,1,1,4);
        HBox displayRowOne   = new HBox();
        HBox displayRowTwo   = new HBox();
        HBox displayRowThree = new HBox();
        HBox displayRowFour  = new HBox();
        HBox displayRowFive  = new HBox();
        List<HBox> displayHboxes = Arrays.asList(displayRowOne,displayRowTwo,displayRowThree,displayRowFour,displayRowFive);
        displayAnswer.getChildren().addAll(displayHboxes);

        Label displayFutureLabel  = new Label("");
        Label displayFutureAnswer = new Label("");

        Label displayPrincipalLabel  = new Label("");
        Label displayPrincipalAnswer = new Label("");

        Label displayPeriodLabel  = new Label("");
        Label displayPeriodAnswer = new Label("");

        Label displayMonthLabel  = new Label("");
        Label displayMonthAnswer = new Label("");

        Label displayRateLabel  = new Label("");
        Label displayRateAnswer = new Label("");

        List<Label> displayLabels  = Arrays.asList(displayPrincipalLabel,displayPeriodLabel,displayRateLabel,displayMonthLabel,displayFutureLabel);
        List<Label> displayAnswersList = Arrays.asList(displayPrincipalAnswer,displayPeriodAnswer,displayRateAnswer,displayMonthAnswer,displayFutureAnswer);

        RowConstraints displayRows = new RowConstraints(100);
        ColumnConstraints displayColumn = new ColumnConstraints(275);
        ColumnConstraints displayGetColumn = new ColumnConstraints(275);
        ColumnConstraints displayAnswerColumn = new ColumnConstraints(550);
        display.getRowConstraints().addAll(displayRows,displayRows,displayRows,displayRows,displayRows);
        display.getColumnConstraints().addAll(displayColumn,displayGetColumn,displayAnswerColumn);

        Label historyLabel = new Label("History");
        historyLabel.setId("historyTitle");
        ScrollPane historyPane = new ScrollPane();
        historyPane.setId("historyPane");
        VBox container = new VBox();
        container.getChildren().add(historyLabel);
        historyPane.setContent(container);

        GridPane main = new GridPane();
        ColumnConstraints mainColumn = new ColumnConstraints(1100);
        ColumnConstraints historyColumn = new ColumnConstraints(400);
        RowConstraints mainRows = new RowConstraints(500);
        main.getColumnConstraints().addAll(mainColumn,historyColumn);
        main.getRowConstraints().addAll(mainRows,mainRows);
        main.add(display,0,0);
        main.add(keyboard,0,1);
        main.add(historyPane,1,0,1,2);

        AnchorPane anchorPane = new AnchorPane(main);
        Scene scene = new Scene(anchorPane,1500,1000);
        scene.getStylesheets().addAll("StyleSheets/keyBoard.css", "StyleSheets/display.css", "StyleSheets/displayAnswer.css", "StyleSheets/historyPane.css");
        primaryStage.setScene(scene);
        primaryStage.show();

//        Styling Part
        Stylist.focusStyle(inputButtonList,0,textRowOne);
        Stylist.setSize((List<Button>) keyBoardButtons);
        Stylist.setSize(inputButtonList);
        Stylist.setSpace(inputButtonList);
        Stylist.setIdLabels(displayLabels,"Label");
        Stylist.setIdLabels(displayAnswersList,"Answer");
        Stylist.hBoxSetStyle(displayHboxes);
        Stylist.hBoxAddChild(displayHboxes,displayLabels,displayAnswersList);
        HistoryFile.rePop(rePopFile,inputTextList);
        whatCal.focusedProperty().addListener(observable1 -> {Stylist.focusStyle(inputButtonList);});
        historyPane.focusedProperty().addListener(observable1 -> {Stylist.focusStyle(inputButtonList);});

//        buttonMenu.focusedProperty().addListener(observable1 -> {Stylist.focusStyle(inputButtonList);});

//        Listeners
        for(Button input : inputButtonList){
            input.focusedProperty().addListener((observable, oldValue, newValue) -> {
                int index = inputButtonList.indexOf(input);
                inputTextList.get(index).requestFocus();
                inputTextList.get(index).appendText("");
                Stylist.focusStyle(inputButtonList,index);
            });
        }
        for(TextField text : inputTextList){
            text.focusedProperty().addListener((observable, oldValue, newValue) -> {
                int index = inputTextList.indexOf(text);
                Stylist.focusStyle(inputButtonList,index);
                Controls.printKey(text,keyBoardButtons,inputTextList);
            });
        }
//        Validation Parts
        Validation.keyboardValidation(inputTextList);
        Validation.decimalCheck(inputTextList);

//        CalChange
        whatCal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(futureValueOption))
                Calculation.changingLabels(inputButtonList,futureValueLabels);
            else if(newValue.equals(principalOption))
                Calculation.changingLabels(inputButtonList,principalLabels);
            else if(newValue.equals(interestOption))
                Calculation.changingLabels(inputButtonList,interestLabels);
            else if(newValue.equals(monthPayOption))
                Calculation.changingLabels(inputButtonList,monthPayLabels);
            else if(newValue.equals(periodOption))
                Calculation.changingLabels(inputButtonList,periodLabels);
            if(newValue.equals(interestOption)){
                textRowFour.setDisable(true);
                buttonRowFour.setDisable(true);
            }
            else{
                textRowFour.setDisable(false);
                buttonRowFour.setDisable(false);
            }
            Stylist.clearFields(inputTextList);
            Stylist.clearLabels(displayAnswersList);
            Stylist.clearLabels(displayLabels);
        });
        buttonClear.setOnAction(e->{
            Stylist.clearLabels(displayAnswersList);
            Stylist.clearLabels(displayLabels);});
//        Calculation
        buttonCalculate.setOnAction(e -> {
            boolean everythingOkay = Validation.emptyCheck(inputTextList,whatCal.getValue());
            if(everythingOkay==true) {
                List<Double> finalValue = Calculation.find(textRowOne, textRowTwo, textRowThree, textRowFour, whatCal.getValue());
                List<String> labels = Arrays.asList(principalOption,periodOption,interestOption,monthPayOption,futureValueOption);
                Controls.printAnswers(displayLabels,labels,displayAnswersList,finalValue);
                try {
                    HistoryFile.resultsToFiles(historyFile,finalValue,false);
                    HistoryFile.resultsToFiles(tempHistoryFile,finalValue,true);
                    HistoryFile.appendingResultsRunTime(tempHistoryFile,container);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        primaryStage.setOnCloseRequest(e-> {
            tempHistoryFile.deleteOnExit();
            try {
                HistoryFile.saveLastEntries(rePopFile,inputTextList);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
