package MP4.ModeState;

import MP4.Point;
import MP4.Pointable;
import MP4.Shape;
import MP4.ShapeContainer;

public class UnmarkMode extends Mode implements Pointable {

    public UnmarkMode(ShapeContainer shapeContainer){
        super(shapeContainer);
    }

    @Override
    public void pointerDown(Point point) {
        Shape selected = shapeContainer.getSelected();
        if (selected != null) {
            Shape unmarkedShape = selected.peel();
            shapeContainer.getShapes().remove(selected);
            shapeContainer.getShapes().add(unmarkedShape);
            shapeContainer.repaint();
        }
    }

    @Override
    public void pointerUp(Point point) {}

    @Override
    public void pointerMoved(Point point, boolean pointerDown) { }


}
