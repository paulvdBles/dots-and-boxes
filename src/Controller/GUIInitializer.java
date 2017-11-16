package Controller;

import Model.BoardBuilder;
import Model.GameEngine;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GUIInitializer {

    private GameEngine engine;
    private Stage primaryStage;
    private BoardController boardController;

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

    private void setTitle(Stage primaryStage) {
        primaryStage.setTitle("Dots and boxes");
    }

    public void initializeGUI(Stage primaryStage, GameEngine engine) {
        this.engine = engine;
        setTitle(primaryStage);
        loadSetupScreen(primaryStage);
        this.primaryStage = primaryStage;
    }

    private void loadSetupScreen(Stage primaryStage) {
        FXMLLoader loader = instantiateFXMLLoader("Setup.fxml");
        loader.setController(new SetupController(this));
        setSetupSceneOnStage(primaryStage, loader); // TODO: Uitzoeken of ik deze methode kan schrijven met 1 parameter
        primaryStage.show();
    }

    private void attachSceneToController(Stage primaryStage) {
        boardController.setPrimaryScene(primaryStage.getScene());
    }

    void checkIfBoardIsReady() {
        if (isRowsSet() && isColumnsSet()){
            buildBoard(primaryStage);
        }
    }

    private void buildBoard(Stage primaryStage) {
        FXMLLoader loader = instantiateFXMLLoader("Board.fxml");
        setBoardSceneOnStage(primaryStage, loader);
        setBoardControllerReference(loader);
        attachSceneToController(primaryStage);
        List listOfBoardItems = new BoardBuilder().configureBoardItems(loader, engine);
        boardController.drawItemsOnBoard(listOfBoardItems);
        primaryStage.show();
    }

    private void setBoardControllerReference(FXMLLoader loader) {
        boardController = loader.getController();
    }


    private FXMLLoader instantiateFXMLLoader(String fileName) {
        return new FXMLLoader(getClass().getResource("/View/" + fileName));
    }

    private void setSetupSceneOnStage(Stage primaryStage, FXMLLoader loader) {
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            // TODO: Error vangen
        }
    }

    private void setBoardSceneOnStage(Stage primaryStage, FXMLLoader loader) {
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            // TODO: Error vangen
        }
    }
}
