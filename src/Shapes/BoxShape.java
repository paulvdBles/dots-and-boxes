package Shapes;

import Model.Box;
import javafx.scene.shape.Rectangle;

public class BoxShape  extends Rectangle {
    private Box boxObject;

    public BoxShape(Box boxObject) {
        this.boxObject = boxObject;
    }
}
