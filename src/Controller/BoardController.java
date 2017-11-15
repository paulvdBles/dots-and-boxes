package Controller;

import Model.BoardItem;
import Model.Box;
import Model.Dot;
import Model.Line;
import Shapes.BoxShape;
import Shapes.LineShape;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

import java.util.List;


public class BoardController {

    @FXML
    private Scene primaryScene;

    @FXML
    private Text gameTitle;

    @FXML
    private Pane menuPane;

    @FXML
    private Pane boardPane;

    private float positionX = 5;
    private float positionY = 5;

    void setPrimaryScene(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    void drawItemsOnBoard(List<List<BoardItem>> listOfBoardItems) {
        for (List<BoardItem> rowOfBoardItems : listOfBoardItems) {
            for (BoardItem item : rowOfBoardItems) {
                if (item instanceof Dot) {
                    createDot();
                }
                if (item instanceof Box) {
                    createBox((Box)item);
                }
                if (item instanceof Line) {
                    determineWhatTypeOfLineShouldBeMade(listOfBoardItems, rowOfBoardItems, (Line)item);
                }
            }
            positionX = 5;
            positionY = determinateWhatPositionYShouldBe(listOfBoardItems, positionY, rowOfBoardItems);
        }
    }

    private void createBox(Box boxObject) {
        BoxShape box = new BoxShape(boxObject);
        box.setHeight(75);
        box.setWidth(75);
        box.setLayoutX(positionX);
        box.setLayoutY(positionY);
        box.setFill(Color.WHITE);
        box.setStroke(Color.BLACK);
        box.setStrokeType(StrokeType.INSIDE);
        boardPane.getChildren().add(box);
        positionX += 74;
    }

    private void createDot() {
        Rectangle dot = new Rectangle();
        dot.setHeight(15);
        dot.setWidth(15);
        dot.setLayoutX(positionX);
        dot.setLayoutY(positionY);
        dot.setFill(Color.valueOf("#363b40"));
        dot.setStroke(Color.BLACK);
        dot.setStrokeType(StrokeType.INSIDE);
        boardPane.getChildren().add(dot);
        positionX += 14;
    }

    private void createLineAs(String type, Line lineObject) {
        LineShape line = new LineShape(lineObject);
//        Rectangle line = new Rectangle();

        if (type == "horizontal") {
            line.setHeight(15);
            line.setWidth(75);
            line.setLayoutX(positionX);
            positionX += 74;
        } else if (type == "vertical") {
            line.setHeight(75);
            line.setWidth(15);
            line.setLayoutX(positionX);
            positionX += 14;
        }

        line.setLayoutY(positionY);
        line.setFill(Color.valueOf("#d0e1f2"));
        line.setOnMouseEntered(e -> setOnLineEntered(line));
        line.setOnMouseExited(e -> setOnLineExited(line));
        line.setOnMouseClicked(e -> lineClicked());
        line.setStroke(Color.BLACK);
        line.setStrokeType(StrokeType.INSIDE);
        boardPane.getChildren().add(line);
    }

    private float determinateWhatPositionYShouldBe(List<List<BoardItem>> listOfBoardItems, float positionY, List<BoardItem> rowOfBoardItems) {
        if ((listOfBoardItems.indexOf(rowOfBoardItems) & 1) == 0) {
            positionY += 14;
        } else {
            positionY += 74;
        }
        return positionY;
    }

    private void determineWhatTypeOfLineShouldBeMade(List<List<BoardItem>> listOfBoardItems, List<BoardItem> rowOfBoardItems, Line line) {
        if ((listOfBoardItems.indexOf(rowOfBoardItems) & 1) == 0) {
            createLineAs("horizontal", line);
        } else {
            createLineAs("vertical", line);
        }
    }

    public void lineClicked() {
        System.out.println("Click!");
    }

    private void setOnLineEntered(Rectangle line) {
        line.setFill(Color.valueOf("#a6b1bb"));
        primaryScene.setCursor(Cursor.HAND);
    }

    private void setOnLineExited(Rectangle line) {
        line.setFill(Color.valueOf("#d0e1f2"));
        primaryScene.setCursor(Cursor.DEFAULT);
    }

}
