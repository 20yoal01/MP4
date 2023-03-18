package MP4.ModeState;

import MP4.*;

public class InsertMode extends Mode implements Pointable {

    public InsertMode(ShapeContainer shapeContainer){
        super(shapeContainer);
    }

    @Override
    public void pointerDown(Point point) {
        switch (shapeContainer.getShapeMode()) {
            case CIRCLE:
                shapeContainer.getShapes().add(new Circle(point, Math.random() * 50.0));
                break;
            case RECTANGLE:
                shapeContainer.getShapes().add(new Rectangle(point, 40, 60));
                break;
        }
        shapeContainer.repaint(); // uppmanar swing att måla om
    }

    @Override
    public void pointerUp(Point point) {}

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {}

}
