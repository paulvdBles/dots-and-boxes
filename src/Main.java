import Controller.GUIInitializer;
import Model.GameEngine;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GUIInitializer guiInitializer = new GUIInitializer();
        GameEngine engine = new GameEngine(guiInitializer, primaryStage);
    }


}
