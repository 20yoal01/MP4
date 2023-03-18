package MP4.ModeState;

import MP4.Point;
import MP4.Shape;
import MP4.ShapeContainer;

public class DeleteMode extends Mode {

    public DeleteMode(ShapeContainer shapeContainer){
        super(shapeContainer);
    }

    @Override
    public void pointerDown(Point point) {
        Shape selected = shapeContainer.getSelected();
        if (selected != null)
            shapeContainer.getShapes().remove(selected);
        selected = null;
        shapeContainer.repaint(); // uppmanar swing att måla om
    }

    @Override
    public void pointerUp(Point point) {}

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {

    }

}
