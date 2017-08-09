package Model;

import Controller.GUIInitializer;
import javafx.stage.Stage;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GameEngine {

    public void setupGame(Stage primaryStage) {
        setupGUI(primaryStage);
    }

    private void setupGUI(Stage primaryStage) {
        GUIInitializer GI = new GUIInitializer();
        GI.initializeGUI(primaryStage);
    }

}
