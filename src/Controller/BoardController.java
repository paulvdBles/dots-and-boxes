package Controller;

import javafx.scene.Cursor;
import javafx.scene.Scene;

public class BoardController {

    private Scene scene;

    void setScene(Scene scene) {
        this.scene = scene;
    }

    public void lineClicked() {
        System.out.println("Click!");
    }

    public void setCursorHandOnMouseEntered() {
        scene.setCursor(Cursor.HAND);
    }

    public void setCursorDefaultOnMouseEntered() {
        scene.setCursor(Cursor.DEFAULT);
    }


}
