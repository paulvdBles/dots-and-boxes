package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GUIInitializer {

    public void initializeGUI(Stage primaryStage) {
        setTitle(primaryStage);
        FXMLLoader loader = instantiateLoader();
        setSceneOnStage(primaryStage, loader); // TODO: Uitzoeken of ik deze methode kan schrijven met 1 parameter
        setSceneOnController(primaryStage, loader); // TODO: Uitzoeken of ik deze methode kan schrijven met 1 parameter
        primaryStage.show();
    }

    private void setTitle(Stage primaryStage) {
        primaryStage.setTitle("Dots and boxes");
    }

    private FXMLLoader instantiateLoader() {
        return new FXMLLoader(getClass().getResource("/View/GUI.fxml"));
    }

    private void setSceneOnStage(Stage primaryStage, FXMLLoader loader) {
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 415, 415));
        } catch (IOException e) {
            // TODO: Error vangen
        }
    }

    private void setSceneOnController(Stage primaryStage, FXMLLoader loader) {
        BoardController boardController = loader.getController();
        boardController.setScene(primaryStage.getScene());
    }
}
