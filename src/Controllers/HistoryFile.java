package Controllers;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HistoryFile {
    private static int vBoxCount = 0;
    public static void appendingResultsRunTime(File file,VBox container) throws FileNotFoundException {
        vBoxCount++;
        List<String> tempResults = new ArrayList<>();
        Scanner take = new Scanner((File) file);
        while (take.hasNext())
            tempResults.add(take.next());
        VBox historyTab = new VBox();
        for(int i=0; i<tempResults.size();i++){
            Label left  = new Label(tempResults.get(i).substring(0,3));
            Label right = new Label(tempResults.get(i).substring(3));
            right.setId("historyRight");
            HBox historyRow = new HBox();
            historyRow.getChildren().addAll(left,right);
            historyTab.getChildren().add(historyRow);
        }
        if(vBoxCount%2==0)
            historyTab.setId("white");
        else
            historyTab.setId("grey");
        ((File) file).deleteOnExit();
        container.getChildren().add(historyTab);
    }

    public static void resultsToFiles(File file,List<Double> results,boolean temp) throws IOException {
        List<String> extra = Arrays.asList("PRI","PER","INT","PMT","FVA");
        PrintWriter out = null;
        FileWriter fileWriter = null;
        try {
            if(temp==true)
                fileWriter = new FileWriter((File) file,false);
            else
                fileWriter = new FileWriter((File) file,true);
            out = new PrintWriter(fileWriter, true);
            for (int i = 0; i < results.size(); i++) {
                String put = extra.get(i)+results.get(i);
                out.println(put);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
            out.close();
        }
    }

    public  static void saveLastEntries(File file, List<TextField> texts) throws IOException {
        List<String> extra = Arrays.asList("PRI","PER","INT","PMT","FVA");
        PrintWriter out = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter((File) file,false);
            out = new PrintWriter(fileWriter, true);
            for(TextField text : texts)
                out.println(text.getText()+"A");
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
            out.close();
        }
    }

    public static void rePop(File file, List<TextField> texts) throws FileNotFoundException {
        List<String> tempResults = new ArrayList<>();
        Scanner take = new Scanner((File) file);
        while (take.hasNext())
            tempResults.add(take.next());
        for (TextField text : texts) {
            String fix = tempResults.get(texts.indexOf(text));
            text.setText(fix.substring(0,fix.length()-1));
        }
    }
}
