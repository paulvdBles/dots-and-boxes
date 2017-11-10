package Controller;

import Model.GameEngine;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GUIInitializer {

    private GameEngine engine;
    private Stage primaryStage;

    public void initializeGUI(Stage primaryStage, GameEngine engine) {
        this.engine = engine;
        setTitle(primaryStage);
        loadSetupScreen(primaryStage);
        this.primaryStage = primaryStage;
    }

    private void setTitle(Stage primaryStage) {
        primaryStage.setTitle("Dots and boxes");
    }

    private void loadSetupScreen(Stage primaryStage) {
        FXMLLoader loader = instantiateFXMLLoader("Setup.fxml");
        loader.setController(new SetupController(this));
        setSetupSceneOnStage(primaryStage, loader); // TODO: Uitzoeken of ik deze methode kan schrijven met 1 parameter
        primaryStage.show();
    }

    private void loadBoardView(Stage primaryStage) {
        FXMLLoader loader = instantiateFXMLLoader("Board.fxml");
        setBoardSceneOnStage(primaryStage, loader); // TODO: Uitzoeken of ik deze methode kan schrijven met 1 parameter
        attachSceneToController(primaryStage, loader); // TODO: Uitzoeken of ik deze methode kan schrijven met 1 parameter
        primaryStage.show();
    }

    private void setSetupSceneOnStage(Stage primaryStage, FXMLLoader loader) {
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 400, 160));
        } catch (IOException e) {
            // TODO: Error vangen
        }
    }

    private void setBoardSceneOnStage(Stage primaryStage, FXMLLoader loader) {
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 415, 415));
        } catch (IOException e) {
            // TODO: Error vangen
        }
    }

    private FXMLLoader instantiateFXMLLoader(String fileName) {
        return new FXMLLoader(getClass().getResource("/View/" + fileName));
    }

    private void attachSceneToController(Stage primaryStage, FXMLLoader loader) {
        BoardController boardController = loader.getController();
        boardController.setScene(primaryStage.getScene());
    }

    void setRows(int input) {
        engine.setRows(input);
    }

    void setColumns(int input) {
        engine.setColumns(input);
    }

    boolean isRowsSet() {
        return engine.getRows() != 0;
    }

    boolean isColumnsSet() {
        return engine.getColumns() != 0;
    }


    void checkIfBoardIsReady() {
        if (isRowsSet() && isColumnsSet()){
            loadBoardView(primaryStage);
        }
    }
}
