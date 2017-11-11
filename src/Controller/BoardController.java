package Controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class BoardController {

    @FXML
    private Scene primaryScene;

    @FXML
    private Text gameTitle;

    @FXML
    private Pane menuPane;

    @FXML
    private Pane boardPane;

    void setPrimaryScene(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    public void drawBoard(int columns, int rows) {
        // draw the dots on the board
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            StringBuilder str = new StringBuilder();
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                str.append("[] ");
            }
            System.out.println(str);
        }
        boardPane.getChildren().add(new Rectangle());

        // draw the lines on the board

    }

    public void lineClicked() {
        System.out.println("Click!");
    }

    public void setCursorHandOnMouseEntered() {
        primaryScene.setCursor(Cursor.HAND);
    }

    public void setCursorDefaultOnMouseEntered() {
        primaryScene.setCursor(Cursor.DEFAULT);
    }


}
