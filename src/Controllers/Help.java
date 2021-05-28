package Controllers;

import javafx.scene.layout.HBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Help {
    public static void viewHelp() throws FileNotFoundException {
        File helpFile = new File("cache/tempHistory.txt");
        List<String> tempResults = new ArrayList<>();
        Scanner take = new Scanner((File) helpFile);
        while (take.hasNext())
            tempResults.add(take.next());
        //Should add these things to a Vbox and display in a new window on request.
    }
}
